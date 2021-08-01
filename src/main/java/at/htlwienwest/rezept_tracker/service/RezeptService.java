package at.htlwienwest.rezept_tracker.service;

import at.htlwienwest.rezept_tracker.data.entity.Rezept;
import at.htlwienwest.rezept_tracker.data.entity.RezeptZutat;
import at.htlwienwest.rezept_tracker.data.entity.Zutat;
import at.htlwienwest.rezept_tracker.data.repository.RezeptRepository;
import at.htlwienwest.rezept_tracker.data.repository.RezeptZutatRepository;
import at.htlwienwest.rezept_tracker.data.repository.ZutatRepository;
import at.htlwienwest.rezept_tracker.dto.RezeptDTO;
import at.htlwienwest.rezept_tracker.dto.ZutatDTO;
import at.htlwienwest.rezept_tracker.exception.RezeptNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RezeptService {
    private final RezeptRepository rezeptRepository;
    private final ZutatRepository zutatRepository;
    private final RezeptZutatRepository rezeptZutatRepository;

    @Autowired
    public RezeptService(RezeptRepository rezeptRepository,
                         ZutatRepository zutatRepository,
                         RezeptZutatRepository rezeptZutatRepository) {
        this.rezeptRepository = rezeptRepository;
        this.zutatRepository = zutatRepository;
        this.rezeptZutatRepository = rezeptZutatRepository;
    }

    public Iterable<Rezept> getRezepte() {
        return rezeptRepository.findAll();
    }

    public Optional<Rezept> getById(Long id) {
        return rezeptRepository.findById(id);
    }

    public Rezept replaceRezept(RezeptDTO newRezept, Long id) {
        return rezeptRepository.findById(id)
                .map(rezept -> {
                    rezept.setTitel(newRezept.getTitel());
                    rezept.setBeschreibung(newRezept.getBeschreibung());
                    return addRezeptZutatenFromDTO(rezept, newRezept);
                })
                .orElseGet(() -> {
                    Rezept rezept = rezeptRepository.save(new Rezept(newRezept.getTitel(), newRezept.getBeschreibung()));
                    return addRezeptZutatenFromDTO(rezept, newRezept);
                });
    }

    public Rezept createRezept(RezeptDTO rezeptDTO) {
        Rezept rezept = rezeptRepository.save(new Rezept(rezeptDTO.getTitel(), rezeptDTO.getBeschreibung()));

        return addRezeptZutatenFromDTO(rezept, rezeptDTO);
    }

    public void deleteRezept(Long id) {
        if(rezeptRepository.existsById(id)) {
            rezeptRepository.deleteById(id);
        } else {
            throw new RezeptNotFoundException(id);
        }
    }

    private Rezept addRezeptZutatenFromDTO(Rezept rezept, RezeptDTO rezeptDTO) {
        rezeptZutatRepository.deleteAllByRezept(rezept);

        Set<RezeptZutat> zutaten = new HashSet<>();

        for(ZutatDTO zutatDTO : rezeptDTO.getZutaten()) {
            Optional<Zutat> optionalZutat = zutatRepository.findByName(zutatDTO.getName());

            if(optionalZutat.isPresent()) {
                zutaten.add(new RezeptZutat(rezept, optionalZutat.orElseThrow(), zutatDTO.getMenge(), zutatDTO.getEinheit()));
            } else {
                Zutat zutat = zutatRepository.save(new Zutat(zutatDTO.getName()));
                zutaten.add(new RezeptZutat(rezept, zutat, zutatDTO.getMenge(), zutatDTO.getEinheit()));
            }
        }

        rezept.setZutaten(zutaten);

        return rezeptRepository.save(rezept);
    }
}

package at.htlwienwest.rezept_tracker.controller;

import at.htlwienwest.rezept_tracker.data.entity.Bewertung;
import at.htlwienwest.rezept_tracker.data.entity.Rezept;
import at.htlwienwest.rezept_tracker.data.repository.BewertungRepository;
import at.htlwienwest.rezept_tracker.data.repository.RezeptRepository;
import at.htlwienwest.rezept_tracker.exception.BewertungNotFoundException;
import at.htlwienwest.rezept_tracker.exception.RezeptNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/rezepte/{rezeptId}")
public class BewertungController {
    private final BewertungRepository bewertungRepository;
    private final RezeptRepository rezeptRepository;

    @Autowired
    public BewertungController(BewertungRepository bewertungRepository, RezeptRepository rezeptRepository) {
        this.bewertungRepository = bewertungRepository;
        this.rezeptRepository = rezeptRepository;
    }

    @GetMapping(path = "/bewertungen")
    public Iterable<Bewertung> getBewertungen(@PathVariable Long rezeptId) {
        return rezeptRepository.findById(rezeptId).orElseThrow(() -> new RezeptNotFoundException(rezeptId)).getBewertungen();
    }

    @PostMapping(path = "/bewertungen")
    public Rezept createBewertung(@PathVariable Long rezeptId, @RequestBody @Valid Bewertung bewertung) {
        Rezept rezept = rezeptRepository.findById(rezeptId).orElseThrow(() -> new RezeptNotFoundException(rezeptId));
        Set<Bewertung> bewertungen = rezept.getBewertungen();

        bewertungen.add(bewertung);
        return rezeptRepository.save(rezept);
    }

    @PutMapping(path = "/bewertungen/{id}")
    public Bewertung replaceBewertung(@PathVariable Long id,
                                      @RequestBody @Valid Bewertung newBewertung) {
        return bewertungRepository.findById(id)
                .map(bewertung -> {
                    bewertung.setSterne(newBewertung.getSterne());
                    bewertung.setKommentar(newBewertung.getKommentar());
                    return bewertungRepository.save(bewertung);
                })
                .orElseGet(() -> {
                    newBewertung.setId(id);
                    return bewertungRepository.save(newBewertung);
                });
    }

    @DeleteMapping(path = "/bewertungen/{id}")
    public void deleteBewertung(@PathVariable Long rezeptId, @PathVariable Long id) {
        Rezept rezept = rezeptRepository.findById(rezeptId).orElseThrow(() -> new RezeptNotFoundException(rezeptId));

        if(rezept.getBewertungen().removeIf(b -> id.equals(b.getId()))) {
            rezeptRepository.save(rezept);
        } else {
            throw new BewertungNotFoundException(id);
        }
    }
}

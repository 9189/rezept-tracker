package at.htlwienwest.rezept_tracker.controller;

import at.htlwienwest.rezept_tracker.data.entity.Zutat;
import at.htlwienwest.rezept_tracker.data.repository.ZutatRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/zutaten")
public class ZutatController {
    private final ZutatRepository zutatRepository;

    public ZutatController(ZutatRepository zutatRepository) {
        this.zutatRepository = zutatRepository;
    }

    @GetMapping
    public Iterable<Zutat> getZutaten() {
        return zutatRepository.findAll();
    }


}

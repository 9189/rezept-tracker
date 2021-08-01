package at.htlwienwest.rezept_tracker.controller;

import at.htlwienwest.rezept_tracker.data.entity.Rezept;
import at.htlwienwest.rezept_tracker.dto.RezeptDTO;
import at.htlwienwest.rezept_tracker.exception.RezeptNotFoundException;
import at.htlwienwest.rezept_tracker.service.RezeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rezepte")
public class RezeptController {
    private final RezeptService rezeptService;

    @Autowired
    public RezeptController(RezeptService rezeptService) {
        this.rezeptService = rezeptService;
    }

    @GetMapping
    public Iterable<Rezept> getRezepte() {
        return rezeptService.getRezepte();
    }

    @GetMapping(path = "/{id}")
    public Rezept getById(@PathVariable Long id) {
        return rezeptService.getById(id).orElseThrow(() -> new RezeptNotFoundException(id));
    }

    @PutMapping(path = "/{id}")
    public Rezept replaceRezept(@RequestBody RezeptDTO newRezept, @PathVariable Long id) {
        return rezeptService.replaceRezept(newRezept, id);
    }

    @PostMapping
    public Rezept createRezept(@RequestBody RezeptDTO rezeptDTO) {
        return rezeptService.createRezept(rezeptDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void delteRezept(@PathVariable Long id) {
        rezeptService.deleteRezept(id);
    }
}

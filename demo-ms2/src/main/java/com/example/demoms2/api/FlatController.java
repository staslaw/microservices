package com.example.demoms2.api;

import com.example.demoms2.model.Flat;
import com.example.demoms2.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class FlatController {

    private FlatService flatService;

    @Autowired
    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @PostMapping
    public void addFlat(@Valid @NonNull @RequestBody Flat flat) {
        flatService.addFlat(flat);
    }

    @GetMapping
    public List<Flat> getAllFlats() {
        return flatService.getAllFlats();
    }

    @GetMapping(path = "{id}")
    public Flat getFlatById(@PathVariable("id") UUID flatId) {
        return flatService.getFlatById(flatId)
                .orElse(null);
    }

    @GetMapping(path = "owner/{id}")
    public List<Flat> getFlatListForOwner(@PathVariable("id") UUID ownerId) {
        return flatService.getFlatListForOwner(ownerId);
    }

    @GetMapping(path = "locator/{id}")
    public List<Flat> getFlatListForLocator(@PathVariable("id") UUID locatorId) {
        return flatService.getFlatListForLocator(locatorId);
    }
}

package com.example.demoms2.api;

import com.example.demoms2.exceptions.IncorrectDataException;
import com.example.demoms2.model.Cinema;
import com.example.demoms2.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class CinemaController {

    private CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PostMapping
    public void addCinema(@Valid @NonNull @RequestBody Cinema cinema) throws IncorrectDataException {
        cinemaService.save(cinema);
    }

    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaService.findAll();
    }

    @GetMapping(path = "{id}")
    public Cinema getCinemaById(@PathVariable("id") Long flatId) {
        return cinemaService.getById(flatId);
    }
}

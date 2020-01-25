package com.example.demoms2.service;

import com.example.demoms2.exceptions.IncorrectDataException;
import com.example.demoms2.model.Cinema;

import com.example.demoms2.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CinemaService {

    @Autowired
    CinemaRepository cinemaRepository;

    public void save(Cinema cinema) throws IncorrectDataException {
        cinema.getAddress().validate();
        if (cinema.getCorrespondingAddress() != null) {
            cinema.getCorrespondingAddress().validate();
        }
        cinemaRepository.save(cinema);
    }

    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    public Cinema getById(Long id) {
        return cinemaRepository.getOne(id);
    }


}

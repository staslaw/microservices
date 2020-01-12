package com.example.demoms2.dao;

import com.example.demoms2.model.Flat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlatDao {

    int insertFlat(UUID id, Flat flat);

    default int addFlat(Flat flat) {
        UUID id = UUID.randomUUID();
        return insertFlat(id, flat);
    }

    List<Flat> getAllFlats();

    Optional<Flat> getFlatById(UUID id);

    List<Flat> getFlatListForOwner(UUID ownerId);

    List<Flat> getFlatListForLocator(UUID locatorId);
}

package com.example.demoms2.dao;

import com.example.demoms2.model.Flat;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("fakeDao")
public class FakeFlatDataAccessService implements FlatDao {

    private static List<Flat> DB = new ArrayList<>();


    @Override
    public int insertFlat(UUID id, Flat flat) {
        Flat flatToInsert = new Flat(
                id,
                flat.getOwnerIdList(),
                flat.getLocatorIdList(),
                flat.getCity(),
                flat.getStreet(),
                flat.getPostcode()
        );
        DB.add(flatToInsert);
        return 1;
    }

    @Override
    public List<Flat> getAllFlats() {
        return DB;
    }

    @Override
    public Optional<Flat> getFlatById(UUID id) {
        return DB.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Flat> getFlatListForOwner(UUID ownerId) {
        return DB.stream()
                .filter(f -> f.getOwnerIdList().contains(ownerId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flat> getFlatListForLocator(UUID locatorId) {
        return DB.stream()
                .filter(f -> f.getLocatorIdList().contains(locatorId))
                .collect(Collectors.toList());
    }
}

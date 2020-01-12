package com.example.demoms2.service;

import com.example.demoms2.model.Flat;
import com.example.demoms2.dao.FlatDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlatService {

    private final FlatDao flatDao;

    @Autowired
    public FlatService(@Qualifier("fakeDao") FlatDao flatDao) {
        this.flatDao = flatDao;
    }

    public int addFlat(Flat flat) {
        return flatDao.addFlat(flat);
    }

    public List<Flat> getAllFlats() {
        return flatDao.getAllFlats();
    }

    public Optional<Flat> getFlatById(UUID flatId) {
        return flatDao.getFlatById(flatId);
    }

    public List<Flat> getFlatListForOwner(UUID ownerId) {
        return flatDao.getFlatListForOwner(ownerId);
    }

    public List<Flat> getFlatListForLocator(UUID locatorId) {
        return flatDao.getFlatListForLocator(locatorId);
    }
}

package com.example.demoms2.service;

import com.example.demoms2.model.LegalEntity;
import com.example.demoms2.repository.LegalEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LegalEntityService {

    @Autowired
    LegalEntityRepository legalEntityRepository;

    public void save(LegalEntity legalEntity) {
        legalEntityRepository.save(legalEntity);
    }

    public LegalEntity getOneById(Long id) {
        return legalEntityRepository.getOne(id);
    }

    public List<LegalEntity> getAll() {
        return legalEntityRepository.findAll();
    }
}

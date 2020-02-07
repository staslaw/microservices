package com.example.demoms2.api;

import com.example.demoms2.exceptions.IncorrectDataException;
import com.example.demoms2.model.Cinema;
import com.example.demoms2.model.LegalEntity;
import com.example.demoms2.service.LegalEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/legal_entity")
public class LegalEntityController {

    private LegalEntityService legalEntityService;

    @Autowired
    public LegalEntityController(LegalEntityService legalEntityService) {
        this.legalEntityService = legalEntityService;
    }

    @PostMapping
    public void addLegalEntity(@Valid @NonNull @RequestBody LegalEntity legalEntity) {
        legalEntityService.save(legalEntity);
    }

    @GetMapping
    public List<LegalEntity> getAllLegalEntities() {
        return legalEntityService.getAll();
    }

    @GetMapping(path = "{id}")
    public LegalEntity getLegalEntityById(@PathVariable("id") Long legalEntityId) {
        return legalEntityService.getOneById(legalEntityId);
    }
}

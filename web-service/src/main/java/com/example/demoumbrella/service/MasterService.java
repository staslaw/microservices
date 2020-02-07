package com.example.demoumbrella.service;

import com.example.demoumbrella.model.Flat;
import com.example.demoumbrella.model.FlatInfo;
import com.example.demoumbrella.model.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MasterService {

    @Autowired
    private FlatService flatService;

    @Autowired
    private PersonService personService;

    public List<FlatInfo> getFullInfoFlatList() {
        List<Flat> flatList = flatService.getAllFlats();
        List<Person> personList = personService.getAllPersons();

        return flatList.stream()
                .map(flat -> new FlatInfo(
                        flat.getId(),
                        getOwnerOrLocatorListFromAllPeople(flat.getOwnerIdList(), personList),
                        getOwnerOrLocatorListFromAllPeople(flat.getLocatorIdList(), personList),
                        flat.getCity(),
                        flat.getStreet(),
                        flat.getPostcode()
                ))
                .collect(Collectors.toList());
    }

    private List<String> getOwnerOrLocatorListFromAllPeople(List<UUID> personsId, List<Person> allPersons) {
        if (personsId == null || personsId.isEmpty()) {
            return Collections.emptyList();
        } else {
            return allPersons.stream()
                    .filter(person -> personsId.contains(person.getId()))
                    .map(Person::getName)
                    .collect(Collectors.toList());
        }
    }

}

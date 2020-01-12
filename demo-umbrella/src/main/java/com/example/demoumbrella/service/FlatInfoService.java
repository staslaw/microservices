package com.example.demoumbrella.service;

import com.example.demoumbrella.model.Flat;
import com.example.demoumbrella.model.FlatInfo;
import com.example.demoumbrella.model.Person;
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
public class FlatInfoService {

    String urlFlat = "http://demo-ms2";
    String urlPerson = "http://demo-ms1/api/v1/person";

    @Autowired
    private RestTemplate restTemplate;

    public List<FlatInfo> getFullInfoFlatList() {
        List<Flat> flatList = getAllFlats();
        List<Person> personList = getAllPersons();

        List<FlatInfo> flatInfoList = flatList.stream()
                .map(flat -> new FlatInfo(
                        flat.getId(),
                        getOwnerOrLocatorListFromAllPeople(flat.getOwnerIdList(), personList),
                        getOwnerOrLocatorListFromAllPeople(flat.getLocatorIdList(), personList),
                        flat.getCity(),
                        flat.getStreet(),
                        flat.getPostcode()
                ))
                .collect(Collectors.toList());

        return flatInfoList;
    }

    private List<Flat> getAllFlats() {
        ResponseEntity<Flat[]> responseEntityFlat = restTemplate.getForEntity(urlFlat, Flat[].class);
        return Arrays.asList(responseEntityFlat.getBody());
    }

    private List<Person> getAllPersons() {
        ResponseEntity<Person[]> responseEntityPerson = restTemplate.getForEntity(urlPerson, Person[].class);
        return Arrays.asList(responseEntityPerson.getBody());
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

package com.example.demoumbrella.service;

import com.example.demoumbrella.model.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PersonService {

    String urlPerson = "http://demo-ms1/api/v1/person";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackAllPersons",
            threadPoolKey = "personServicePool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "6"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    protected List<Person> getAllPersons() {
        ResponseEntity<Person[]> responseEntityPerson = restTemplate.getForEntity(urlPerson, Person[].class);
        return Arrays.asList(responseEntityPerson.getBody());
    }

    public List<Person> getFallBackAllPersons() {
        return Collections.singletonList(new Person(null, "empty"));
    }
}

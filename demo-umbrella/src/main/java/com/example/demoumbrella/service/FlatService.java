package com.example.demoumbrella.service;

import com.example.demoumbrella.model.Flat;
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
public class FlatService {

    String urlFlat = "http://demo-ms2";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackAllFlats", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
    })
    protected List<Flat> getAllFlats() {
        ResponseEntity<Flat[]> responseEntityFlat = restTemplate.getForEntity(urlFlat, Flat[].class);
        return Arrays.asList(responseEntityFlat.getBody());
    }

    public List<Flat> getFallBackAllFlats() {
        return Collections.singletonList(new Flat(null, null, null, "empty", null, null));
    }

}

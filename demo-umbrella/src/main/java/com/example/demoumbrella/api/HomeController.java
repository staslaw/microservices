package com.example.demoumbrella.api;

import com.example.demoumbrella.model.FlatInfo;
import com.example.demoumbrella.service.FlatInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class HomeController {

    @Autowired
    FlatInfoService flatInfoService;

    @GetMapping
    public List<FlatInfo> getFullInfoFlatList() {
        List<FlatInfo> list = flatInfoService.getFullInfoFlatList();
        return list;
    }
}

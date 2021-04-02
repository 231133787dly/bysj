package com.controller;


import com.service.EvidenceDataService;
import com.service.PhenomenonDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/phenomenonData")
public class PhenomenonDataController {
    @Autowired
    private PhenomenonDataService phenomenonDataService;

    @RequestMapping(value = "/addPhenomenonData")
    public void addPhenomenonData(){
        phenomenonDataService.addPhenomenonData();
    }
}
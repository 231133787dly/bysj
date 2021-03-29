package com.controller;

import com.service.EvidenceDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/evidenceData")
public class EvidenceDataController {
    @Autowired
    private EvidenceDataService evidenceDataService;

    //@RequestMapping(value = "/addEvidenceData/type/{type}")
    //public void addEvidenceData(@PathVariable String type){
    @RequestMapping(value = "/addEvidenceData")
    public void addEvidenceData(){
        evidenceDataService.addEvidenceData();
    }

}

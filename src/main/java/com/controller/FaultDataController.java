package com.controller;

import com.service.FaultDataService;
import com.service.PhenomenonDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/faultData")
public class FaultDataController {
    @Autowired
    private FaultDataService faultDataService;

    @RequestMapping(value = "/addFaultData")
    public void addFaultData(){
        faultDataService.addFaultData();
    }
}

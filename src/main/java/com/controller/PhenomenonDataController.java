package com.controller;


import com.constant.Constant;
import com.pojo.BeatsPhenomenon;
import com.pojo.EssentialData11H;
import com.pojo.PhenomenonData;
import com.service.EvidenceDataService;
import com.service.PhenomenonDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    //获得现象
    @GetMapping(value = "/getPhenomenonData")
    @ResponseBody
    public List<PhenomenonData> getPhenomenonData() {
        return phenomenonDataService.getPhenomenonData();
    }

    //获得现象规则
    @GetMapping(value = "/getPhenomenonRules")
    @ResponseBody
    public List<BeatsPhenomenon> getPhenomenonRules() {
        return phenomenonDataService.getPhenomenonRules();
    }
}
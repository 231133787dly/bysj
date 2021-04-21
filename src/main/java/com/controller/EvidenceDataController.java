package com.controller;

import com.pojo.EvidenceData;
import com.service.EvidenceDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping(value = "/addEvidenceData/11H")
    public void addEvidenceData11H(){
        evidenceDataService.addEvidenceData11H();
    }

    @RequestMapping(value = "/addEvidenceData/12H")
    public void addEvidenceData12H(){
        evidenceDataService.addEvidenceData12H();
    }

    @RequestMapping(value = "/addEvidenceData/14H")
    public void addEvidenceData14H(){
        evidenceDataService.addEvidenceData14H();
    }

    @RequestMapping(value = "/addEvidenceData/18H")
    public void addEvidenceData18H(){
        evidenceDataService.addEvidenceData18H();
    }

    @RequestMapping(value = "/11H")
    @ResponseBody
    public List<EvidenceData> getEvidenceData11H(){
        return evidenceDataService.getEvidenceDate11H();
    }
    @RequestMapping(value = "/12H")
    @ResponseBody
    public List<EvidenceData> getEvidenceData12H(){
        return evidenceDataService.getEvidenceDate12H();
    }
    @RequestMapping(value = "/14H")
    @ResponseBody
    public List<EvidenceData> getEvidenceData14H(){
        return evidenceDataService.getEvidenceDate14H();
    }
    @RequestMapping(value = "/18H")
    @ResponseBody
    public List<EvidenceData> getEvidenceData18H(){
        return evidenceDataService.getEvidenceDate18H();
    }
}

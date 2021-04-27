package com.controller;

import com.pojo.BeatsFault;
import com.pojo.BeatsFaultName;
import com.pojo.FaultData;
import com.pojo.PhenomenonData;
import com.service.FaultDataService;
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
@RequestMapping(value = "/faultData")
public class FaultDataController {
    @Autowired
    private FaultDataService faultDataService;

    @RequestMapping(value = "/addFaultData")
    public void addFaultData(){
        faultDataService.addFaultData();
    }

    //获得故障
    @GetMapping(value = "/getFaultData")
    @ResponseBody
    public List<FaultData> getFaultData() {
        return faultDataService.getFaultData();
    }

    //获得故障规则
    @GetMapping(value = "/getFaultRules")
    @ResponseBody
    public List<BeatsFault> getFaultRules() {
        return faultDataService.getFaultRules();
    }

    //获得故障名
    @GetMapping(value = "/getFaultName")
    @ResponseBody
    public List<BeatsFaultName> getFault() {
        return faultDataService.getFault();
    }


    @RequestMapping(value = "/deleteAll")
    public void deleteAll(){
        faultDataService.deleteAll();
    }

    @RequestMapping(value = "/deleteEssentialData11H")
    public void deleteEssentialData11H(){
        faultDataService.deleteEssentialData11H();
    }

    @RequestMapping(value = "/deleteEssentialData12H")
    public void deleteEssentialData12H(){
        faultDataService.deleteEssentialData12H();
    }

    @RequestMapping(value = "/deleteEssentialData14H")
    public void deleteEssentialData14H(){
        faultDataService.deleteEssentialData14H();
    }

    @RequestMapping(value = "/deleteEssentialData18H")
    public void deleteEssentialData18H(){
        faultDataService.deleteEssentialData18H();
    }

    @RequestMapping(value = "/deleteEvidenceData11H")
    public void deleteEvidenceData11H(){
        faultDataService.deleteEvidenceData11H();
    }

    @RequestMapping(value = "/deleteEvidenceData12H")
    public void deleteEvidenceData12H(){
        faultDataService.deleteEvidenceData12H();
    }

    @RequestMapping(value = "/deleteEvidenceData14H")
    public void deleteEvidenceData14H(){
        faultDataService.deleteEvidenceData14H();
    }

    @RequestMapping(value = "/deleteEvidenceData18H")
    public void deleteEvidenceData18H(){
        faultDataService.deleteEvidenceData18H();
    }

    @RequestMapping(value = "/deletePhenomenonData")
    public void deletePhenomenonData(){
        faultDataService.deletePhenomenonData();
    }

    @RequestMapping(value = "/deleteFaultData")
    public void deleteFaultData(){
        faultDataService.deleteFaultData();
    }
}

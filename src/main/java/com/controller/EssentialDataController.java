package com.controller;

import com.constant.Constant;
import com.pojo.EssentialData11H;
import com.pojo.EssentialData12H;
import com.pojo.EssentialData14H;
import com.pojo.EssentialData18H;
import com.service.EssentialDataService;
import com.utils.Excel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequestMapping(value = "/essentialData")
public class EssentialDataController {
    @Autowired
    EssentialDataService essentialDataService;

    //插入18H的数据
    @RequestMapping(value = "/18H")
    public void addEssentialData18H() throws IOException {
        essentialDataService.insertEssentialData(Excel.csvReadOperation(Constant.EssentialData18H_PATH,Constant.Type_18H),Constant.Type_18H);
        log.info("18H!");
    }

    //插入14H的数据
    @RequestMapping(value = "/14H")
    public void addEssentialData14H() throws IOException {
        essentialDataService.insertEssentialData(Excel.csvReadOperation(Constant.EssentialData14H_PATH,Constant.Type_14H),Constant.Type_14H);
        log.info("14H!");
    }

    //插入12H的数据
    @RequestMapping(value = "/12H")
    public void addEssentialData12H() throws IOException {
        essentialDataService.insertEssentialData(Excel.csvReadOperation(Constant.EssentialData12H_PATH,Constant.Type_12H),Constant.Type_12H);
        log.info("12H!");
    }

    //插入11H的数据
    @RequestMapping(value = "/11H")
    public void addEssentialData11H() throws IOException {
        essentialDataService.insertEssentialData(Excel.csvReadOperation(Constant.EssentialData11H_PATH,Constant.Type_11H),Constant.Type_11H);
        log.info("11H!");
    }

    //获得18H的基础数据
    @GetMapping(value = "/getEssentialData/18H")
    @ResponseBody
    public List<EssentialData18H> getEssentialData18H() {
        log.info("获取到的值："+essentialDataService.getEssentialData(Constant.Type_18H));
        return (List<EssentialData18H>) essentialDataService.getEssentialData(Constant.Type_18H);
    }

    //获得14H的基础数据
    @GetMapping(value = "/getEssentialData/14H")
    @ResponseBody
    public List<EssentialData14H> getEssentialData14H() {
        log.info("获取到的值："+essentialDataService.getEssentialData(Constant.Type_14H));
        return (List<EssentialData14H>) essentialDataService.getEssentialData(Constant.Type_14H);
    }

    //获得12H的基础数据
    @GetMapping(value = "/getEssentialData/12H")
    @ResponseBody
    public List<EssentialData12H> getEssentialData12H() {
        log.info("获取到的值："+essentialDataService.getEssentialData(Constant.Type_12H));
        return (List<EssentialData12H>) essentialDataService.getEssentialData(Constant.Type_12H);
    }

    //获得11H的基础数据
    @GetMapping(value = "/getEssentialData/11H")
    @ResponseBody
    public List<EssentialData11H> getEssentialData11H() {
        log.info("获取到的值："+essentialDataService.getEssentialData(Constant.Type_11H));
        return (List<EssentialData11H>) essentialDataService.getEssentialData(Constant.Type_11H);
    }
}

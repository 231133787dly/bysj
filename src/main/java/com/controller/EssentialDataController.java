package com.controller;

import com.constant.Constant;
import com.service.EssentialDataService;
import com.utils.Excel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

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

    @RequestMapping(value = "/Hello")
    public String Hello() throws IOException {
        log.info("hello!");
        return "Hello";
    }

}

package com.service;

import com.mapper.EssentialDataMapper;
import com.mapper.EvidenceDataMapper;
import com.pojo.EssentialData18H;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EvidenceDataService {
    @Autowired
    private EvidenceDataMapper evidenceDataMapper;
    @Autowired
    private EssentialDataMapper essentialDataMapper;

    private int beatsCount = 0;
    //插入证据库
    public void addEvidenceData(){
        analyseEssentialData();
        log.info("心跳次数：" + beatsCount);
    }

    //分析基础数据
    private void analyseEssentialData(){
        List<String> deviceSerialList= essentialDataMapper.getAllDeviceSerial();
        //List<EssentialData18H> essentialData18HList = essentialDataMapper.getAllEssentialData18H();

        for (String deviceSerial : deviceSerialList){
            beatsCount = 0;
            List<EssentialData18H> essentialData18HList = essentialDataMapper.getEssentialData18HByDeviceSerial(deviceSerial);
            for(EssentialData18H essentialData18H : essentialData18HList){
                log.info(String.valueOf(essentialData18H));
                beatsCount ++ ;
            }
            log.info(deviceSerial + ":" + beatsCount);
        }
    }

}

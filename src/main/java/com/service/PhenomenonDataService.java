package com.service;

import com.constant.Constant;

import com.mapper.EvidenceDataMapper;
import com.mapper.PhenomenonDataMapper;
import com.mapper.RulesMapper;
import com.pojo.EssentialData18H;
import com.pojo.EvidenceData;
import com.pojo.PhenomenonData;
import com.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class PhenomenonDataService {
    @Autowired
    private PhenomenonDataMapper phenomenonDataMapper;
    @Autowired
    private EvidenceDataMapper evidenceDataMapper;
    @Autowired
    private RulesMapper rulesMapper;

    //插入现象库
    public void addPhenomenonData() {
        //获取所有的设备列表
        List<String> deviceSerialList= rulesMapper.getAllDeviceSerial();
        //循环分析各个设备
        for (String deviceSerial : deviceSerialList) {
            //循环分析各个证据库
            for (String dataTime = Time.getStartTime(); !dataTime.equals(Time.getEndTime()); dataTime = Time.getNextTime(dataTime, 60)) {
                //对某一设备某一时间段进行数据分析
                this.analysePhenomenonData18H(deviceSerial, dataTime);

            }
        }
    }

    //将18H证据库的数据分析得出现象
    private void analysePhenomenonData18H(String deviceSerial, String startTime){
        PhenomenonData phenomenonData = new PhenomenonData();
        //心跳率
        double beatsRate;
        //最大缺失时间
        double maxBeatsLackTime;
        //获取数据
        List<EvidenceData> evidenceDataList = evidenceDataMapper.getEvidenceData18HByDAT(deviceSerial,startTime,Time.getNextTime(startTime,60));
        for(EvidenceData evidenceData : evidenceDataList){
            beatsRate = evidenceData.getBeatsRate();
            maxBeatsLackTime = evidenceData.getMaxBeatsLackTime();


        }

    }

}
package com.service;

import com.constant.Constant;
import com.mapper.EssentialDataMapper;
import com.mapper.EvidenceDataMapper;
import com.mapper.RulesMapper;
import com.pojo.*;
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
public class EvidenceDataService {
    @Autowired
    private EvidenceDataMapper evidenceDataMapper;
    @Autowired
    private EssentialDataMapper essentialDataMapper;
    @Autowired
    private RulesMapper rulesMapper;

    private int beatsCount = 0;
    private long timeDifference = 0;
    private LocalDateTime nowTime;
    private LocalDateTime preTime;

    //插入证据库
    public void addEvidenceData(){
        //获取所有的设备列表
        List<String> deviceSerialList= rulesMapper.getAllDeviceSerial();
        //循环分析各个设备
        for (String deviceSerial : deviceSerialList){
            for (String dataTime = Time.getStartTime(); !dataTime.equals(Time.getEndTime()); dataTime = Time.getNextTime(dataTime,20)){
                //对某一设备某一时间段进行数据分析
                this.analyseEvidenceData18H(deviceSerial,dataTime);
                this.analyseEvidenceData14H(deviceSerial,dataTime);
                this.analyseEvidenceData12H(deviceSerial,dataTime);
                this.analyseEvidenceData11H(deviceSerial,dataTime);
            }
        }



    }

    //对18H某一设备某一时间段进行数据分析
    private void analyseEvidenceData18H(String deviceSerial, String startTime){
        EvidenceData evidenceData = new EvidenceData();
        //获取所需数据
        List<EssentialData18H> essentialData18HList = essentialDataMapper.getEssentialData18HByDAT(deviceSerial,startTime,Time.getNextTime(startTime,20));
        //统计心跳
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern(Constant.FORMAT_TIME);
        preTime = LocalDateTime.parse(essentialData18HList.get(0).getDatetime(),formatTime);
        beatsCount = 0;
        timeDifference = 0;
        for(EssentialData18H essentialData18H : essentialData18HList){
            //判断最大缺省时间
            nowTime = LocalDateTime.parse(essentialData18H.getDatetime(),formatTime);
            Duration duration = Duration.between(preTime,nowTime);
            if (timeDifference < duration.toSeconds()) {
                timeDifference = duration.toSeconds();
            }
            preTime = nowTime;
            beatsCount ++ ;
        }
        double beatsRate = (double)beatsCount / Constant.EstimatedBeats_18H;
        //设置分析结果
        evidenceData.setActualBeats(beatsCount);
        evidenceData.setBeatsRate(beatsRate);
        evidenceData.setDeviceSerial(deviceSerial);
        evidenceData.setStartTime(startTime);
        evidenceData.setMaxBeatsLackTime(timeDifference);
        //写入数据库中
        evidenceDataMapper.addEvidenceData18H(evidenceData);
    }

    //对14H某一设备某一时间段进行数据分析
    private void analyseEvidenceData14H(String deviceSerial, String startTime){
        EvidenceData evidenceData = new EvidenceData();
        //获取所需数据
        List<EssentialData14H> essentialData14HList = essentialDataMapper.getEssentialData14HByDAT(deviceSerial,startTime,Time.getNextTime(startTime,20));
        //统计心跳
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern(Constant.FORMAT_TIME);
        preTime = LocalDateTime.parse(essentialData14HList.get(0).getDatetime(),formatTime);
        beatsCount = 0;
        timeDifference = 0;
        for(EssentialData14H essentialData14H : essentialData14HList){
            //判断最大缺省时间
            nowTime = LocalDateTime.parse(essentialData14H.getDatetime(),formatTime);
            Duration duration = Duration.between(preTime,nowTime);
            if (timeDifference < duration.toSeconds()) {
                timeDifference = duration.toSeconds();
            }
            preTime = nowTime;
            beatsCount ++ ;
        }
        double beatsRate = (double)beatsCount / Constant.EstimatedBeats_14H;
        //设置分析结果
        evidenceData.setActualBeats(beatsCount);
        evidenceData.setBeatsRate(beatsRate);
        evidenceData.setDeviceSerial(deviceSerial);
        evidenceData.setStartTime(startTime);
        evidenceData.setMaxBeatsLackTime(timeDifference);
        //写入数据库中
        evidenceDataMapper.addEvidenceData14H(evidenceData);
    }

    //对12H某一设备某一时间段进行数据分析
    private void analyseEvidenceData12H(String deviceSerial, String startTime){
        EvidenceData evidenceData = new EvidenceData();
        //获取所需数据
        List<EssentialData12H> essentialData12HList = essentialDataMapper.getEssentialData12HByDAT(deviceSerial,startTime,Time.getNextTime(startTime,20));
        //统计心跳
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern(Constant.FORMAT_TIME);
        preTime = LocalDateTime.parse(essentialData12HList.get(0).getDatetime(),formatTime);
        beatsCount = 0;
        timeDifference = 0;
        for(EssentialData12H essentialData12H : essentialData12HList){
            //判断最大缺省时间
            nowTime = LocalDateTime.parse(essentialData12H.getDatetime(),formatTime);
            Duration duration = Duration.between(preTime,nowTime);
            if (timeDifference < duration.toSeconds()) {
                timeDifference = duration.toSeconds();
            }
            preTime = nowTime;
            beatsCount ++ ;
        }
        double beatsRate = (double)beatsCount / Constant.EstimatedBeats_12H;
        //设置分析结果
        evidenceData.setActualBeats(beatsCount);
        evidenceData.setBeatsRate(beatsRate);
        evidenceData.setDeviceSerial(deviceSerial);
        evidenceData.setStartTime(startTime);
        evidenceData.setMaxBeatsLackTime(timeDifference);
        //写入数据库中
        evidenceDataMapper.addEvidenceData12H(evidenceData);
    }

    //对11H某一设备某一时间段进行数据分析
    private void analyseEvidenceData11H(String deviceSerial, String startTime){
        EvidenceData evidenceData = new EvidenceData();
        //获取所需数据
        List<EssentialData11H> essentialData11HList = essentialDataMapper.getEssentialData11HByDAT(deviceSerial,startTime,Time.getNextTime(startTime,20));
        //统计心跳
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern(Constant.FORMAT_TIME);
        preTime = LocalDateTime.parse(essentialData11HList.get(0).getDatetime(),formatTime);
        beatsCount = 0;
        timeDifference = 0;
        for(EssentialData11H essentialData11H : essentialData11HList){
            //判断最大缺省时间
            nowTime = LocalDateTime.parse(essentialData11H.getDatetime(),formatTime);
            Duration duration = Duration.between(preTime,nowTime);
            if (timeDifference < duration.toSeconds()) {
                timeDifference = duration.toSeconds();
            }
            preTime = nowTime;
            beatsCount ++ ;
        }
        double beatsRate = (double)beatsCount / Constant.EstimatedBeats_11H;
        //设置分析结果
        evidenceData.setActualBeats(beatsCount);
        evidenceData.setBeatsRate(beatsRate);
        evidenceData.setDeviceSerial(deviceSerial);
        evidenceData.setStartTime(startTime);
        evidenceData.setMaxBeatsLackTime(timeDifference);
        //写入数据库中
        evidenceDataMapper.addEvidenceData11H(evidenceData);
    }

}

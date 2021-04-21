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
    private double beatsRate = 0;
    private double maxLackTime = 0;
    private LocalDateTime nowTime;
    private LocalDateTime preTime;

    //插入证据库
    public void addEvidenceData(){
        //获取所有的设备列表
        List<String> deviceSerialList= rulesMapper.getAllDeviceSerial();
        //循环分析各个设备
        for (String deviceSerial : deviceSerialList){
            for (String dataTime = Time.getStartTime(); !dataTime.equals(Time.getEndTime()); dataTime = Time.getNextTime(dataTime,Constant.DIFFERENCE_MINUTES)){
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
        List<EssentialData18H> essentialData18HList = essentialDataMapper.getEssentialData18HByDAT(deviceSerial,startTime,Time.getNextTime(startTime,Constant.DIFFERENCE_MINUTES));
        if(!essentialData18HList.isEmpty()) {
            //统计心跳
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern(Constant.FORMAT_TIME);
            preTime = LocalDateTime.parse(startTime, formatTime);
            beatsCount = 0;
            timeDifference = 0;
            for (EssentialData18H essentialData18H : essentialData18HList) {
                //判断最大缺省时间
                nowTime = LocalDateTime.parse(essentialData18H.getDatetime(), formatTime);
                Duration duration = Duration.between(preTime, nowTime);
                if (timeDifference < duration.toSeconds()) {
                    timeDifference = duration.toSeconds();
                }
                preTime = nowTime;
                beatsCount++;
            }
            //附加时间判断，判断最后的缺失时长
            nowTime = LocalDateTime.parse(Time.getNextTime(startTime,Constant.DIFFERENCE_MINUTES), formatTime);
            Duration duration = Duration.between(preTime, nowTime);
            if (timeDifference < duration.toSeconds()) {
                timeDifference = duration.toSeconds();
            }

            beatsRate = (double) beatsCount / Constant.EstimatedBeats_18H;
            maxLackTime = ((double) timeDifference / Constant.EstimatedTime_18H -1) / Constant.EstimatedBeats_18H;
            //设置分析结果
            evidenceData.setActualBeats(beatsCount);
            evidenceData.setBeatsRate(beatsRate);
            evidenceData.setDeviceSerial(deviceSerial);
            evidenceData.setStartTime(startTime);
            evidenceData.setMaxBeatsLackTime(maxLackTime);
        }else {
            evidenceData.setActualBeats(0);
            evidenceData.setBeatsRate(0);
            evidenceData.setDeviceSerial(deviceSerial);
            evidenceData.setStartTime(startTime);
            evidenceData.setMaxBeatsLackTime(1);
        }
        //写入数据库中
        evidenceDataMapper.addEvidenceData18H(evidenceData);
    }

    //对14H某一设备某一时间段进行数据分析
    private void analyseEvidenceData14H(String deviceSerial, String startTime){
        EvidenceData evidenceData = new EvidenceData();
        //获取所需数据
        List<EssentialData14H> essentialData14HList = essentialDataMapper.getEssentialData14HByDAT(deviceSerial,startTime,Time.getNextTime(startTime,Constant.DIFFERENCE_MINUTES));
        if(!essentialData14HList.isEmpty()) {
            //统计心跳
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern(Constant.FORMAT_TIME);
            //preTime = LocalDateTime.parse(essentialData14HList.get(0).getDatetime(), formatTime);
            preTime = LocalDateTime.parse(startTime, formatTime);
            beatsCount = 0;
            timeDifference = 0;
            for (EssentialData14H essentialData14H : essentialData14HList) {
                //判断最大缺省时间
                nowTime = LocalDateTime.parse(essentialData14H.getDatetime(), formatTime);
                Duration duration = Duration.between(preTime, nowTime);
                if (timeDifference < duration.toSeconds()) {
                    timeDifference = duration.toSeconds();
                }

                preTime = nowTime;
                beatsCount++;
            }
            //附加时间判断，判断最后的缺失时长
            nowTime = LocalDateTime.parse(Time.getNextTime(startTime,Constant.DIFFERENCE_MINUTES), formatTime);
            Duration duration = Duration.between(preTime, nowTime);
            if (timeDifference < duration.toSeconds()) {
                timeDifference = duration.toSeconds();
            }

            beatsRate = (double) beatsCount / Constant.EstimatedBeats_14H;
            maxLackTime = ((double) timeDifference / Constant.EstimatedTime_14H -1) / Constant.EstimatedBeats_14H;
            //设置分析结果
            evidenceData.setActualBeats(beatsCount);
            evidenceData.setBeatsRate(beatsRate);
            evidenceData.setDeviceSerial(deviceSerial);
            evidenceData.setStartTime(startTime);
            evidenceData.setMaxBeatsLackTime(maxLackTime);
        }else {
            evidenceData.setActualBeats(0);
            evidenceData.setBeatsRate(0);
            evidenceData.setDeviceSerial(deviceSerial);
            evidenceData.setStartTime(startTime);
            evidenceData.setMaxBeatsLackTime(1);
        }
        //写入数据库中
        evidenceDataMapper.addEvidenceData14H(evidenceData);
    }

    //对12H某一设备某一时间段进行数据分析
    private void analyseEvidenceData12H(String deviceSerial, String startTime){
        EvidenceData evidenceData = new EvidenceData();
        //获取所需数据
        List<EssentialData12H> essentialData12HList = essentialDataMapper.getEssentialData12HByDAT(deviceSerial,startTime,Time.getNextTime(startTime,Constant.DIFFERENCE_MINUTES));
        if(!essentialData12HList.isEmpty()) {
            //统计心跳
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern(Constant.FORMAT_TIME);
            preTime = LocalDateTime.parse(startTime, formatTime);
            beatsCount = 0;
            timeDifference = 0;
            for (EssentialData12H essentialData12H : essentialData12HList) {
                //判断最大缺省时间
                nowTime = LocalDateTime.parse(essentialData12H.getDatetime(), formatTime);
                Duration duration = Duration.between(preTime, nowTime);
                if (timeDifference < duration.toSeconds()) {
                    timeDifference = duration.toSeconds();
                }
                preTime = nowTime;
                beatsCount++;
            }
            //附加时间判断，判断最后的缺失时长
            nowTime = LocalDateTime.parse(Time.getNextTime(startTime,Constant.DIFFERENCE_MINUTES), formatTime);
            Duration duration = Duration.between(preTime, nowTime);
            if (timeDifference < duration.toSeconds()) {
                timeDifference = duration.toSeconds();
            }

            beatsRate = (double) beatsCount / Constant.EstimatedBeats_12H;
            maxLackTime = ((double) timeDifference / Constant.EstimatedTime_12H -1) / Constant.EstimatedBeats_12H;
            //设置分析结果
            evidenceData.setActualBeats(beatsCount);
            evidenceData.setBeatsRate(beatsRate);
            evidenceData.setDeviceSerial(deviceSerial);
            evidenceData.setStartTime(startTime);
            evidenceData.setMaxBeatsLackTime(maxLackTime);
        }else {
            evidenceData.setActualBeats(0);
            evidenceData.setBeatsRate(0);
            evidenceData.setDeviceSerial(deviceSerial);
            evidenceData.setStartTime(startTime);
            evidenceData.setMaxBeatsLackTime(1);
        }
        //写入数据库中
        evidenceDataMapper.addEvidenceData12H(evidenceData);
    }

    //对11H某一设备某一时间段进行数据分析
    private void analyseEvidenceData11H(String deviceSerial, String startTime){
        EvidenceData evidenceData = new EvidenceData();
        //获取所需数据
        List<EssentialData11H> essentialData11HList = essentialDataMapper.getEssentialData11HByDAT(deviceSerial,startTime,Time.getNextTime(startTime,Constant.DIFFERENCE_MINUTES));
        if(!essentialData11HList.isEmpty()) {
            //统计心跳
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern(Constant.FORMAT_TIME);
            preTime = LocalDateTime.parse(startTime, formatTime);
            beatsCount = 0;
            timeDifference = 0;
            for (EssentialData11H essentialData11H : essentialData11HList) {
                //判断最大缺省时间
                nowTime = LocalDateTime.parse(essentialData11H.getDatetime(), formatTime);
                Duration duration = Duration.between(preTime, nowTime);
                if (timeDifference < duration.toSeconds()) {
                    timeDifference = duration.toSeconds();
                }
                preTime = nowTime;
                beatsCount++;
            }
            //附加时间判断，判断最后的缺失时长
            nowTime = LocalDateTime.parse(Time.getNextTime(startTime,Constant.DIFFERENCE_MINUTES), formatTime);
            Duration duration = Duration.between(preTime, nowTime);
            if (timeDifference < duration.toSeconds()) {
                timeDifference = duration.toSeconds();
            }

            beatsRate = (double) beatsCount / Constant.EstimatedBeats_11H;
            maxLackTime = ((double) timeDifference / Constant.EstimatedTime_11H -1) / Constant.EstimatedBeats_11H;
            //设置分析结果
            evidenceData.setActualBeats(beatsCount);
            evidenceData.setBeatsRate(beatsRate);
            evidenceData.setDeviceSerial(deviceSerial);
            evidenceData.setStartTime(startTime);
            evidenceData.setMaxBeatsLackTime(maxLackTime);
        }else {
            evidenceData.setActualBeats(0);
            evidenceData.setBeatsRate(0);
            evidenceData.setDeviceSerial(deviceSerial);
            evidenceData.setStartTime(startTime);
            evidenceData.setMaxBeatsLackTime(1);
        }
        //写入数据库中
        evidenceDataMapper.addEvidenceData11H(evidenceData);
    }

    //获取11H证据库中的证据信息
    public List<EvidenceData> getEvidenceDate11H(){
        return evidenceDataMapper.getEvidenceData11H();
    }
    //获取12H证据库中的证据信息
    public List<EvidenceData> getEvidenceDate12H(){
        return evidenceDataMapper.getEvidenceData12H();
    }
    //获取14H证据库中的证据信息
    public List<EvidenceData> getEvidenceDate14H(){
        return evidenceDataMapper.getEvidenceData14H();
    }
    //获取18H证据库中的证据信息
    public List<EvidenceData> getEvidenceDate18H(){
        return evidenceDataMapper.getEvidenceData18H();
    }

    //插入11H证据库
    public void addEvidenceData11H(){
        //获取所有的设备列表
        List<String> deviceSerialList= rulesMapper.getAllDeviceSerial();
        //循环分析各个设备
        for (String deviceSerial : deviceSerialList){
            for (String dataTime = Time.getStartTime(); !dataTime.equals(Time.getEndTime()); dataTime = Time.getNextTime(dataTime,Constant.DIFFERENCE_MINUTES)){
                //对某一设备某一时间段进行数据分析
                this.analyseEvidenceData11H(deviceSerial,dataTime);
            }
        }
    }
    //插入12H证据库
    public void addEvidenceData12H(){
        //获取所有的设备列表
        List<String> deviceSerialList= rulesMapper.getAllDeviceSerial();
        //循环分析各个设备
        for (String deviceSerial : deviceSerialList){
            for (String dataTime = Time.getStartTime(); !dataTime.equals(Time.getEndTime()); dataTime = Time.getNextTime(dataTime,Constant.DIFFERENCE_MINUTES)){
                //对某一设备某一时间段进行数据分析
                this.analyseEvidenceData12H(deviceSerial,dataTime);
            }
        }
    }
    //插入14H证据库
    public void addEvidenceData14H(){
        //获取所有的设备列表
        List<String> deviceSerialList= rulesMapper.getAllDeviceSerial();
        //循环分析各个设备
        for (String deviceSerial : deviceSerialList){
            for (String dataTime = Time.getStartTime(); !dataTime.equals(Time.getEndTime()); dataTime = Time.getNextTime(dataTime,Constant.DIFFERENCE_MINUTES)){
                //对某一设备某一时间段进行数据分析
                this.analyseEvidenceData14H(deviceSerial,dataTime);
            }
        }
    }
    //插入18H证据库
    public void addEvidenceData18H(){
        //获取所有的设备列表
        List<String> deviceSerialList= rulesMapper.getAllDeviceSerial();
        //循环分析各个设备
        for (String deviceSerial : deviceSerialList){
            for (String dataTime = Time.getStartTime(); !dataTime.equals(Time.getEndTime()); dataTime = Time.getNextTime(dataTime,Constant.DIFFERENCE_MINUTES)){
                //对某一设备某一时间段进行数据分析
                this.analyseEvidenceData18H(deviceSerial,dataTime);
            }
        }
    }
}

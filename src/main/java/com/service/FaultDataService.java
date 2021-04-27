package com.service;

import com.constant.Constant;
import com.mapper.FaultDataMapper;
import com.mapper.PhenomenonDataMapper;
import com.mapper.RulesMapper;
import com.pojo.*;
import com.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FaultDataService {
    @Autowired
    private RulesMapper rulesMapper;
    @Autowired
    private PhenomenonDataMapper phenomenonDataMapper;
    @Autowired
    private FaultDataMapper faultDataMapper;

    public void addFaultData() {
        //获取所有的设备列表
        List<String> deviceSerialList= rulesMapper.getAllDeviceSerial();
        //循环分析各个设备
        for (String deviceSerial : deviceSerialList) {
            //循环分析各个证据库
            for (String dataTime = Time.getStartTime(); !dataTime.equals(Time.getEndTime()); dataTime = Time.getNextTime(dataTime, Constant.DIFFERENCE_FAULT_MINUTES)) {
                //对某一设备某一时间段进行数据分析
                this.analyseFaultData(deviceSerial, dataTime);
            }
        }
    }

    //按规则分析现象库得出故障
    private void analyseFaultData(String deviceSerial, String startTime) {
        FaultData faultData = new FaultData();

        //故障id
        int faultId;
        //故障次数
        int faultCount = 0;
        //现象出现次数
        int phenomenonNum = 0;
        //获取现象数据
        List<PhenomenonData>  phenomenonDataList = phenomenonDataMapper.getPhenomenonDataByDAT(deviceSerial,startTime,Time.getNextTime(startTime,Constant.DIFFERENCE_FAULT_MINUTES));
        //获取现象推导故障规则
        List<BeatsFault> beatsFaultList = rulesMapper.getAllBeatsFault();

        //循环判断每类故障是否出现
        for (BeatsFault beatsFault : beatsFaultList) {
            faultId = beatsFault.getFaultId();
            phenomenonNum = 0;
            for (PhenomenonData phenomenonData : phenomenonDataList) {
                //若出现所需现象
                if (phenomenonData.getPhenomenonId() == beatsFault.getNeedPhenomenonId()
                        && phenomenonData.getPhenomenonThreshold() >= beatsFault.getNeedPhenomenonThreshold()) {
                    phenomenonNum++;
                }
            }
            //如果满足条件
            if (phenomenonNum >= beatsFault.getNeedPhenomenonNum()) {
                //故障不存在
                if (faultDataMapper.hasFault(faultId, deviceSerial, startTime, Time.getNextTime(startTime, Constant.DIFFERENCE_FAULT_MINUTES)) == 0) {
                    faultData.setFaultId(faultId);
                    faultData.setStartTime(startTime);
                    faultData.setDeviceSerial(deviceSerial);
                    faultData.setFaultCount(1);
                    //写入故障
                    faultDataMapper.addFaultData(faultData);
                } else {
                    faultDataMapper.plusFaultData(faultId);
                }
            }
        }
    }

    public List<FaultData> getFaultData() {
        return faultDataMapper.getFaultData();
    }

    public List<BeatsFault> getFaultRules() {
        return faultDataMapper.getFaultRules();
    }

    public List<BeatsFaultName> getFault() {
        return faultDataMapper.getFault();
    }

    public void deleteAll(){
        rulesMapper.deleteEssentialData11H();
        rulesMapper.deleteEssentialData12H();
        rulesMapper.deleteEssentialData14H();
        rulesMapper.deleteEssentialData18H();
        rulesMapper.deleteEvidenceData11H();
        rulesMapper.deleteEvidenceData12H();
        rulesMapper.deleteEvidenceData14H();
        rulesMapper.deleteEvidenceData18H();
        rulesMapper.deletePhenomenonData();
        rulesMapper.deleteFaultData();
    }

    public void deleteEssentialData11H(){
       rulesMapper.deleteEssentialData11H();
    }

    public void deleteEssentialData12H(){
        rulesMapper.deleteEssentialData12H();
    }

    public void deleteEssentialData14H(){
        rulesMapper.deleteEssentialData14H();
    }

    public void deleteEssentialData18H(){
        rulesMapper.deleteEssentialData18H();
    }

    public void deleteEvidenceData18H(){
        rulesMapper.deleteEvidenceData18H();
    }

    public void deleteEvidenceData14H(){
        rulesMapper.deleteEvidenceData14H();
    }

    public void deleteEvidenceData12H(){
        rulesMapper.deleteEvidenceData12H();
    }

    public void deleteEvidenceData11H(){
        rulesMapper.deleteEvidenceData11H();
    }

    public void deletePhenomenonData(){
        rulesMapper.deletePhenomenonData();
    }

    public void deleteFaultData(){
        rulesMapper.deleteFaultData();
    }
}

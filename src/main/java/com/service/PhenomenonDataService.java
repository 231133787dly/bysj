package com.service;

import com.constant.Constant;

import com.mapper.EvidenceDataMapper;
import com.mapper.PhenomenonDataMapper;
import com.mapper.RulesMapper;
import com.pojo.BeatsPhenomenon;
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
        //现象编号
        int phenomenonId;
        //获取数据
        List<EvidenceData> evidenceDataList = evidenceDataMapper.getEvidenceData18HByDAT(deviceSerial,startTime,Time.getNextTime(startTime,60));
        //获取现象规则库
        List<BeatsPhenomenon> beatsPhenomenaList = rulesMapper.getAllBeatsPhenomenon();
        //循环判断每类现象是否出现
        for (BeatsPhenomenon beatsPhenomenon : beatsPhenomenaList){
            phenomenonId = beatsPhenomenon.getPhenomenonId();
            //当前时间段内同一类现象出现的阈值
            int threshold = 0;
            for(EvidenceData evidenceData : evidenceDataList){
                beatsRate = evidenceData.getBeatsRate();
                maxBeatsLackTime = evidenceData.getMaxBeatsLackTime();
                if (beatsRate <= beatsPhenomenon.getBeatsRateMax() && beatsRate > beatsPhenomenon.getBeatsRateMin()
                    && maxBeatsLackTime < beatsPhenomenon.getLackTimeMax() && maxBeatsLackTime > beatsPhenomenon.getLackTimeMin()){
                    threshold ++;
                }
            }
            //如果出现现象
            if (threshold != 0){
                phenomenonData.setPhenomenonId(phenomenonId);
                phenomenonData.setStartTime(startTime);
                phenomenonData.setDeviceSerial(deviceSerial);
                phenomenonData.setEvidenceNum(1);
                phenomenonData.setEvidenceFrom(Constant.Type_18H);
                phenomenonData.setPhenomenonThreshold(threshold);
                //写入现象
                phenomenonDataMapper.addPhenomenonData(phenomenonData);
            }
        }
    }

}
package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhenomenonData {
    @Id
    private int id;

    private int phenomenonId;

    private String startTime;

    private String deviceSerial;

    private int evidenceNum;

    private String evidenceFrom;

    private int phenomenonThreshold;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPhenomenonId() {
        return phenomenonId;
    }
    public void setPhenomenonId(int phenomenonId) {
        this.phenomenonId = phenomenonId;
    }

    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDeviceSerial(){
        return deviceSerial;
    }
    public void setDeviceSerial(String deviceSerial){
        this.deviceSerial = deviceSerial;
    }

    public int getEvidenceNum() {
        return evidenceNum;
    }
    public void setEvidenceNum(int evidenceNum) {
        this.evidenceNum = evidenceNum;
    }

    public String getEvidenceFrom(){
        return evidenceFrom;
    }
    public void setEvidenceFrom(String evidenceFrom){
        this.evidenceFrom = evidenceFrom;
    }

    public int getPhenomenonThreshold() {
        return phenomenonThreshold;
    }
    public void setPhenomenonThreshold(int phenomenonThreshold) {
        this.phenomenonThreshold = phenomenonThreshold;
    }
}

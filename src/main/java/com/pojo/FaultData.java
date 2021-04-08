package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FaultData {
    @Id
    private int id;

    private int faultId;

    private String startTime;

    private String deviceSerial;

    private int faultCount;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getFaultId() {
        return faultId;
    }
    public void setFaultId(int faultId) {
        this.faultId = faultId;
    }

    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }
    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public int getFaultCount() {
        return faultCount;
    }
    public void setFaultCount(int faultCount) {
        this.faultCount = faultCount;
    }
}

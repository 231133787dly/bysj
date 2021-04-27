package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeatsFaultName {
    @Id
    private int faultId;

    private String faultName;

    private String faultDevice;

    public int getFaultId() {
        return faultId;
    }
    public void setFaultId(int faultId) {
        this.faultId = faultId;
    }

    public String getFaultName() {
        return faultName;
    }
    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getFaultDevice() {
        return faultDevice;
    }
    public void setFaultDevice(String faultDevice) {
        this.faultDevice = faultDevice;
    }

}

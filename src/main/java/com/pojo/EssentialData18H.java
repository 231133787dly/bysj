package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EssentialData18H extends EssentialData{
    @Id
    private int id;

    private String gpsStatus;

    private String deviceSerial;

    private String datetime;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getGpsStatus(){
        return gpsStatus;
    }
    public void setGpsStatus(String gpsStatus){
        this.gpsStatus = gpsStatus;
    }

    public String getDeviceSerial(){
        return deviceSerial;
    }
    public void setDeviceSerial(String deviceSerial){
        this.deviceSerial = deviceSerial;
    }

    public String getDatetime(){
        return datetime;
    }
    public void setDatetime(String datetime){
        this.datetime = datetime;
    }
}

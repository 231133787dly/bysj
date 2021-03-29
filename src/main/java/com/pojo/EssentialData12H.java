package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EssentialData12H extends EssentialData{
    @Id
    private int id;

    private String latitude;

    private String longitude;

    private String deviceSerial;

    private String datetime;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLatitude(){
        return latitude;
    }
    public void setLatitude(String latitude){
        this.latitude = latitude;
    }

    public String getLongitude(){
        return longitude;
    }
    public void setLongitude(String longitude){
        this.longitude = longitude;
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

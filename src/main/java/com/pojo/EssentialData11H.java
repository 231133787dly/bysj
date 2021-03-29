package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EssentialData11H extends EssentialData{
    @Id
    private int id;

    private String latitude;

    private String longitude;

    private int speed;

    private String vehicleStatus;

    private String deviceSerial;

    private String datetime;

    private int routeId;

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

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getVehicleStatus(){
        return vehicleStatus;
    }
    public void setVehicleStatus(String vehicleStatus){
        this.vehicleStatus = vehicleStatus;
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

    public int getRouteId() {
        return routeId;
    }
    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
}

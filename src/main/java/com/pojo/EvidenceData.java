package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EvidenceData {
    @Id
    private int id;

    private int estimatedBeats;

    private int actualBeats;

    private int maxBeatsLackTime;

    private String startTime;

    private String deviceSerial;

    private String type;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getEstimatedBeats() {
        return estimatedBeats;
    }
    public void setEstimatedBeats(int estimatedBeats) {
        this.estimatedBeats = estimatedBeats;
    }

    public int getActualBeats() {
        return actualBeats;
    }
    public void setActualBeats(int actualBeats) {
        this.actualBeats = actualBeats;
    }

    public int getMaxBeatsLackTime() {
        return maxBeatsLackTime;
    }
    public void setMaxBeatsLackTime(int maxBeatsLackTime) {
        this.maxBeatsLackTime = maxBeatsLackTime;
    }

    public String getStartTime(){
        return startTime;
    }
    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    public String getDeviceSerial(){
        return deviceSerial;
    }
    public void setDeviceSerial(String deviceSerial){
        this.deviceSerial = deviceSerial;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

}

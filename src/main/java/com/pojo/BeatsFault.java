package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeatsFault {
    @Id
    private int id;

    private int faultId;

    private int needPhenomenonId;

    private int needPhenomenonNum;

    private double needPhenomenonThreshold;

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

    public int getNeedPhenomenonId() {
        return needPhenomenonId;
    }
    public void setNeedPhenomenonId(int needPhenomenonId) {
        this.needPhenomenonId = needPhenomenonId;
    }

    public int getNeedPhenomenonNum() {
        return needPhenomenonNum;
    }
    public void setNeedPhenomenonNum(int needPhenomenonNum) {
        this.needPhenomenonNum = needPhenomenonNum;
    }

    public double getNeedPhenomenonThreshold() {
        return needPhenomenonThreshold;
    }
    public void setNeedPhenomenonThreshold(double needPhenomenonThreshold) {
        this.needPhenomenonThreshold = needPhenomenonThreshold;
    }

}

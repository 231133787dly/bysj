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

    private int needPhenomenonThreshold;

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

    public int getNeedPhenomenonThreshold() {
        return needPhenomenonThreshold;
    }
    public void setNeedPhenomenonThreshold(int needPhenomenonThreshold) {
        this.needPhenomenonThreshold = needPhenomenonThreshold;
    }

}

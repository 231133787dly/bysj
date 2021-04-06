package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeatsPhenomenon  {
    @Id
    private int phenomenonId;

    private String phenomenonName;

    private double beatsRateMax;

    private double beatsRateMin;

    private double lackTimeMax;

    private double lackTimeMin;

    public int getPhenomenonId() {
        return phenomenonId;
    }
    public void setPhenomenonId(int phenomenonId) {
        this.phenomenonId = phenomenonId;
    }

    public String getPhenomenonName() {
        return phenomenonName;
    }
    public void setPhenomenonName(String phenomenonName) {
        this.phenomenonName = phenomenonName;
    }

    public double getBeatsRateMax() {
        return beatsRateMax;
    }
    public void setBeatsRateMax(double beatsRateMax) {
        this.beatsRateMax = beatsRateMax;
    }

    public double getBeatsRateMin() {
        return beatsRateMin;
    }
    public void setBeatsRateMin(double beatsRateMin) {
        this.beatsRateMin = beatsRateMin;
    }

    public double getLackTimeMax() {
        return lackTimeMax;
    }
    public void setLackTimeMax(double lackTimeMax) {
        this.lackTimeMax = lackTimeMax;
    }

    public double getLackTimeMin() {
        return lackTimeMin;
    }
    public void setLackTimeMin(double lackTimeMin) {
        this.lackTimeMin = lackTimeMin;
    }
}

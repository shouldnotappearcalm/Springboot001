package com.gzr.entity;

import javax.persistence.*;

/**
 * ${description}
 * Created by GZR
 * 2017-07-18
 */
@Entity
@Table(name = "trainlist")
public class TrainList {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "type")
    private String type;
    @Column(name = "startStation")
    private String startStation;
    @Column(name = "endStation")
    private String endStation;
    @Column(name = "runTime")
    private String runTime;
    @Column(name = "distance")
    private Integer distance;
    @Column(name = "businessSeat")
    private Integer businessSeat;
    @Column(name = "firstSeat")
    private Integer firstSeat;
    @Column(name = "secondSeat")
    private Integer secondSeat;
    @Column(name = "hardSeat")
    private Integer hardSeat;
    @Column(name = "softSeat")
    private Integer softSeat;
    @Column(name = "hardBerth")
    private Integer hardBerth;
    @Column(name = "softBerth")
    private Integer softBerth;
    @Column(name = "noSeat")
    private Integer noSeat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getBusinessSeat() {
        return businessSeat;
    }

    public void setBusinessSeat(Integer businessSeat) {
        this.businessSeat = businessSeat;
    }

    public Integer getFirstSeat() {
        return firstSeat;
    }

    public void setFirstSeat(Integer firstSeat) {
        this.firstSeat = firstSeat;
    }

    public Integer getSecondSeat() {
        return secondSeat;
    }

    public void setSecondSeat(Integer secondSeat) {
        this.secondSeat = secondSeat;
    }

    public Integer getHardSeat() {
        return hardSeat;
    }

    public void setHardSeat(Integer hardSeat) {
        this.hardSeat = hardSeat;
    }

    public Integer getSoftSeat() {
        return softSeat;
    }

    public void setSoftSeat(Integer softSeat) {
        this.softSeat = softSeat;
    }

    public Integer getHardBerth() {
        return hardBerth;
    }

    public void setHardBerth(Integer hardBerth) {
        this.hardBerth = hardBerth;
    }

    public Integer getSoftBerth() {
        return softBerth;
    }

    public void setSoftBerth(Integer softBerth) {
        this.softBerth = softBerth;
    }

    public Integer getNoSeat() {
        return noSeat;
    }

    public void setNoSeat(Integer noSeat) {
        this.noSeat = noSeat;
    }
}

package com.gzr.entity;

import javax.persistence.*;

/**
 * ${description}
 * Created by GZR
 * 2017-07-13
 */
@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "station")
    private String station;
    @Column(name="shortCode")
    private String shortCode;
    @Column(name = "fullCode")
    private String fullCode;
    @Column(name = "province")
    private String province;
    @Column(name = "proPinyin")
    private String proPinyin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProPinyin() {
        return proPinyin;
    }

    public void setProPinyin(String proPinyin) {
        this.proPinyin = proPinyin;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", station='" + station + '\'' +
                ", shortCode='" + shortCode + '\'' +
                ", fullCode='" + fullCode + '\'' +
                ", province='" + province + '\'' +
                ", proPinyin='" + proPinyin + '\'' +
                '}';
    }
}

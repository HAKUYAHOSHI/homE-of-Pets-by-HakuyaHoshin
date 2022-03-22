package com.example.pets.model.domain;

import com.amap.api.maps.model.Marker;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class shopThing {

    public Integer id;
    public List<BigPicTwoBean> bigPicTwo;
    public String smallPicsrc;
    public String subtitle;
    public Double rate;
    public Integer starLevel;
    public String price;
    public Boolean haveCoupon;
    public Boolean isNew;
    public Boolean haveSupplementary;
    public Boolean haveSpeciality;
    public String serviceTime;
    public String keeperTips;


    public String title;
    public Marker marker;
    public String tel;
    public String address;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BigPicTwoBean> getBigPicTwo() {
        return bigPicTwo;
    }

    public void setBigPicTwo(List<BigPicTwoBean> bigPicTwo) {
        this.bigPicTwo = bigPicTwo;
    }

    public String getSmallPicsrc() {
        return smallPicsrc;
    }

    public void setSmallPicsrc(String smallPicsrc) {
        this.smallPicsrc = smallPicsrc;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getHaveCoupon() {
        return haveCoupon;
    }

    public void setHaveCoupon(Boolean haveCoupon) {
        this.haveCoupon = haveCoupon;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getHaveSupplementary() {
        return haveSupplementary;
    }

    public void setHaveSupplementary(Boolean haveSupplementary) {
        this.haveSupplementary = haveSupplementary;
    }

    public Boolean getHaveSpeciality() {
        return haveSpeciality;
    }

    public void setHaveSpeciality(Boolean haveSpeciality) {
        this.haveSpeciality = haveSpeciality;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getKeeperTips() {
        return keeperTips;
    }

    public void setKeeperTips(String keeperTips) {
        this.keeperTips = keeperTips;
    }

    public static class BigPicTwoBean {
        public Integer idx;
        public String src;

        public Integer getIdx() {
            return idx;
        }

        public void setIdx(Integer idx) {
            this.idx = idx;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }
}

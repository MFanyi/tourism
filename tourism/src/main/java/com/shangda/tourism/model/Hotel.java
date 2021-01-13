package com.shangda.tourism.model;

import java.util.Date;

public class Hotel {
    private int id;
    private String hotelName;
    private String price;
    private String picture;
    private String address;
    private String city;
    private String commentNum;
    private String comment;
    private Date createTime;
    private String scoreLocation;
    private String scoreClear;
    private String scoreFacilities;
    private String Area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getScoreLocation() {
        return scoreLocation;
    }

    public void setScoreLocation(String scoreLocation) {
        this.scoreLocation = scoreLocation;
    }

    public String getScoreClear() {
        return scoreClear;
    }

    public void setScoreClear(String scoreClear) {
        this.scoreClear = scoreClear;
    }

    public String getScoreFacilities() {
        return scoreFacilities;
    }

    public void setScoreFacilities(String scoreFacilities) {
        this.scoreFacilities = scoreFacilities;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }
}

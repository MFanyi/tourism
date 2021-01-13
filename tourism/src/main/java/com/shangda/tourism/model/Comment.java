package com.shangda.tourism.model;

import java.util.Date;

public class Comment {
    private int id;
    private int userId;
    private int areaId;
    private String content;
    private String imageSrc;
    private Date createTime;
    private String imageThumb;
    private String scoreArea;
    private String scoreInterest;
    private String scoreCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
    }

    public String getScoreArea() {
        return scoreArea;
    }

    public void setScoreArea(String scoreArea) {
        this.scoreArea = scoreArea;
    }

    public String getScoreInterest() {
        return scoreInterest;
    }

    public void setScoreInterest(String scoreInterest) {
        this.scoreInterest = scoreInterest;
    }

    public String getScoreCost() {
        return scoreCost;
    }

    public void setScoreCost(String scoreCost) {
        this.scoreCost = scoreCost;
    }
}

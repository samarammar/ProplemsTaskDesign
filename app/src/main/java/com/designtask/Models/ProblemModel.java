package com.designtask.Models;

public class ProblemModel {
    public String proDescription;
    public String proTime;
    public String proGender;
    public String proType;
    public String proViews;
    public int proImage;

    public ProblemModel(String proDescription, String proTime, String proGender, String proType, String proViews, int proImage) {
        this.proDescription = proDescription;
        this.proTime = proTime;
        this.proGender = proGender;
        this.proType = proType;
        this.proViews = proViews;
        this.proImage = proImage;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public String getProTime() {
        return proTime;
    }

    public void setProTime(String proTime) {
        this.proTime = proTime;
    }

    public String getProGender() {
        return proGender;
    }

    public void setProGender(String proGender) {
        this.proGender = proGender;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getProViews() {
        return proViews;
    }

    public void setProViews(String proViews) {
        this.proViews = proViews;
    }

    public int getProImage() {
        return proImage;
    }

    public void setProImage(int proImage) {
        this.proImage = proImage;
    }
}

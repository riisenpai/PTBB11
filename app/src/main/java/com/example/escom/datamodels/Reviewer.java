package com.example.escom.datamodels;

public class Reviewer{
    private String updatedAt;
    private String reviewerId;
    private String createdAt;
    private int position;
    private String thesisSeminarId;
    private int status;

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setReviewerId(String reviewerId){
        this.reviewerId = reviewerId;
    }

    public String getReviewerId(){
        return reviewerId;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public int getPosition(){
        return position;
    }

    public void setThesisSeminarId(String thesisSeminarId){
        this.thesisSeminarId = thesisSeminarId;
    }

    public String getThesisSeminarId(){
        return thesisSeminarId;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
}

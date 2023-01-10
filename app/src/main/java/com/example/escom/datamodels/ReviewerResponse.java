package com.example.escom.datamodels;

public class ReviewerResponse {
    private Reviewer reviewer;
    private String message;
    private String status;

    public void setReviewer(Reviewer reviewer){
        this.reviewer = reviewer;
    }

    public Reviewer getReviewer(){
        return reviewer;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}

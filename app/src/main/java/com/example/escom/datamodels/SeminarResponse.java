package com.example.escom.datamodels;

import com.google.gson.annotations.SerializedName;

public class SeminarResponse {

    @SerializedName("room_id")
    private int roomId;

    @SerializedName("thesis_id")
    private int thesisId;

    @SerializedName("file_slide")
    private Object fileSlide;

    @SerializedName("registered_at")
    private String registeredAt;

    @SerializedName("method")
    private int method;

    @SerializedName("file_report")
    private String fileReport;

    @SerializedName("recommendation")
    private Object recommendation;

    @SerializedName("description")
    private Object description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("seminar_at")
    private String seminarAt;

    @SerializedName("file_journal")
    private Object fileJournal;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("thesis")
    private Thesis thesis;

    @SerializedName("id")
    private int id;

    @SerializedName("file_attendance")
    private Object fileAttendance;

    @SerializedName("online_url")
    private Object onlineUrl;

    @SerializedName("status")
    private int status;

    public int getRoomId(){
        return roomId;
    }

    public int getThesisId(){
        return thesisId;
    }

    public Object getFileSlide(){
        return fileSlide;
    }

    public String getRegisteredAt(){
        return registeredAt;
    }

    public int getMethod(){
        return method;
    }

    public String getFileReport(){
        return fileReport;
    }

    public Object getRecommendation(){
        return recommendation;
    }

    public Object getDescription(){
        return description;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public String getSeminarAt(){
        return seminarAt;
    }

    public Object getFileJournal(){
        return fileJournal;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public Thesis getThesis(){
        return thesis;
    }

    public int getId(){
        return id;
    }

    public Object getFileAttendance(){
        return fileAttendance;
    }

    public Object getOnlineUrl(){
        return onlineUrl;
    }

    public int getStatus(){
        return status;
    }
}
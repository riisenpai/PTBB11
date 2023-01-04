package com.example.escom.datamodels;

import com.google.gson.annotations.SerializedName;

public class LogbooksItem{

    @SerializedName("date")
    private String date;

    @SerializedName("thesis_id")
    private int thesisId;

    @SerializedName("notes")
    private Object notes;

    @SerializedName("supervisor_id")
    private int supervisorId;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("supervised_at")
    private Object supervisedAt;

    @SerializedName("file_progress")
    private String fileProgress;

    @SerializedName("supervised_by")
    private Object supervisedBy;

    @SerializedName("problem")
    private String problem;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("progress")
    private String progress;

    @SerializedName("file_notes")
    private Object fileNotes;

    @SerializedName("id")
    private int id;

    @SerializedName("status")
    private int status;

    public String getDate(){
        return date;
    }

    public int getThesisId(){
        return thesisId;
    }

    public Object getNotes(){
        return notes;
    }

    public int getSupervisorId(){
        return supervisorId;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public Object getSupervisedAt(){
        return supervisedAt;
    }

    public String getFileProgress(){
        return fileProgress;
    }

    public Object getSupervisedBy(){
        return supervisedBy;
    }

    public String getProblem(){
        return problem;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public String getProgress(){
        return progress;
    }

    public Object getFileNotes(){
        return fileNotes;
    }

    public int getId(){
        return id;
    }

    public int getStatus(){
        return status;
    }
}
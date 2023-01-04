package com.example.escom.datamodels;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListPermintaanTAResponse{

    @SerializedName("thesis")
    private List<PermintaanItem> thesis;

    @SerializedName("count")
    private int count;

    @SerializedName("status")
    private String status;

    public List<PermintaanItem> getThesis(){
        return thesis;
    }

    public int getCount(){
        return count;
    }

    public String getStatus(){
        return status;
    }
}
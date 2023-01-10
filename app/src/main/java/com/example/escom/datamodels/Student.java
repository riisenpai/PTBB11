package com.example.escom.datamodels;

import com.google.gson.annotations.SerializedName;

public class Student{

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("address")
    private Object address;

    @SerializedName("gender")
    private int gender;

    @SerializedName("year")
    private int year;

    @SerializedName("department_id")
    private int departmentId;

    @SerializedName("photo")
    private Object photo;

    @SerializedName("created_at")
    private Object createdAt;

    @SerializedName("religion")
    private int religion;

    @SerializedName("nik")
    private String nik;

    @SerializedName("marital_status")
    private int maritalStatus;

    @SerializedName("nim")
    private String nim;

    @SerializedName("birthplace")
    private String birthplace;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("phone")
    private String phone;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("status")
    private int status;

    public String getBirthday(){
        return birthday;
    }

    public Object getAddress(){
        return address;
    }

    public int getGender(){
        return gender;
    }

    public int getYear(){
        return year;
    }

    public int getDepartmentId(){
        return departmentId;
    }

    public Object getPhoto(){
        return photo;
    }

    public Object getCreatedAt(){
        return createdAt;
    }

    public int getReligion(){
        return religion;
    }

    public String getNik(){
        return nik;
    }

    public int getMaritalStatus(){
        return maritalStatus;
    }

    public String getNim(){
        return nim;
    }

    public String getBirthplace(){
        return birthplace;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public String getPhone(){
        return phone;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public int getStatus(){
        return status;
    }
}
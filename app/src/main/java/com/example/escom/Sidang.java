package com.example.escom;

public class Sidang {
    private String name;
    private String description;
    private String waktu;
    private String tempat;
    private Integer photo;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPhoto() {
        return photo;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getTempat() {
        return tempat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public void setTempat(String tempat) {
        this.tempat= tempat;
    }
}

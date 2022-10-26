package com.example.escom;

public class Semdang {
    private String name;
    private String description;
    private Integer photo;
    private String judul;
    private String dosen;
    private String tempat;
    private String tanggaluji;

    public String getName() {
        return name;
    }

    public Integer getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getJudul() {
        return judul;
    }

    public String getDosen() {
        return dosen;
    }

    public String getTempat() {
        return tempat;
    }

    public String getTanggaluji() {
        return tanggaluji;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public void setTanggaluji(String tanggaluji) {
        this.tanggaluji = tanggaluji;
    }
}

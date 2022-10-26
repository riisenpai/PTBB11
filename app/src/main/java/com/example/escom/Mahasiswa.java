package com.example.escom;

public class Mahasiswa {
    private String name;
    private String description;
    private String judul;
    private String dosen;
    private String tanggal;
    private String status;
    private Integer photo;

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

    public String getTanggal() {
        return tanggal;
    }

    public String getStatus() {
        return status;
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

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

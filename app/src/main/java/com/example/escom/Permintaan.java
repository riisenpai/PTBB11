package com.example.escom;

public class Permintaan {
    private String name;
    private String description;
    private Integer photo;
    private String judul;
    private String tanggal;
    private String dosen;
    private String nim;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPhoto() {
        return photo;
    }

    public String getJudul() {
        return judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getDosen() {
        return dosen;
    }

    public String getNim() {
        return nim;
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

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}

package com.example.myapplication7;

import com.google.gson.annotations.SerializedName;

public class Mahasiswa {
    @SerializedName("NIM")
    private int NIM;

    @SerializedName("Nama")
    private String Nama;

    @SerializedName("email")
    private String email;

    @SerializedName("alamat")
    private String alamat;


    // Konstruktor untuk membuat objek User baru
    public Mahasiswa() {
        this.NIM = NIM;
        this.Nama = Nama;
        this.email = email;
        this.alamat = alamat;
    }

    // Konstruktor untuk membuat objek User tanpa NIM (misalnya, untuk menambahkan user baru)
    public Mahasiswa(String Nama, String email, String alamat) {
        this.Nama = Nama;
        this.email = email;
        this.alamat = alamat;
    }

    // Getter untuk mendapatkan NIM user
    public int getNIM() {
        return NIM;
    }

    // Setter untuk mengatur NIM user
    public void setNIM(int NIM) {
        this.NIM = NIM;
    }

    // Getter untuk mendapatkan nama user
    public String getNama() {
        return Nama;
    }

    // Setter untuk mengatur nama user
    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    // Getter untuk mendapatkan email user
    public String getEmail() {
        return email;
    }

    // Setter untuk mengatur email user
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter untuk mendapatkan alamat user
    public String getAlamat() {
        return alamat;
    }

    // Setter untuk mengatur alamat user
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

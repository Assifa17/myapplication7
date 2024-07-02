package com.example.myapplication7;
import com.google.gson.annotations.SerializedName;

public class Dosen {
    @SerializedName("NIK")
    private String NIK;

    @SerializedName("NIDN")
    private String NIDN;

    @SerializedName("Nama")
    private String Nama;

    @SerializedName("Alamat")
    private String alamat;


    // Konstruktor untuk membuat objek User baru
    public Dosen() {
        this.NIK = NIK;
        this.NIDN = NIDN;
        this.Nama = Nama;
        this.alamat = alamat;
    }

    // Konstruktor untuk membuat objek User tanpa id (misalnya, untuk menambahkan user baru)
    public Dosen(String NIK, String NIDN,String Nama, String alamat) {
        this.NIK = NIK;
        this.NIDN = NIDN;
        this.Nama = Nama;
        this.alamat = alamat;
    }

    // Getter untuk mendapatkan id user
    public String getNIK() {
        return NIK;
    }

    // Setter untuk mengatur id user
    public void setNIK(String NIK) {
        this.NIK = NIK;
    }
    public String geNIDN() {
        return NIDN;
    }

    // Setter untuk mengatur id user
    public void setNIDN(int NIDN) {
        this.NIDN = String.valueOf(NIDN);
    }

    // Getter untuk mendapatkan nama user
    public String getNama() {
        return getNama();
    }

    // Setter untuk mengatur nama user
    public void setNama(String Nama) {
        this.Nama = Nama;
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

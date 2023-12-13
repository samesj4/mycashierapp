package com.bospintar.cashier.model;

public class Mpetugas {
    private String id , nama, level,alamat_petugas,nohp,idtoko,nama_toko,alamat_toko,status_toko;


    public Mpetugas(String id, String nama, String level, String alamat_petugas, String nohp , String idtoko, String nama_toko, String alamat_toko, String status_toko) {
        this.id = id;
        this.nama=nama;
        this.level = level;
        this.alamat_petugas = alamat_petugas;
        this.nohp = nohp;
        this.idtoko = idtoko;
        this.nama_toko = nama_toko;
        this.alamat_toko = alamat_toko;
        this.status_toko = status_toko;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAlamat_petugas() {
        return alamat_petugas;
    }

    public void setAlamat_petugas(String alamat_petugas) {
        this.alamat_petugas = alamat_petugas;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getIdtoko() {
        return idtoko;
    }

    public void setIdtoko(String idtoko) {
        this.idtoko = idtoko;
    }

    public String getNama_toko() {
        return nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }

    public String getAlamat_toko() {
        return alamat_toko;
    }

    public void setAlamat_toko(String alamat_toko) {
        this.alamat_toko = alamat_toko;
    }

    public String getStatus_toko() {
        return status_toko;
    }

    public void setStatus_toko(String status_toko) {
        this.status_toko = status_toko;
    }
}

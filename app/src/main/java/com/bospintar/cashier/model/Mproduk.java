package com.bospintar.cashier.model;

public class Mproduk {
    private String id , nama, hargajual,hargabeli,grosir,stok,satuan,isi_stok;


    public Mproduk(String id, String nama, String hargajual, String hargabeli, String grosir , String stok,String satuan,String isi_stok) {
        this.id = id;
        this.nama=nama;
        this.hargajual = hargajual;
        this.hargabeli = hargabeli;
        this.grosir = grosir;
        this.stok = stok;
        this.satuan = satuan;
        this.isi_stok = isi_stok;
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

    public String getHargajual() {
        return hargajual;
    }

    public void setHargajual(String hargajual) {
        this.hargajual = hargajual;
    }

    public String getHargabeli() {
        return hargabeli;
    }

    public void setHargabeli(String hargabeli) {
        this.hargabeli = hargabeli;
    }

    public String getGrosir() {
        return grosir;
    }

    public void setGrosir(String grosir) {
        this.grosir = grosir;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getIsi_stok() {
        return isi_stok;
    }

    public void setIsi_stok(String isi_stok) {
        this.isi_stok = isi_stok;
    }
}

package com.bospintar.cashier.model;

public class Mpengeluaran {
    private String id , tanggal, keterangan,nominal,idtoko;


    public Mpengeluaran(String id, String tanggal, String keterangan, String nominal, String idtoko) {
        this.id = id;
        this.tanggal=tanggal;
        this.keterangan = keterangan;
        this.nominal = nominal;
        this.idtoko = idtoko;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getIdtoko() {
        return idtoko;
    }

    public void setIdtoko(String idtoko) {
        this.idtoko = idtoko;
    }
}


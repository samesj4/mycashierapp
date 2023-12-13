package com.bospintar.cashier.model;

public class Mhome {
    private String nota , totalbayar, tanggal,jbayar,idtoko;


    public Mhome(String nota, String totalbayar, String tanggal, String jbayar, String idtoko) {
        this.nota = nota;
        this.totalbayar=totalbayar;
        this.tanggal = tanggal;
        this.jbayar = jbayar;
        this.idtoko = idtoko;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getTotalbayar() {
        return totalbayar;
    }

    public void setTotalbayar(String totalbayar) {
        this.totalbayar = totalbayar;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJbayar() {
        return jbayar;
    }

    public void setJbayar(String jbayar) {
        this.jbayar = jbayar;
    }

    public String getIdtoko() {
        return idtoko;
    }

    public void setIdtoko(String idtoko) {
        this.idtoko = idtoko;
    }
}

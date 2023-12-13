package com.bospintar.cashier.model;

public class MtransaksiDetail {
    private String idb ,namabarang, jumlah_penjualan, idpetugas,harga_jual,harga_beli;


    public MtransaksiDetail(String idb,String namabarang, String jumlah_penjualan, String idpetugas, String harga_jual,String harga_beli) {
        this.idb = idb;
        this.namabarang = namabarang;
        this.jumlah_penjualan=jumlah_penjualan;
        this.idpetugas = idpetugas;
        this.harga_jual = harga_jual;
        this.harga_beli = harga_beli;
    }

    public String getIdb() {
        return idb;
    }

    public void setIdb(String idb) {
        this.idb = idb;
    }

    public String getJumlah_penjualan() {
        return jumlah_penjualan;
    }

    public void setJumlah_penjualan(String jumlah_penjualan) {
        this.jumlah_penjualan = jumlah_penjualan;
    }

    public String getIdpetugas() {
        return idpetugas;
    }

    public void setIdpetugas(String idpetugas) {
        this.idpetugas = idpetugas;
    }

    public String getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(String harga_jual) {
        this.harga_jual = harga_jual;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(String harga_beli) {
        this.harga_beli = harga_beli;
    }
}

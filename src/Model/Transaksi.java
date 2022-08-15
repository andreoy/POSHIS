/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author andreo
 */
public class Transaksi {

    public static final String[] COLUMN_NAME = {"id_checkin", "id_layanan", "id_user","jumlah", "tgl_layanan"};
    public static final String TB_NAME = "tb_transaksi";

    private int id_transaksi;
    private int id_checkin;
    private int id_layanan;
    private int id_user;
    private String namaLayanan;
    private double harga;
    private int jumlah;
    private Date tgl_layanan;

    public Transaksi(int id_checkin, int id_layanan,int id_user, int jumlah, Date tgl_layanan) {

        this.id_checkin = id_checkin;
        this.id_layanan = id_layanan;
        this.jumlah = jumlah;
        this.tgl_layanan = tgl_layanan;
    }

    public Transaksi() {

    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    

    public int getIdtransaksi() {
        return id_transaksi;
    }

    public void setIdTransaksi(int transaksi) {
        this.id_transaksi = transaksi;
    }

    public int getId_Checkin() {
        return id_checkin;
    }

    public void setId_Checkin(int id_checkin) {
        this.id_checkin = id_checkin;
    }

    public int getId_layanan() {
        return id_layanan;
    }

    public void setId_layanan(int id_layanan) {
        this.id_layanan = id_layanan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Date getTgl_layanan() {
        return tgl_layanan;
    }

    public void setTgl_layanan(Date tgl_layanan) {
        this.tgl_layanan = tgl_layanan;
    }

//    @Override
//    String getTableName() {
//        return TABLE_NAME;
//    }
//
//    @Override
//    String[] getField() {
//        return COLUMN_NAME;
//    }
    public String getNamaLayanan() {
        return namaLayanan;
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

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
public class InfoCheckIn {

    public static final String[] COLUMN_NAME = {"id_pasien", "id_ruangan", "tgl_masuk"};
    public static final String TB_NAME = "tb_cekin";

    private int id_checkIn;
    private int id_pasien;
    private int id_ruangan;

    private Date tgl_masuk;
    private String nama;
    private String ruang;
    private int status;
    
    private Date tgl_keluar;

    public InfoCheckIn(int id_pasien, int id_ruangan, Date tgl_masuk) {

        this.id_pasien = id_pasien;
        this.id_ruangan = id_ruangan;
        this.tgl_masuk = tgl_masuk;
        
    }

    public InfoCheckIn() {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public int getId_checkIn() {
        return id_checkIn;
    }

    public void setId_checkIn(int id_checkIn) {
        this.id_checkIn = id_checkIn;
    }

    public int getId_ruangan() {
        return id_ruangan;
    }

    public void setId_ruangan(int id_ruangan) {
        this.id_ruangan = id_ruangan;
    }

    public Date getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(Date tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

//    @Override
//    String getTableName() {
//        return TB_NAME;
//    }
//
//    @Override
//    String[] getField() {
//        return COLUMN_NAME;
//    }    
    public int getId_Pasien() {
        return id_pasien;
    }

    public void setId_Pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

}

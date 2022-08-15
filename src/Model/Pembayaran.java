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
public class Pembayaran {

    public static final String[] COLUMN_NAME = {"id_checkin", "status", "jumlah", "tanggal","id_user","id_sesi"};
    public static final String TB_NAME = "tb_pembayaran";

    private int id_pembayaran;
    private int id_checkin;
    private int status;
    private double jumlah;
    Date tanggal;
    private int id_user;
    private int id_sesi;

    public Pembayaran(int id_checkin, int status, double jumlah) {
        this.id_checkin = id_checkin;
        this.status = status;
        this.jumlah = jumlah;
    }

    public Pembayaran() {

    }

    public int getId_sesi() {
        return id_sesi;
    }

    public void setId_sesi(int id_sesi) {
        this.id_sesi = id_sesi;
    }
    

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    
    
    public int getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(int id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public int getId_Checkin() {
        return id_checkin;
    }

    public void setId_Checkin(int id_checkin) {
        this.id_checkin = id_checkin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    

}

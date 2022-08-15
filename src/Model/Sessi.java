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
public class Sessi {
    
    public final String[] COLUMN_NAME = {"id_kasir","time_open_sesi","saldo_awal","status","time_close_sesi","saldo_akhir"};
    public final String TB_NAME = "tb_sesi";
    
    private int id_sesi;
    private int id_kasir;
    private String time_open_sesi;
    private double saldo_awal;
    private int status;
    private String time_close_sesi;
    private double saldo_akhir;

    public Sessi(int id_sesi, int id_kasir, String time_open_sesi, double saldo_awal, int status, String time_close_sesi, double saldo_akhir) {
        this.id_sesi = id_sesi;
        this.id_kasir = id_kasir;
        this.time_open_sesi = time_open_sesi;
        this.saldo_awal = saldo_awal;
        this.status = status;
        this.time_close_sesi = time_close_sesi;
        this.saldo_akhir = saldo_akhir;
    }
    
    public Sessi(){
        
    }

    public int getId_sesi() {
        return id_sesi;
    }

    public void setId_sesi(int id_sesi) {
        this.id_sesi = id_sesi;
    }

    public int getId_kasir() {
        return id_kasir;
    }

    public void setId_kasir(int id_kasir) {
        this.id_kasir = id_kasir;
    }

    public String getTime_open_sesi() {
        return time_open_sesi;
    }

    public void setTime_open_sesi(String time_open_sesi) {
        this.time_open_sesi = time_open_sesi;
    }

    public double getSaldo_awal() {
        return saldo_awal;
    }

    public void setSaldo_awal(double saldo_awal) {
        this.saldo_awal = saldo_awal;
    }

    public String getStatus() {
        if(status==0) return "Close";
        else return "Open";
    }
    
    public int getRealStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime_close_sesi() {
        return time_close_sesi;
    }

    public void setTime_close_sesi(String time_close_sesi) {
        this.time_close_sesi = time_close_sesi;
    }

    public double getSaldo_akhir() {
        return saldo_akhir;
    }

    public void setSaldo_akhir(double saldo_akhir) {
        this.saldo_akhir = saldo_akhir;
    }
    
    
    
    
}

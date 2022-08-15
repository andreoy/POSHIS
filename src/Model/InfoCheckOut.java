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
public class InfoCheckOut {

    public static final String[] COLUMN_NAME = {"id_checkIn", "tgl_keluar"};
    public static final String TB_NAME = "tb_cekout";

    private int id_checkOut;
    private int id_checkIn; //unik'\
    private Date tgl_keluar;

    public InfoCheckOut(int id_checkIn, Date tgl_keluar) {

        this.id_checkIn = id_checkIn;
        this.tgl_keluar = tgl_keluar;
    }

    public InfoCheckOut() {

    }

    public int getId_checkIn() {
        return id_checkIn;
    }

    public void setId_checkIn(int id_checkIn) {
        this.id_checkIn = id_checkIn;
    }

    public int getId_checkOut() {
        return id_checkOut;
    }

    public void setId_checkOut(int id_checkOut) {
        this.id_checkOut = id_checkOut;
    }

    public Date getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(Date tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

//
//    @Override
//    String getTableName() {
//        return TB_NAME;
//    }
//
//    @Override
//    String[] getField() {
//        return COLUMN_NAME;
//    }
}

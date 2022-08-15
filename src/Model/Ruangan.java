/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author andreo
 */
public class Ruangan {

    public static final String[] COLUMN_NAME = {"nama_ruang", "status"};
    public static final String TABLE_NAME = "tb_ruangan";

    private int id_ruangan;
    private String nama_ruang;
    private int status;

    public Ruangan(String nama_ruang, int status) {

        this.nama_ruang = nama_ruang;
        this.status = status;
    }

    public Ruangan() {

    }

    public int getId_ruangan() {
        return id_ruangan;
    }

    public void setId_ruangan(int id_ruangan) {
        this.id_ruangan = id_ruangan;
    }

    public String getNama_ruang() {
        return nama_ruang;
    }

    public void setNama_ruang(String nama_ruang) {
        this.nama_ruang = nama_ruang;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

//    @Override
//    String[] getField() {
//        return COLUMN_NAME;
//    }
//
//    @Override
//    String getTableName() {
//        return TABLE_NAME;
//    }
}

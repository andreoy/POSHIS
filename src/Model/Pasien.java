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
public class Pasien {

    public final String[] COLUMN_NAME = {"name", "jenkel", "tmpt_lahir", "tgl_lahir", "alamat"};
    public final String TB_NAME = "tb_pasien";

    private int id_pasien;
    private String name;
    private String jenkel;
    private String tmpt_lahir;
    private Date tgl_lahir;
    private String alamat;

    public Pasien() {
    }

    public Pasien(String name, String tmpt_lahir, Date tgl_lahir, String jenkel, String alamat) {
        this.name = name;
        this.tmpt_lahir = tmpt_lahir;
        this.tgl_lahir = tgl_lahir;
        this.jenkel = jenkel;
        this.alamat = alamat;
    }

    public String getJenkel() {
        return jenkel;
    }

    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTmpt_lahir() {
        return tmpt_lahir;
    }

    public void setTmpt_lahir(String tmpt_lahir) {
        this.tmpt_lahir = tmpt_lahir;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

//    @Override
//    String[] getField() {
//        return COLUMN_NAME;
//    }
//
//    @Override
//    String getTableName() {
//        return TB_NAME;int
//    }
}

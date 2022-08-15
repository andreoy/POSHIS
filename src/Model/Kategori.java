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
public class Kategori {

    public final String[] COLUMN_NAME = {"kategori", "keterangan"};
    public final String TB_NAME = "tb_kategori";

    private int id_kategori;
    private String kategori;
    private String keterangan;

    public Kategori(String kategori, String keterangan) {

        this.kategori = kategori;
        this.keterangan = keterangan;
    }

    public Kategori() {

    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

//    @Override
//    String[] getField() {
//        return COLUMN_NAME;
//    }
//
//    @Override
//    String getTableName() {
//        return TB_NAME;
//    }
}

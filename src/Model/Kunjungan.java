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
public class Kunjungan {

    public final String[] COLUMN_NAME = {"kode_kunjungan", "id_pasien", "keterangan"};
    public final String TB_NAME = "tb_kunjungan";

    private int id_kunjungan;
    private String kode_kunjungan;
    private int id_pasien;
    private String keterangan;

    public Kunjungan(String kode_kunjungan, int id_pasien, String keterangan) {
        this.kode_kunjungan = kode_kunjungan;
        this.id_pasien = id_pasien;
        this.keterangan = keterangan;
    }

    public Kunjungan() {

    }

    public int getId_kunjungan() {
        return id_kunjungan;
    }

    public void setId_kunjungn(int id_kunjungan) {
        this.id_kunjungan = id_kunjungan;
    }

    public String getKode_kunjungan() {
        return kode_kunjungan;
    }

    public void setKode_kunjungan(String kode_kunjungan) {
        this.kode_kunjungan = kode_kunjungan;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
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

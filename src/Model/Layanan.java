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
public class Layanan{
    
    public final String[] COLUMN_NAME = {"id_kategori","layanan", "biaya", "keterangan"};
    public final String TB_NAME = "tb_layanan";
    
    private int id_layanan;
    private int id_kategori;
    private String layanan;
    private double biaya;
    private String keterangan;
    
    private String kategori;
    
    public Layanan(){
        
    }

    public Layanan(int id_kategori, String layanan, double biaya, String keterangan) {
//        this.id_layanan = id_layanan;
        this.id_kategori = id_kategori;
        this.layanan = layanan;
        this.biaya = biaya;
        this.keterangan = keterangan;
    }

    public int getId_layanan() {
        return id_layanan;
    }

    public void setId_layanan(int id_layanan) {
        this.id_layanan = id_layanan;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getLayanan() {
        return layanan;
    }

    public void setLayanan(String layanan) {
        this.layanan = layanan;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

//    public String getKategori(KasirDB db) throws SQLException{
//        
//        return new KategoriManager(db).getDataById(this.id_kategori).get(0).getKategori();
//        
//    }
    
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

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
public class Kasir {
    
    public final String[] COLUMN_NAME = {"kasir"};
    public final String TB_NAME = "tb_kasir";
    
    private int id_kasir;
    private String kasir;

    public Kasir(String kasir) {
       
        this.kasir = kasir;
    }

    public Kasir() {
        
    }

    public int getId_kasir() {
        return id_kasir;
    }

    public void setId_kasir(int id_kasir) {
        this.id_kasir = id_kasir;
    }

    public String getKasir() {
        return kasir;
    }

    public void setKasir(String kasir) {
        this.kasir = kasir;
    }
    
    
    
}

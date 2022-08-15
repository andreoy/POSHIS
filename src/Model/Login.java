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
public class Login {

    public final String[] COLUMN_NAME = {"id_user", "time_aktif"};
    public final String TABLE_NAME ="tb_login";
    
    private int id_login;
    private int id_operator;
    private String nama_operator;
    private Date waktu_login;
    private Date waktu_logout;
    
    

    public Login(int id_login, int id_operator, String nama_operator, Date waktu_login, Date waktu_logout) {
        this.id_login = id_login;
        this.id_operator = id_operator;
        this.nama_operator = nama_operator;
        this.waktu_login = waktu_login;
        this.waktu_logout = waktu_logout;
    }

    public Login() {
        
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public int getId_operator() {
        return id_operator;
    }

    public void setId_operator(int id_operator) {
        this.id_operator = id_operator;
    }

    public String getNama_operator() {
        return nama_operator;
    }

    public void setNama_operator(String nama_operator) {
        this.nama_operator = nama_operator;
    }

    public Date getWaktu_login() {
        return waktu_login;
    }

    public void setWaktu_login(Date waktu_login) {
        this.waktu_login = waktu_login;
    }

    public Date getWaktu_logout() {
        return waktu_logout;
    }

    public void setWaktu_logout(Date waktu_logout) {
        this.waktu_logout = waktu_logout;
    }
    
    
    
    
}

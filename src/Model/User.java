/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import java.sql.Date;
import java.util.Date;

/**
 *
 * @author andreo
 */
public class User {

    public static final String[] COLUMN_NAME = {"name", "tempat", "tgl_lahir", "kelamin", "alamat", "telp", "username", "status", "password"};
    public static final String TABLE_NAME = "tb_user";

    public User() {

    }

    public enum type {
        Administrator, Kasir
    };

    private int id_user;
    private String name;
    private String tempat;
    private Date tgl_lahir;
    private int kelamin;
    private String alamat;
    private String telp;

    private String username;
    private type status;
    private String password;

    public User(String name, String tempat, Date tgl_lahir, int kelamin, String alamat, String telp, String username, type status, String password) {
        this.name = name;
        this.tempat = tempat;
        this.tgl_lahir = tgl_lahir;
        this.kelamin = kelamin;
        this.alamat = alamat;
        this.telp = telp;
        this.username = username;
        this.status = status;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public int getKelamin() {
        return kelamin;
    }

    public void setKelamin(int kelamin) {
        this.kelamin = kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public type getStatus() {
        return status;
    }

    public void setStatus(type status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
//    
}

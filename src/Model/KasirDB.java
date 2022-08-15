/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andreo
 */
public class KasirDB {

    private Connection connection;
    private final String DB_NAME = "kasir_RS";
    private final String TB_PASIEN = "tb_pasien";
    private final String TB_USER = "tb_user";
    private final String TB_LAYANAN = "tb_layanan";
    private final String TB_KATEGORI = "tb_kategori";
    private final String TB_CEKIN = "tb_cekin";
    private final String TB_CEKOUT = "tb_cekout";
    private final String TB_TRANSAKSI = "tb_transaksi";
     private final String TB_KUNJUNGAN = "tb_kunjungan";
    private final String TB_RUANGAN = "tb_ruangan";
    private final String TB_PEMBAYARAN = "tb_pembayaran";
    private final String TB_LOGIN = "tb_login";
    private final String TB_KASIR = "tb_kasir";
//    private final String TB_KASIR_AKTIF = "tb_kasir_aktif";
    private final String TB_SESI = "tb_sesi";
    private Statement stmt; 

    public KasirDB() throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);

            System.out.println("Opened database successfully 1");
            stmt = connection.createStatement();
            String TB_STATUS_BAYAR;
            
            String qTableKasir = "CREATE TABLE "+TB_KASIR
                    + "(id_kasir INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "kasir TEXT NOT NULL UNIQUE)";
            
            String qTableSesi = "CREATE TABLE "+TB_SESI
                    +" (id_sesi INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " id_kasir INTEGER,"
                    + " time_open_sesi DATETIME,"
                    + " saldo_awal REAL,"
                    + " status INT,"
                    + " time_close_sesi DATETIME,"
                    + " saldo_akhir REAL)";
            
//          BELUM DI EKSEKUSI  
            String qTableAktif = "CREATE TABLE "+TB_LOGIN
                    + "( id_login INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "id_user INTEGER NOT NULL,"
                    + "id_sesi INTEGER NOT NULL,"
                    + "time_aktif DATETIME NOT NULL,"
                    + "time_disaktif DATETIME)";


            String qTablePasien = "CREATE TABLE " + TB_PASIEN
                    + "(id_pasien INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + "name TEXT NOT NULL,"
                    + "jenkel TEXT NOT NULL,"
                    + "tmpt_lahir TEXT NOT NULL,"
                    + "alamat TEXT,"
                    + "tgl_lahir DATETIME NOT NULL,"
                    + "id_tag_nfc TEXT UNIQUE)";
            
            String qTableUser = "CREATE TABLE " + TB_USER
                    + "(id_user INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + "name TEXT NOT NULL,"
                    + "tempat TEXT NOT NULL,"
                    + "tgl_lahir DATETIME NOT NULL,"
                    + "kelamin INT NOT NULL,"
                    + "alamat TEXT NOT NULL,"
                    + "telp TEXT NOT NULL,"
                    + "username TEXT UNIQUE,"
                    + "status TEXT NOT NULL,"
                    + "password TEXT NOT NULL)";
           
            String qTableLayanan = "CREATE TABLE " + TB_LAYANAN
                    + "(id_layanan INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + "id_kategori INT NOT NULL,"
                    + "layanan TEXT NOT NULL,"
                    + "biaya REAL NOT NULL,"
                    + "keterangan TEXT NOT NULL)";

            String qTableKategori = "CREATE TABLE " + TB_KATEGORI
                    + "(id_kategori INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + "kategori TEXT NOT NULL,"
                    + "keterangan TEXT)";
            
            String qTableCekin = "CREATE TABLE " + TB_CEKIN
                    + "(id_checkIn INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + "id_pasien INT NOT NULL,"
                    + "id_ruangan INT NOT NULL,"
                    + "tgl_masuk DATETIME NOT NULL)";

            String qTableCekout = "CREATE TABLE " + TB_CEKOUT
                    + "(id_checkout INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + "id_checkIn INT NOT NULL UNIQUE,"
                    + "tgl_keluar DATETIME NOT NULL)";

            String qTableTransaksi = "CREATE TABLE " + TB_TRANSAKSI
                    + "(id_transaksi INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + "id_checkin INT NOT NULL,"
                    + "id_layanan INT NOT NULL,"
                    + "id_user INT NOT NULL,"
                     
                    + "jumlah INT NOT NULL,"
                    + "tgl_layanan DATETIME NOT NULL)";
                  
            String qTableKunjungan = "CREATE TABLE " + TB_KUNJUNGAN
                    + "(id_kunjungan INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + "kode_kunjungan TEXT NOT NULL UNIQUE,"
                    + "id_pasien INT NOT NULL)";
        
            String qTableRuangan = "CREATE TABLE " + TB_RUANGAN
                    + "(id_ruangan INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
                    + "nama_ruang TEXT NOT NULL UNIQUE,"
                    + "status INTEGER NOT NULL)";

            String qStatusBayar = "CREATE TABLE " + TB_PEMBAYARAN
                    + "(id_status_bayar INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "id_checkin INTEGER NOT NULL,"
                    + "status INTEGER NOT NULL,"
                    + "jumlah DOUBLE,"
                    + "tanggal DATETIME NOT NULL,"
                    + "id_user NOT NULL,"
                    + "id_sesi NOT NULL)";
             
//            stmt.executeUpdate("drop table if exists " + TB_PASIEN + ";");
//              stmt.executeUpdate("drop table if exists "+ TB_USER +";");
//            stmt.executeUpdate("drop table if exists " + TB_LAYANAN + ";");
//            stmt.executeUpdate("drop table if exists " + TB_KATEGORI + ";");
//            stmt.executeUpdate("drop table if exists " + TB_CEKIN + ";");
//            stmt.executeUpdate("drop table if exists " + TB_CEKOUT + ";");
//            stmt.executeUpdate("drop table if exists " + TB_TRANSAKSI + ";");
//            stmt.executeUpdate("drop table if exists " + TB_KUNJUNGAN + ";");
//            stmt.executeUpdate("drop table if exists " + TB_RUANGAN + ";");
//            stmt.executeUpdate("drop table if exists " + TB_PEMBAYARAN + ";");
//                stmt.executeUpdate("drop table if exists " + TB_LOGIN + ";");
//              stmt.executeUpdate("drop table if exists "+ TB_KASIR +";");
//              stmt.executeUpdate("drop table if exists "+ TB_KASIR_AKTIF +";");
//              stmt.executeUpdate("drop table if exists "+ TB_SESI +";");
//            stmt.executeUpdate(qTablePasien);
//              stmt.executeUpdate(qTableUser);
//            stmt.executeUpdate(qTableLayanan);
//            stmt.executeUpdate(qTableKategori);
//            stmt.executeUpdate(qTableCekin);
//            stmt.executeUpdate(qTableCekout);
//            stmt.executeUpdate(qTableTransaksi);
//            stmt.executeUpdate(qTableKunjungan);
//            stmt.executeUpdate(qTableRuangan);
//            stmt.executeUpdate(qStatusBayar);
//                stmt.executeUpdate(qTableAktif);  
//              stmt.executeUpdate(qTableKasir);
//              stmt.executeUpdate(qTableSesi);
            stmt.close();
//            connection.close(); //gunakan setelah log out

        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.exit(0);

        }

    }

    public Connection getConnection() {
        return connection;
    }

}

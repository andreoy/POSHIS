/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.KasirDB;
import Model.Transaksi;

import Tools.Widget;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import java.util.ArrayList;


/**
 *
 * @author andreo
 */
public class TransaksiManager {

    Connection connection;

    public TransaksiManager(KasirDB db) {

        this.connection = db.getConnection();

    }


      public Transaksi addTransaksi(Transaksi transaksi) throws SQLException {

        try (Statement stmt = connection.createStatement()) {

            String column = Widget.columntoinput(Transaksi.COLUMN_NAME);

            

                String sql = "INSERT INTO " + Transaksi.TB_NAME + "(" + column + ")"
                        + "VALUES ('" + transaksi.getId_Checkin() + "',"
                        + transaksi.getId_layanan() + ","
                        + transaksi.getId_user()+","
                        + transaksi.getJumlah() + ",'"
                        + transaksi.getTgl_layanan() + "')";

                String sql_max_id = "SELECT MAX(id_transaksi)  FROM " + Transaksi.TB_NAME;
                System.out.println(sql);
            
                stmt.execute(sql);
            
            try (ResultSet rs = stmt.executeQuery(sql_max_id)) {
                while (rs.next()) {
                    
                    transaksi.setIdTransaksi(rs.getInt(1));
                    
                }
                rs.close();

            }
            
            stmt.close();
        }
        
        return transaksi;
    }

    public ArrayList<Transaksi> getDataByKodeKunjungan(int kode) throws SQLException, ParseException {

        ArrayList<Transaksi> transaksis;
        try (Statement stmt = connection.createStatement()) {
            transaksis = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT tb_transaksi.id_transaksi AS ID, tb_transaksi.id_layanan AS ID_LAYANAN,"
                    + " tb_transaksi.id_checkin AS ID_MASUK,"
                    + " tb_transaksi.jumlah AS JUMLAH, tb_transaksi.tgl_layanan AS TANGGAL, "
                    + " tb_layanan.layanan AS NAMA, tb_layanan.biaya AS HARGA  FROM tb_transaksi"
                    + " INNER JOIN tb_layanan ON tb_transaksi.id_layanan = tb_layanan.id_layanan "
                    + " where id_checkin=" + kode)) {
                while (rs.next()) {
                    Transaksi transaksi = new Transaksi();

                    transaksi.setIdTransaksi(rs.getInt("ID"));
                    transaksi.setId_Checkin(rs.getInt("ID_MASUK"));
                    transaksi.setId_layanan(rs.getInt("ID_LAYANAN"));
                    transaksi.setNamaLayanan(rs.getString("NAMA"));
                    transaksi.setHarga(rs.getDouble("HARGA"));
                    transaksi.setJumlah(rs.getInt("JUMLAH"));
                    transaksi.setTgl_layanan(Widget.converttoDate(rs.getString("TANGGAL")));

                    transaksis.add(transaksi);
                }

                rs.close();
                stmt.close();
            }
        }

        return transaksis;
    }

    public String kodeKunjungan(int idPasien) throws SQLException {

        ArrayList<String> kodeKunjungan;

        try (Statement stmt = connection.createStatement()) {

            kodeKunjungan = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT id_checkin FROM tb_cekin where id_pasien=" + idPasien)) {
                while (rs.next()) {

                    kodeKunjungan.add(rs.getString("id_checkin"));
                }

                rs.close();
                stmt.close();
            }
        }

        if (kodeKunjungan.size() == 1) {
            return kodeKunjungan.get(0);
        } else {
            return null;
        }
    }

//    public Transaksi updateDataTransaksi(Transaksi transaksi) throws SQLException {
//
//        //       "kode_kunjungan","id_layanan","jumlah", "tgl_layanan"
//        try (Statement stmt = connection.createStatement()) {
//            String sql = "UPDATE " + Transaksi.TB_NAME + " "
//                    + "SET " + Transaksi.COLUMN_NAME[0] + " = '" + transaksi.getId_Checkin() + "',"
//                    + Transaksi.COLUMN_NAME[1] + " = " + transaksi.getId_layanan() + ","
//                    + Transaksi.
//                    + Transaksi.COLUMN_NAME[2] + " = " + transaksi.getJumlah() + ","
//                    + Transaksi.COLUMN_NAME[3] + " = " + transaksi.getTgl_layanan();
//
//            System.out.println(sql);
//            stmt.executeUpdate(sql);
//            stmt.close();
//        }
//
//        return transaksi;
//    }

    public void delDataTransaksi(int id) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + Transaksi.TB_NAME + " where id_transaksi = "
                    + id;

            stmt.execute(sql);
            stmt.close();
        }
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KasirDB;
import Model.Kunjungan;
import Tools.Widget;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author andreo
 */
public class KunjunganManager {

    Connection connection;

    public KunjunganManager(KasirDB db) {

        this.connection = db.getConnection();

    }

    public KunjunganManager() {

    }

    public Kunjungan addKunjungan(Kunjungan kunjungan) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String column = Widget.columntoinput(kunjungan.COLUMN_NAME);

            String sql = " INSERT INTO " + kunjungan.TB_NAME + "(" + column + ") "
                    + "VALUES ('" + kunjungan.getKode_kunjungan() + "','" + kunjungan.getId_pasien() + "','"
                    + kunjungan.getKeterangan() + "')";

            System.out.println(sql);

            stmt.execute(sql);
            stmt.close();

        }

        return kunjungan;
    }

    public ArrayList<Kunjungan> getAllData() throws SQLException {

        ArrayList<Kunjungan> kunjungans;

        try (Statement stmt = connection.createStatement()) {
            kunjungans = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_kunjungan;")) {
                while (rs.next()) {
                    Kunjungan kunjungan = new Kunjungan();

                    kunjungan.setId_kunjungn(rs.getInt("id_kunjungan"));
                    kunjungan.setKode_kunjungan(rs.getString("kode_kunjungan"));
                    kunjungan.setId_pasien(rs.getInt("id_pasien"));
                    kunjungan.setKeterangan(rs.getString("keterangan"));

                    kunjungans.add(kunjungan);
                }
                rs.close();
                stmt.close();
            }
            return kunjungans;
        }
    }

    public ArrayList<Kunjungan> getDataById(int id) throws SQLException {

        ArrayList<Kunjungan> kunjungans;
        try (Statement stmt = connection.createStatement()) {
            kunjungans = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_kunjungan where id_kunjungan=" + id)) {
                while (rs.next()) {
                    Kunjungan kunjungan = new Kunjungan();

                    kunjungan.setId_kunjungn(rs.getInt("id_kunjungan"));
                    kunjungan.setKode_kunjungan(rs.getString("kode_kunjungan"));
                    kunjungan.setId_pasien(rs.getInt("id_pasien"));
                    kunjungan.setKeterangan(rs.getString("keterangan"));

                    kunjungans.add(kunjungan);
                }

                rs.close();
                stmt.close();
            }
        }
        return kunjungans;
    }

    public Kunjungan updateDataKunjungan(Kunjungan kunjungan) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "UPDATE " + kunjungan.TB_NAME + " "
                    + "SET " + kunjungan.COLUMN_NAME[0] + " = '" + kunjungan.getKode_kunjungan() + "',"
                    + kunjungan.COLUMN_NAME[1] + " = " + kunjungan.getId_pasien() + ","
                    + kunjungan.COLUMN_NAME[2] + " = '" + kunjungan.getKeterangan() + "' "
                    + "WHERE id_kunjungan = " + kunjungan.getId_kunjungan() + ";";

            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        }

        return kunjungan;
    }

    public void delDataKunjungan(Kunjungan kunjungan) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + kunjungan.TB_NAME + " where id_kunjungan = "
                    + kunjungan.getId_kunjungan();

            stmt.execute(sql);
            stmt.close();
        }
    }
}

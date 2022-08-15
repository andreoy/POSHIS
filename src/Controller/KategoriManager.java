/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KasirDB;
import Model.Kategori;
import Tools.Widget;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andreo
 */
public class KategoriManager {

    Connection connection;

    public KategoriManager(KasirDB db) {

        this.connection = db.getConnection();

    }

    public Kategori addKategori(Kategori kategori) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String column = Widget.columntoinput(kategori.COLUMN_NAME);

            String sql = " INSERT INTO " + kategori.TB_NAME + "(" + column + ") "
                    + "VALUES ('" + kategori.getKategori() + "','" + kategori.getKeterangan() + "')";

            String sql_max_id = "SELECT MAX(id_kategori)  FROM " + kategori.TB_NAME;
            System.out.println(sql);
            stmt.executeUpdate(sql);

            try (ResultSet rs = stmt.executeQuery(sql_max_id)) {
                while (rs.next()) {
                    kategori.setId_kategori(rs.getInt(1));
                }
                rs.close();
            }
            stmt.close();
        }

        return kategori;
    }

    public ArrayList<Kategori> getAllData() throws SQLException {

        ArrayList<Kategori> kategoris;

        try (Statement stmt = connection.createStatement()) {
            kategoris = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_kategori;")) {
                while (rs.next()) {
                    Kategori kategori = new Kategori();

                    kategori.setId_kategori(rs.getInt("id_kategori"));
                    kategori.setKategori(rs.getString("kategori"));
                    kategori.setKeterangan(rs.getString("keterangan"));

                    kategoris.add(kategori);
                }
                rs.close();
                stmt.close();
            }
        }
        return kategoris;
    }

    public ArrayList<Kategori> getDataById(int id) throws SQLException {

        ArrayList<Kategori> kategoris;
        try (Statement stmt = connection.createStatement()) {
            kategoris = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_kategori where id_kategori =" + id + ";")) {
                while (rs.next()) {
                    Kategori kategori = new Kategori();
//                    "id_kategori","layanan", "biaya", "keterangan"
                    kategori.setId_kategori(rs.getInt("id_kategori"));
                    kategori.setKategori(rs.getString("kategori"));
                    kategori.setKeterangan(rs.getString("keterangan"));

                    kategoris.add(kategori);
                }

                rs.close();
                stmt.close();
            }
        }
        return kategoris;
    }

    public Kategori updateDataKategori(Kategori kategori) throws SQLException {

        try (Statement stmt = connection.createStatement()) {

            String sql = "UPDATE " + kategori.TB_NAME + " "
                    + " SET " + kategori.COLUMN_NAME[0] + " = '" + kategori.getKategori() + "',"
                    + kategori.COLUMN_NAME[1] + " = '" + kategori.getKeterangan() + "'"
                    + "WHERE id_kategori = " + kategori.getId_kategori() + ";";

            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        }
        return kategori;
    }

    public void delDataKategori(Kategori kategori) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + kategori.TB_NAME + " where id_kategori "
                    + "=" + kategori.getId_kategori();

            stmt.execute(sql);
            stmt.close();
        }
    }

    public DefaultTableModel setToTable() throws SQLException, ParseException {

        Object[][] rowData = new Object[this.getAllData().size()][3];
        for (int i = 0; i < this.getAllData().size(); i++) {

            rowData[i][0] = this.getAllData().get(i).getId_kategori();
            rowData[i][1] = this.getAllData().get(i).getKategori();
            rowData[i][2] = this.getAllData().get(i).getKeterangan();
        }

        Object columnNames[] = {"ID ", "Nama", "Keterangan"};
        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;
    }

    public ArrayList<Kategori> getDataKategoriById(int id) throws SQLException {

        ArrayList<Kategori> kategoris;
        try (Statement stmt = connection.createStatement()) {
            kategoris = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_kategori where id_kategori =" + id + ";")) {
                while (rs.next()) {
                    Kategori kategori = new Kategori();
                    kategori.setKategori(rs.getString("kategori"));
                    kategoris.add(kategori);
                }

                rs.close();
                stmt.close();
            }
        }
        return kategoris;
    }
}

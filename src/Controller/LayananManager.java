/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KasirDB;
import Model.Layanan;
import Model.User;
import Tools.Widget;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andreo
 */
public class LayananManager {

    Connection connection;

    public LayananManager(KasirDB db) {

        this.connection = db.getConnection();
    }

    public Layanan addLayanan(Layanan layanan) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String column = Widget.columntoinput(layanan.COLUMN_NAME);

            String sql = " INSERT INTO " + layanan.TB_NAME + "(" + column + ") "
                    + "VALUES (" + layanan.getId_kategori() + ",'" + layanan.getLayanan() + "',"
                    + layanan.getBiaya() + ",'" + layanan.getKeterangan() + "')";

            String sql_max_id = "SELECT MAX(id_layanan)  FROM " + layanan.TB_NAME;
            System.out.println(sql);

            stmt.execute(sql);

            try (ResultSet rs = stmt.executeQuery(sql_max_id)) {
                while (rs.next()) {

                    layanan.setId_layanan(rs.getInt(1));

                }
                rs.close();
//               
            }

//            stmt.execute(sql);
            stmt.close();
        }

        return layanan;
    }

    public ArrayList<Layanan> getAllData() throws SQLException {

        ArrayList<Layanan> layanans;

        try (Statement stmt = connection.createStatement()) {
            layanans = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_layanan;")) {
                while (rs.next()) {
                    Layanan layanan = new Layanan();

                    layanan.setId_layanan(rs.getInt("id_layanan"));
                    layanan.setId_kategori(rs.getInt("id_kategori"));
                    layanan.setLayanan(rs.getString("layanan"));
                    layanan.setBiaya(rs.getDouble("biaya"));
                    layanan.setKeterangan(rs.getString("keterangan"));

                    layanans.add(layanan);
                }
                rs.close();
                stmt.close();
            }
        }
        return layanans;
    }

    public ArrayList<Layanan> getDataById(int id) throws SQLException {

        ArrayList<Layanan> layanans;
        try (Statement stmt = connection.createStatement()) {
            layanans = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_layanan where id_layanan =" + id + ";")) {
                while (rs.next()) {
                    Layanan layanan = new Layanan();

                    layanan.setId_layanan(rs.getInt("id_layanan"));
                    layanan.setId_kategori(rs.getInt("id_kategori"));
                    layanan.setLayanan(rs.getString("layanan"));
                    layanan.setBiaya(rs.getDouble("biaya"));
                    layanan.setKeterangan(rs.getString("keterangan"));

                    layanans.add(layanan);
                }

                rs.close();
                stmt.close();
            }
        }
        return layanans;
    }

    public Layanan updateDataLayanan(Layanan layanan) throws SQLException {
        try (Statement stmt = connection.createStatement()) {

            String sql = "UPDATE " + layanan.TB_NAME + " "
                    + " SET " + layanan.COLUMN_NAME[0] + " = " + layanan.getId_kategori() + ","
                    + layanan.COLUMN_NAME[1] + " = '" + layanan.getLayanan() + "',"
                    + layanan.COLUMN_NAME[2] + " = " + layanan.getBiaya() + ","
                    + layanan.COLUMN_NAME[3] + " = '" + layanan.getKeterangan() + "' "
                    + "WHERE id_layanan = " + layanan.getId_layanan() + ";";

            stmt.executeUpdate(sql);
            stmt.close();
        }
        return layanan;
    }

    public void delDataLayanan(Layanan layanan) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + layanan.TB_NAME + " where id_layanan "
                    + "=" + layanan.getId_layanan();

            stmt.execute(sql);
            stmt.close();
        }
    }

    public DefaultTableModel setToTable() throws SQLException {

        Object[][] rowData = new Object[this.getAllData().size()][5];
        for (int i = 0; i < this.getAllData().size(); i++) {

            rowData[i][0] = this.getAllData().get(i).getId_layanan();
            rowData[i][1] = this.getAllData().get(i).getLayanan();
            rowData[i][2] = this.getAllData().get(i).getId_kategori();
            rowData[i][3] = this.getAllData().get(i).getBiaya();
            rowData[i][4] = this.getAllData().get(i).getKeterangan();

        }

        Object columnNames[] = {"ID ", "LAYANAN", "ID KATEGORI", "BIAYA", "KETERANGAN"};

        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;

    }

}

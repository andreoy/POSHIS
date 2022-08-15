/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KasirDB;
import Model.Ruangan;
import Tools.Widget;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andreo
 */
public class RuanganManager {

    Connection connection;

    public RuanganManager(KasirDB db) {

        this.connection = db.getConnection();

    }

    public RuanganManager() {

    }

    public Ruangan addRuangan(Ruangan ruang) throws SQLException {

        Ruangan ruangan = new Ruangan();

        try (Statement stmt = connection.createStatement()) {
            String column = Widget.columntoinput(Ruangan.COLUMN_NAME);

            String sql = " INSERT INTO " + ruang.TABLE_NAME + "(" + column + ") "
                    + "VALUES ('" + ruang.getNama_ruang() + "',0"
                    + ")";

            String sql_max_id = "SELECT MAX(id_ruangan)  FROM " + Ruangan.TABLE_NAME;
            System.out.println(sql);

            stmt.execute(sql);

            try (ResultSet rs = stmt.executeQuery(sql_max_id)) {
                while (rs.next()) {

                    ruangan.setId_ruangan(rs.getInt(1));
                    ruangan.setNama_ruang(ruang.getNama_ruang());
                    ruangan.setStatus(ruang.getStatus());

                }
                rs.close();
//                stmt.close();
            }
            stmt.close();
        }

        return ruangan;
    }

    public ArrayList<Ruangan> getAllData() throws SQLException {

        ArrayList<Ruangan> ruangans;

        try (Statement stmt = connection.createStatement()) {
            ruangans = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_ruangan;")) {
                while (rs.next()) {
                    Ruangan ruangan = new Ruangan();

                    ruangan.setId_ruangan(rs.getInt("id_ruangan"));
                    ruangan.setNama_ruang(rs.getString("nama_ruang"));
                    ruangan.setStatus(rs.getInt("status"));

                    ruangans.add(ruangan);
                }
                rs.close();
                stmt.close();
            }
            return ruangans;
        }
    }

    public ArrayList<Ruangan> getDataById(int id) throws SQLException {

        ArrayList<Ruangan> ruangans;
        try (Statement stmt = connection.createStatement()) {
            ruangans = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_ruangan where id_ruangan=" + id)) {
                while (rs.next()) {
                    Ruangan ruangan = new Ruangan();

                    ruangan.setId_ruangan(rs.getInt("id_ruangan"));
                    ruangan.setNama_ruang(rs.getString("nama_ruang"));
                    ruangan.setStatus(rs.getInt("status"));

                    ruangans.add(ruangan);
                }

                rs.close();
                stmt.close();
            }
        }
        return ruangans;
    }

    public Ruangan updateDataRuangan(Ruangan ruangan) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "UPDATE " + ruangan.TABLE_NAME + " "
                    + "SET " + ruangan.COLUMN_NAME[0] + " = '" + ruangan.getNama_ruang() + "',"
                    + ruangan.COLUMN_NAME[1] + " = '" + ruangan.getStatus() + "' "
                    + "WHERE id_ruangan = " + ruangan.getId_ruangan() + ";";

            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        }

        return ruangan;
    }

    public void delDataRuangan(Ruangan ruangan) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + ruangan.TABLE_NAME + " where id_ruangan = "
                    + ruangan.getId_ruangan();

            stmt.execute(sql);
            stmt.close();
        }
    }

    public DefaultTableModel setToTable() throws SQLException {

        Object[][] rowData = new Object[this.getAllData().size()][2];
        for (int i = 0; i < this.getAllData().size(); i++) {

            rowData[i][0] = this.getAllData().get(i).getId_ruangan();
            rowData[i][1] = this.getAllData().get(i).getNama_ruang();

        }

        Object columnNames[] = {"ID Ruang", "Nama"};

        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;
    }
}

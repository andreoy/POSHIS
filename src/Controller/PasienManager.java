/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KasirDB;
import Model.Pasien;
import Tools.Widget;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andreo
 */
public class PasienManager {

    private final Connection connection;

    public PasienManager(KasirDB db) {
        this.connection = db.getConnection();
    }

    public Pasien addDataPasien(Pasien pasien) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String column = Widget.columntoinput(pasien.COLUMN_NAME);

            System.out.println(column);

            String sql = "INSERT INTO " + pasien.TB_NAME + " (" + column + ") "
                    + "VALUES ('" + pasien.getName() + "','" + pasien.getJenkel() + "','" + pasien.getTmpt_lahir() + "',"
                    + "'" + pasien.getTgl_lahir() + "','" + pasien.getAlamat() + "');";

            String sql_max_id = "SELECT MAX(id_pasien)  FROM " + pasien.TB_NAME;
            System.out.println(sql);
            stmt.executeUpdate(sql);

            try (ResultSet rs = stmt.executeQuery(sql_max_id)) {
                while (rs.next()) {
                    pasien.setId_pasien(rs.getInt(1));
                }
                rs.close();
            }
            stmt.close();
        }
        return pasien;

    }

    public ArrayList<Pasien> getAllData() throws SQLException, ParseException {

        ArrayList<Pasien> pasiens;
        try (Statement stmt = connection.createStatement()) {
            pasiens = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_pasien;")) {
                while (rs.next()) {
                    Pasien pasien = new Pasien();
                    // "id_pasien","name","tgl_lahir"
                    pasien.setId_pasien(rs.getInt("id_pasien"));
                    pasien.setName(rs.getString("name"));
                    pasien.setJenkel(rs.getString("jenkel"));
                    pasien.setTmpt_lahir(rs.getString("tmpt_lahir"));
                    pasien.setTgl_lahir(Widget.converttoDate(rs.getString("tgl_lahir")));
//                    pasien.setTgl_lahir(rs.getDate("tgl_lahir"));
                    pasien.setAlamat(rs.getString("alamat"));
                    pasiens.add(pasien);
                }
                rs.close();
                stmt.close();
            }
        }
        return pasiens;
    }

    public ArrayList<Pasien> getDataById(int id) throws SQLException, ParseException {

        ArrayList<Pasien> pasiens;
        try (Statement stmt = connection.createStatement()) {
            pasiens = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_pasien where id_pasien =" + id + ";")) {
                while (rs.next()) {
                    Pasien pasien = new Pasien();
                    pasien.setId_pasien(rs.getInt("id_pasien"));
                    pasien.setName(rs.getString("name"));
                    pasien.setJenkel(rs.getString("jenkel"));
                    pasien.setTmpt_lahir(rs.getString("tmpt_lahir"));
                    pasien.setTgl_lahir(Widget.converttoDate(rs.getString("tgl_lahir")));
                    pasien.setAlamat(rs.getString("alamat"));
                    pasiens.add(pasien);
                }
                rs.close();
                stmt.close();
            }

        }
        return pasiens;
    }

    public Pasien upDataPasien(Pasien pasien) throws SQLException {

        try (Statement stmt = connection.createStatement()) {

            String sql = "UPDATE " + pasien.TB_NAME + " "
                    + " SET " + pasien.COLUMN_NAME[0] + " = '" + pasien.getName() + "',"
                    + pasien.COLUMN_NAME[1] + " = '" + pasien.getJenkel() + "',"
                    + pasien.COLUMN_NAME[2] + " = '" + pasien.getTmpt_lahir() + "',"
                    + pasien.COLUMN_NAME[3] + " = '" + pasien.getTgl_lahir() + "', "
                    + pasien.COLUMN_NAME[4] + " = '" + pasien.getAlamat() + "' "
                    + "WHERE id_pasien = " + pasien.getId_pasien() + ";";

            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
        }
        return pasien;
    }

    public void delDataPasien(Pasien pasien) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + pasien.TB_NAME + " where id_pasien "
                    + "=" + pasien.getId_pasien();

            stmt.execute(sql);

            stmt.close();
        }
    }

    public DefaultTableModel setToTable() throws SQLException, ParseException {

        Object[][] rowData = new Object[this.getAllData().size()][6];
        for (int i = 0; i < this.getAllData().size(); i++) {

            rowData[i][0] = this.getAllData().get(i).getId_pasien();
            rowData[i][1] = this.getAllData().get(i).getName();
            rowData[i][2] = this.getAllData().get(i).getTmpt_lahir();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            rowData[i][3] = formatter.format(this.getAllData().get(i).getTgl_lahir());
            rowData[i][4] = this.getAllData().get(i).getJenkel();
            rowData[i][5] = this.getAllData().get(i).getAlamat();
        }

        Object columnNames[] = {"ID ", "Nama", "Tempat", "Tanggal", "JenKel", "Alamat"};

        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;
    }
}

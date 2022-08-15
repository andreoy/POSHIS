/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.InfoCheckIn;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andreo
 */
public class CheckInManager {

    Connection connection;

    public CheckInManager(KasirDB db) {

        this.connection = db.getConnection();

    }

    public InfoCheckIn addCheckIn(InfoCheckIn checkIn) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String column = Widget.columntoinput(InfoCheckIn.COLUMN_NAME);

            String sql = " INSERT INTO " + InfoCheckIn.TB_NAME + "(" + column + ") "
                    + "VALUES ('" + checkIn.getId_Pasien() + "'," + checkIn.getId_ruangan() + ",'"
                    + checkIn.getTgl_masuk() + "')";

            String sql_max_id = "SELECT MAX (id_checkin) FROM " + InfoCheckIn.TB_NAME;

            System.out.println(sql);

            stmt.execute(sql);

            try (ResultSet rs = stmt.executeQuery(sql_max_id)) {
                while (rs.next()) {

                    checkIn.setId_checkIn(rs.getInt(1));

                }
                rs.close();
            }
            stmt.close();
        }

        return checkIn;
    }

    
    
    public ArrayList<InfoCheckIn> getAllData() throws SQLException, ParseException {

        ArrayList<InfoCheckIn> infocheckins;
        try (Statement stmt = connection.createStatement()) {
            infocheckins = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT tb_cekin.id_checkIn AS ID,tb_cekin.id_pasien AS ID_PASIEN, tb_cekin.id_ruangan AS ID_RUANG, tb_pasien.name AS NAMA,tb_ruangan.nama_ruang AS RUANG,tb_cekin.tgl_masuk AS TANGGAL FROM tb_cekin "
                    + " INNER JOIN tb_pasien ON tb_cekin.id_pasien = tb_pasien.id_pasien"
                    + " INNER JOIN tb_ruangan ON tb_cekin.id_ruangan = tb_ruangan.id_ruangan where 1=1")) {

                while (rs.next()) {
                    InfoCheckIn checkin = new InfoCheckIn();

                    checkin.setId_checkIn(rs.getInt("ID"));
                    checkin.setId_Pasien(rs.getInt("ID_PASIEN"));
                    checkin.setId_ruangan(rs.getInt("ID_RUANG"));
                    checkin.setNama(rs.getString("NAMA"));
                    checkin.setRuang(rs.getString("RUANG"));
                    checkin.setTgl_masuk(Widget.converttoDate(rs.getString("TANGGAL")));

                    infocheckins.add(checkin);
                }

                rs.close();
                stmt.close();
            }
        }
        return infocheckins;
    }
    
     public ArrayList<InfoCheckIn> getAllDataByIdPasienWithoutStatus(int id) throws SQLException, ParseException {

        ArrayList<InfoCheckIn> infocheckins;
        try (Statement stmt = connection.createStatement()) {
            infocheckins = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT tb_cekin.id_checkIn AS ID,tb_cekin.id_pasien AS ID_PASIEN,"
                    + " tb_cekin.id_ruangan AS ID_RUANG, tb_pasien.name AS NAMA,tb_ruangan.nama_ruang AS RUANG,"
                    + "tb_cekin.tgl_masuk AS TANGGAL "
//                    + ",tb_cekout.tgl_keluar AS TGL_KELUAR"
                    + " FROM tb_cekin "
                    + " INNER JOIN tb_pasien ON tb_cekin.id_pasien = tb_pasien.id_pasien"
//                    + " INNER JOIN tb_cekout ON tb_cekin.id_checkIn = tb_cekout.id_checkIn"
                    + " INNER JOIN tb_ruangan ON tb_cekin.id_ruangan = tb_ruangan.id_ruangan where tb_cekin.id_pasien="+id)) {

                while (rs.next()) {
                    InfoCheckIn checkin = new InfoCheckIn();

                    checkin.setId_checkIn(rs.getInt("ID"));
                    checkin.setId_Pasien(rs.getInt("ID_PASIEN"));
                    checkin.setId_ruangan(rs.getInt("ID_RUANG"));
                    checkin.setNama(rs.getString("NAMA"));
                    checkin.setRuang(rs.getString("RUANG"));
                    checkin.setTgl_masuk(Widget.converttoDate(rs.getString("TANGGAL")));
//                    checkin.setTgl_keluar(Widget.converttoDate(rs.getString("TGL_KELUAR")));

                    infocheckins.add(checkin);
                }

                rs.close();
                stmt.close();
            }
        }
        return infocheckins;
    }

    public ArrayList<InfoCheckIn> getDataById(int id) throws SQLException {

        ArrayList<InfoCheckIn> infocheckins;
        try (Statement stmt = connection.createStatement()) {
            infocheckins = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT tb_cekin.id_checkIn AS ID,tb_cekin.id_pasien AS ID_PASIEN, tb_cekin.id_ruangan AS ID_RUANG, tb_pasien.name AS NAMA,tb_ruangan.nama_ruang AS RUANG,tb_cekin.tgl_masuk AS TANGGAL FROM tb_cekin "
                    + " INNER JOIN tb_pasien ON tb_cekin.id_pasien = tb_pasien.id_pasien"
                    + " INNER JOIN tb_ruangan ON tb_cekin.id_ruangan = tb_ruangan.id_ruangan where tb_cekin.id_checkIn=" + id)) {

                while (rs.next()) {
                    InfoCheckIn checkin = new InfoCheckIn();

//                    checkin.setId_checkIn(rs.getInt("id_checkIn"));
                    checkin.setId_Pasien(rs.getInt("ID_PASIEN"));
                    checkin.setId_ruangan(rs.getInt("ID_RUANG"));
//                    checkin.setTgl_masuk(rs.getDate("tgl_masuk"));

                    checkin.setId_checkIn(rs.getInt("ID"));
                    checkin.setNama(rs.getString("NAMA"));
                    checkin.setRuang(rs.getString("RUANG"));
                    checkin.setTgl_masuk(Widget.converttoDate(rs.getString("TANGGAL")));

                    infocheckins.add(checkin);
                }

                rs.close();
                stmt.close();
            } catch (ParseException ex) {
                Logger.getLogger(CheckInManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return infocheckins;
    }

    public ArrayList<InfoCheckIn> getDataByIdPasien(int id) throws SQLException, ParseException {

        ArrayList<InfoCheckIn> infocheckins;
        try (Statement stmt = connection.createStatement()) {
            infocheckins = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT tb_cekin.id_checkIn AS ID,tb_cekin.id_pasien AS ID_PASIEN,"
                    + " tb_cekin.id_ruangan AS ID_RUANG, tb_pasien.name AS NAMA,tb_ruangan.nama_ruang AS RUANG,"
                    + " tb_cekin.tgl_masuk AS TANGGAL"
                    + " FROM tb_cekin "
                    + " INNER JOIN tb_pasien ON tb_cekin.id_pasien = tb_pasien.id_pasien"
                    + " INNER JOIN tb_ruangan ON tb_cekin.id_ruangan = tb_ruangan.id_ruangan"
                    + " where tb_cekin.id_pasien = "+id)) {

                while (rs.next()) {
                    InfoCheckIn checkin = new InfoCheckIn();

                    checkin.setId_Pasien(rs.getInt("ID_PASIEN"));
                    checkin.setId_ruangan(rs.getInt("ID_RUANG"));

                    checkin.setId_checkIn(rs.getInt("ID"));
                    checkin.setNama(rs.getString("NAMA"));
                    checkin.setRuang(rs.getString("RUANG"));
                    checkin.setTgl_masuk(Widget.converttoDate(rs.getString("TANGGAL")));

                    infocheckins.add(checkin);
                }

                rs.close();
                stmt.close();
            }
        }
//        System.out.println(infocheckins.get(0).getId_Pasien());
        return infocheckins;
    }

    public InfoCheckIn updateDataCheckIn(InfoCheckIn checkin) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "UPDATE " + InfoCheckIn.TB_NAME + " "
                    + "SET " + InfoCheckIn.COLUMN_NAME[0] + " = '" + checkin.getId_Pasien() + "',"
                    + InfoCheckIn.COLUMN_NAME[1] + " = " + checkin.getId_ruangan() + ","
                    + InfoCheckIn.COLUMN_NAME[2] + " = '" + checkin.getTgl_masuk() + "' "
                    + "WHERE id_checkin = " + checkin.getId_checkIn() + ";";

            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        }

        return checkin;
    }

    public void delDataCheckIn(InfoCheckIn checkin) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + InfoCheckIn.TB_NAME + " where id_checkin = "
                    + checkin.getId_checkIn();

            stmt.execute(sql);
            stmt.close();
        }
    }

    public DefaultTableModel setToTable() throws SQLException, ParseException {

        Object[][] rowData = new Object[this.getAllData().size()][4];
        for (int i = 0; i < this.getAllData().size(); i++) {

            rowData[i][0] = this.getAllData().get(i).getId_checkIn();
            rowData[i][1] = this.getAllData().get(i).getNama();
            rowData[i][2] = this.getAllData().get(i).getRuang();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            rowData[i][3] = formatter.format(this.getAllData().get(i).getTgl_masuk());

        }

        Object columnNames[] = {"ID ", "Nama", "Ruang", "Tgl Masuk"};

        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;
    }
}

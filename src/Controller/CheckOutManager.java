/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.InfoCheckOut;
import Model.KasirDB;
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
public class CheckOutManager {

    Connection connection;

    public CheckOutManager(KasirDB db) {

        this.connection = db.getConnection();

    }

    public InfoCheckOut addCheckOut(InfoCheckOut checkOut) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String column = Widget.columntoinput(InfoCheckOut.COLUMN_NAME);

            String sql = " INSERT INTO " + InfoCheckOut.TB_NAME + "(" + column + ") "
                    + "VALUES (" + checkOut.getId_checkIn() + ",'" + checkOut.getTgl_keluar() + "')";

            String sql_max_id = "SELECT MAX(id_checkOut)  FROM " + InfoCheckOut.TB_NAME;

            System.out.println(sql);

            stmt.execute(sql);
            try (ResultSet rs = stmt.executeQuery(sql_max_id)) {
                while (rs.next()) {

                    checkOut.setId_checkOut(rs.getInt(1));

                }
                rs.close();
            }
            stmt.close();
        }

        return checkOut;
    }

    public ArrayList<InfoCheckOut> getAllData() throws SQLException, ParseException {

        ArrayList<InfoCheckOut> infocheckouts;
        try (Statement stmt = connection.createStatement()) {
            infocheckouts = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_cekout where 1=1")) {
                while (rs.next()) {
                    InfoCheckOut checkout = new InfoCheckOut();

                    checkout.setId_checkOut(rs.getInt("id_checkout"));
                    checkout.setId_checkIn(rs.getInt("id_checkIn"));
                    checkout.setTgl_keluar(Widget.converttoDate(rs.getString("tgl_keluar")));

                    infocheckouts.add(checkout);
                }
                rs.close();
            }

        }

        return infocheckouts;
    }

    public ArrayList<InfoCheckOut> getDataById(int id) throws SQLException, ParseException {

        ArrayList<InfoCheckOut> infocheckouts;
        try (Statement stmt = connection.createStatement()) {
            infocheckouts = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_cekout where id_checkout=" + id)) {
                while (rs.next()) {
                    InfoCheckOut checkout = new InfoCheckOut();

                    checkout.setId_checkOut(rs.getInt("id_checkout"));
                    checkout.setId_checkIn(rs.getInt("id_checkIn"));
                    checkout.setTgl_keluar(Widget.converttoDate(rs.getString("tgl_keluar")));

                    infocheckouts.add(checkout);
                }
                rs.close();
            }
        }

        return infocheckouts;
    }
    
    public ArrayList<InfoCheckOut> getDataByIdCheckIn(int id) throws SQLException, ParseException {

        ArrayList<InfoCheckOut> infocheckouts;
        try (Statement stmt = connection.createStatement()) {
            infocheckouts = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_cekout where id_checkin=" + id)) {
               
                while (rs.next()) {
                    InfoCheckOut checkout = new InfoCheckOut();

                    checkout.setId_checkOut(rs.getInt("id_checkout"));
                    checkout.setId_checkIn(rs.getInt("id_checkIn"));
                    checkout.setTgl_keluar(Widget.converttoDate(rs.getString("tgl_keluar")));

                    infocheckouts.add(checkout);
                }
                
                rs.close();
            }
        }
        
        if(infocheckouts.isEmpty()) return null;
        else return infocheckouts;
    }

    public InfoCheckOut updateDataCheckOut(InfoCheckOut checkout) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "UPDATE " + InfoCheckOut.TB_NAME + " "
                    + "SET " 
                    + InfoCheckOut.COLUMN_NAME[1] + " = '" + checkout.getTgl_keluar() + "' "
                    + "WHERE id_checkOut = " + checkout.getId_checkOut() + ";";

            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        }

        return checkout;

    }

    public void delDataCheckOut(int id) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + InfoCheckOut.TB_NAME + " where id_checkout = "
                    + id;

            stmt.execute(sql);
            stmt.close();
        }
    }

    public DefaultTableModel setToTable() throws SQLException, ParseException {

        Object[][] rowData = new Object[this.getAllData().size()][3];
        for (int i = 0; i < this.getAllData().size(); i++) {

            rowData[i][0] = this.getAllData().get(i).getId_checkOut();
            rowData[i][1] = this.getAllData().get(i).getId_checkIn();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            rowData[i][2] = formatter.format(this.getAllData().get(i).getTgl_keluar());

        }

        Object columnNames[] = {"ID ", "KODE KUNJUNGAN", "TANGGAL KELUAR"};

        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;
    }

}

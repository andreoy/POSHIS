/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KasirDB;
import Model.Pembayaran;
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
public class PembayaranManager {

    Connection connection;

    public PembayaranManager(KasirDB db) {

        this.connection = db.getConnection();

    }

    public Pembayaran addPembayaran(Pembayaran pembayaran) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String column = Widget.columntoinput(Pembayaran.COLUMN_NAME);

            String sql = " INSERT INTO " + Pembayaran.TB_NAME + "(" + column + ") "
                    + "VALUES (" + pembayaran.getId_Checkin() + "," + pembayaran.getStatus() + ","
                    + pembayaran.getJumlah() + ",'" +pembayaran.getTanggal()+"',"+pembayaran.getId_user()+","+pembayaran.getId_sesi()+")";

            System.out.println(sql);

            stmt.execute(sql);
            stmt.close();
        }
        return pembayaran;
    }

    public ArrayList<Pembayaran> getAllData(int id_checkin) throws SQLException, ParseException {

        ArrayList<Pembayaran> pembayarans;
        try (Statement stmt = connection.createStatement()) {
            pembayarans = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_pembayaran where 1=1")) {
                while (rs.next()) {
                    Pembayaran pembayaran = new Pembayaran();
                    pembayaran.setId_sesi(rs.getInt("id_sesi"));
                            
                    pembayaran.setId_pembayaran(rs.getInt("id_status_bayar"));
                    pembayaran.setId_Checkin(rs.getInt("id_checkin"));
                    pembayaran.setStatus(rs.getInt("status"));
                    pembayaran.setJumlah(rs.getInt("jumlah"));
                    pembayaran.setTanggal(Widget.converttoDate(rs.getString("tanggal")));

                    pembayarans.add(pembayaran);
                }
            }
        }

        return pembayarans;
    }

    public ArrayList<Pembayaran> getDataByIdCheckIn(int id) throws SQLException, ParseException {

        ArrayList<Pembayaran> pembayarans;
        try (Statement stmt = connection.createStatement()) {
            pembayarans = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_pembayaran where id_checkin=" + id+" ORDER BY id_status_bayar DESC")) {
                while (rs.next()) {
                    Pembayaran pembayaran = new Pembayaran();

                    pembayaran.setId_sesi(rs.getInt("id_sesi"));
                    pembayaran.setId_pembayaran(rs.getInt("id_status_bayar"));
                    pembayaran.setId_Checkin(rs.getInt("id_checkin"));
                    pembayaran.setStatus(rs.getInt("status"));
                    pembayaran.setJumlah(rs.getInt("jumlah"));
                    pembayaran.setTanggal(Widget.converttoDate(rs.getString("tanggal")));
                    
                    pembayarans.add(pembayaran);
                }
            }
        }

        return pembayarans;
    }
    
    public double getPembayaran(int id) throws SQLException, ParseException{
        
        ArrayList<Pembayaran> pembayaran = this.getDataByIdCheckIn(id);
        
        double total_bayar=0;
        
        for (int i = 0; i < pembayaran.size();i++){
            total_bayar = total_bayar+pembayaran.get(i).getJumlah();
        }
        
        return total_bayar;
    }
    
     public double getJumlahBySesi(int id_sesi) throws SQLException, ParseException{
        
        double jumlah =-1;
        try (Statement stmt = connection.createStatement()) {
            
            try (ResultSet rs = stmt.executeQuery("Select Sum(jumlah) as jumlah from tb_pembayaran where id_sesi="+id_sesi)) {
                while (rs.next()) {
                    jumlah= rs.getDouble("jumlah");
                } 
            }
        }
        return jumlah;
    }


    public Pembayaran updatePembayaran(Pembayaran pembayaran) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "UPDATE " + Pembayaran.TB_NAME + " "
                    + "SET " + Pembayaran.COLUMN_NAME[0] + " = '" + pembayaran.getId_Checkin() + "',"
                    + Pembayaran.COLUMN_NAME[1] + " = '" + pembayaran.getStatus() + "',"
                    + Pembayaran.COLUMN_NAME[2] + " = " + pembayaran.getJumlah() + ", "
                    + Pembayaran.COLUMN_NAME[3] + " = " + pembayaran.getId_user()+ ","
                    + Pembayaran.COLUMN_NAME[4] + " = " + pembayaran.getId_sesi()+ " "
                    + "WHERE id_status_bayar = " + pembayaran.getId_pembayaran() + ";";

            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        }

        return pembayaran;

    }

    public void delDataPembayaran(Pembayaran pembayaran) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql;
            sql = "DELETE from " + Pembayaran.TB_NAME + " where id_status_bayar = "
                    + pembayaran.getId_pembayaran();

            stmt.execute(sql);
            stmt.close();
        }
    }
    
     public DefaultTableModel setToTable(ArrayList<Pembayaran>pembayarans) throws SQLException, ParseException {

        Object[][] rowData = new Object[pembayarans.size()][4];
        for (int i = 0; i < pembayarans.size(); i++) {

            rowData[i][0] = pembayarans.get(i).getId_pembayaran();
            rowData[i][1] = pembayarans.get(i).getJumlah();
            rowData[i][2] = pembayarans.get(i).getStatus();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            rowData[i][3] = formatter.format(pembayarans.get(i).getTanggal());
          
        }

        Object columnNames[] = {"ID ", "JUMLAH","STATUS","TANGGAL"};

        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;
    }

}

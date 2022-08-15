/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KasirDB;
import Model.Sessi;
import Tools.Widget;
import java.sql.Connection;
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
public class SesiManager {
    
    private final Connection connection;
    
    public SesiManager(KasirDB db){
        this.connection = db.getConnection();
    }
    
    public Sessi addSessi(Sessi sesi) throws SQLException{
        try(Statement stmt = connection.createStatement()){
            String column = Widget.columntoinput(sesi.COLUMN_NAME);
            
            String sql = "INSERT INTO "+sesi.TB_NAME+" ("+column+")"
                    + "VALUES ("+sesi.getId_kasir()+",(Select strftime('%Y-%m-%d %H:%M:%S','now')),"
                    +sesi.getSaldo_awal()+",1,'0000-00-00 00:00:00',"+sesi.getSaldo_akhir()+");";
            
            String sql_max_id = "SELECT MAX(id_sesi) FROM "+sesi.TB_NAME;
            stmt.executeUpdate(sql);
            
            try(ResultSet rs = stmt.executeQuery(sql_max_id)){
                while (rs.next()){
                    sesi.setId_sesi(rs.getInt(1));
                }
                rs.close();
            }
            stmt.close();
        }
        System.out.println(sesi.getTime_open_sesi());
        System.out.println(sesi.getTime_close_sesi());
        return sesi;
    }
    
    public ArrayList<Sessi> getAllData() throws SQLException, ParseException  {
        ArrayList<Sessi> sessis;
        try (Statement stmt = connection.createStatement()) {
            sessis = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_sesi;")) {
                while (rs.next()) {
                    Sessi sesi = new Sessi();
                    sesi.setId_sesi(rs.getInt("id_sesi"));
                    sesi.setId_kasir(rs.getInt("id_kasir"));
                    sesi.setTime_open_sesi(rs.getString("time_open_sesi"));
                    sesi.setSaldo_awal(rs.getDouble("saldo_awal"));
                    sesi.setStatus(rs.getInt("status"));
                    sesi.setTime_close_sesi(rs.getString("time_close_sesi"));
                    sesi.setSaldo_akhir(rs.getDouble("saldo_akhir"));
                        
                    sessis.add(sesi);
                }
                rs.close();
                stmt.close();
            }
        }
        return sessis;
    } 
    
    public ArrayList<Sessi> getDataById(int id) throws SQLException, ParseException{

        ArrayList<Sessi> sessis;
        try (Statement stmt = connection.createStatement()) {
            sessis = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_sesi where id_sesi =" + id + ";")) {
                while (rs.next()) {
                   Sessi sesi = new Sessi();
                    sesi.setId_sesi(rs.getInt("id_sesi"));
                    sesi.setId_kasir(rs.getInt("id_kasir"));
                    sesi.setTime_open_sesi(rs.getString("time_open_sesi"));
                    sesi.setSaldo_awal(rs.getDouble("saldo_awal"));
                    sesi.setStatus(rs.getInt("status"));
                    sesi.setTime_close_sesi(rs.getString("time_close_sesi"));
                    sesi.setSaldo_akhir(rs.getDouble("saldo_akhir"));
                        
                    sessis.add(sesi);
                }
                rs.close();
                stmt.close();
            }
        }
        return sessis;
    }
    
    public Sessi updateDataSesi(Sessi sesi) throws SQLException{
        try (Statement stmt = connection.createStatement()) {
//id_kasir","time_open_sesi","saldo_awal","status","time_close_sesi","saldo_akhir
            String sql = "UPDATE " + sesi.TB_NAME + " "
                    + " SET " + sesi.COLUMN_NAME[0] + " = '" + sesi.getId_kasir() + "',"
                    + sesi.COLUMN_NAME[1] + " = '" + sesi.getTime_open_sesi() + "',"
                    + sesi.COLUMN_NAME[2] + " = " + sesi.getSaldo_awal() + ","
                    + sesi.COLUMN_NAME[3] + " = " + sesi.getRealStatus() + ","
                    + sesi.COLUMN_NAME[4] + " = (Select strftime('%Y-%m-%d %H:%M:%S','now')), "
                    + sesi.COLUMN_NAME[5] + " = " + sesi.getSaldo_akhir()+" "
                    + "WHERE id_sesi = " + sesi.getId_sesi() + ";";

            stmt.executeUpdate(sql);

            stmt.close();
        }
        System.out.println(sesi.getTime_open_sesi());
        System.out.println(sesi.getTime_close_sesi());
        return sesi;
    }
    
    public void delDataKasir(Sessi sesi) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + sesi.TB_NAME + " where id_sesi "
                    + "=" + sesi.getId_sesi();

            stmt.execute(sql);

            stmt.close();
        }
    }
    
    public DefaultTableModel setToTable() throws SQLException, ParseException {

        Object[][] rowData = new Object[this.getAllData().size()][7];
        for (int i = 0; i < this.getAllData().size(); i++) {

            rowData[i][0] = this.getAllData().get(i).getId_sesi();
            rowData[i][1] = this.getAllData().get(i).getId_kasir();
            rowData[i][2] = this.getAllData().get(i).getStatus();
            rowData[i][3] = this.getAllData().get(i).getTime_open_sesi();
            rowData[i][4] = this.getAllData().get(i).getSaldo_awal();
            rowData[i][5] = this.getAllData().get(i).getTime_close_sesi();
            rowData[i][6] = this.getAllData().get(i).getSaldo_akhir();
        }

        Object columnNames[] = {"ID ", "ID KASIR", "STATUS", "BUKA", "SALDO", "TUTUP", "SALDO"};

        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;
    }    
    
    public ArrayList<Sessi> getDataByIdKasir(int id) throws SQLException, ParseException{

        ArrayList<Sessi> sessis;
        try (Statement stmt = connection.createStatement()) {
            sessis = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_sesi where id_kasir =" + id + " ORDER BY id_sesi DESC;")) {
                while (rs.next()) {
                    Sessi sesi = new Sessi();
                    sesi.setId_sesi(rs.getInt("id_sesi"));
                    sesi.setId_kasir(rs.getInt("id_kasir"));
                    sesi.setTime_open_sesi(rs.getString("time_open_sesi"));
                    sesi.setSaldo_awal(rs.getDouble("saldo_awal"));
                    sesi.setStatus(rs.getInt("status"));
                    sesi.setTime_close_sesi(rs.getString("time_close_sesi"));
                    sesi.setSaldo_akhir(rs.getDouble("saldo_akhir"));
                        
                    sessis.add(sesi);
                }
                rs.close();
                stmt.close();
            }
        }
        return sessis;
    }
    
    public Sessi getStatus(int id) throws SQLException, ParseException{

        ArrayList<Sessi> sessis;
        try (Statement stmt = connection.createStatement()) {
            sessis = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_sesi where id_kasir =" + id + " ORDER BY id_sesi DESC Limit 1;")) {
                while (rs.next()) {
                   Sessi sesi = new Sessi();
                    sesi.setId_sesi(rs.getInt("id_sesi"));
                    sesi.setId_kasir(rs.getInt("id_kasir"));                    
                    sesi.setTime_open_sesi(rs.getString("time_open_sesi"));
                    sesi.setSaldo_awal(rs.getDouble("saldo_awal"));
                    sesi.setStatus(rs.getInt("status"));
                    sesi.setTime_close_sesi(rs.getString("time_close_sesi"));
                    sesi.setSaldo_akhir(rs.getDouble("saldo_akhir"));
                        
                    sessis.add(sesi);
                }
                rs.close();
                stmt.close();
            }
        }
        if(sessis.isEmpty()){
            Sessi sesiKosong=new Sessi();
            sesiKosong.setStatus(0);
            sessis.add(sesiKosong);
            return sessis.get(0);
        }
        else
        return sessis.get(0);
    }
}

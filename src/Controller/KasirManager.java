/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Kasir;
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
public class KasirManager {
   
    private final Connection connection; 
    
    public KasirManager(KasirDB db){
        this.connection = db.getConnection();
    }
    
    public Kasir addKasir(Kasir kasir) throws SQLException{
        try(Statement stmt = connection.createStatement()){
            String column = Widget.columntoinput(kasir.COLUMN_NAME);
            
            String sql = "INSERT INTO "+kasir.TB_NAME+" ("+column+")"
                    + "VALUES ('"+kasir.getKasir()+"');";
            
            String sql_max_id = "SELECT MAX(id_kasir) FROM "+kasir.TB_NAME;
            stmt.executeUpdate(sql);
            
            try(ResultSet rs = stmt.executeQuery(sql_max_id)){
                while (rs.next()){
                    kasir.setId_kasir(rs.getInt(1));
                }
                rs.close();
            }
            stmt.close();
        }
        return kasir;
    }
    
    public ArrayList<Kasir> getAllData() throws SQLException  {
        ArrayList<Kasir> kasirs;
        try (Statement stmt = connection.createStatement()) {
            kasirs = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_kasir;")) {
                while (rs.next()) {
                    Kasir kasir = new Kasir();
                    kasir.setId_kasir(rs.getInt("id_kasir"));
                    kasir.setKasir(rs.getString("kasir"));
                    kasirs.add(kasir);
                }
                rs.close();
                stmt.close();
            }
        }
        return kasirs;
    }
    
    public ArrayList<Kasir> getDataById(int id) throws SQLException{

        ArrayList<Kasir> kasirs;
        try (Statement stmt = connection.createStatement()) {
            kasirs = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_kasir where id_kasir =" + id + ";")) {
                while (rs.next()) {
                    Kasir kasir = new Kasir();
                    kasir.setId_kasir(rs.getInt("id_kasir"));
                    kasir.setKasir(rs.getString("kasir"));
                    kasirs.add(kasir);
                }
                rs.close();
                stmt.close();
            }
        }
        return kasirs;
    }
    
    public Kasir updateDataKasir(Kasir kasir) throws SQLException{
        try (Statement stmt = connection.createStatement()) {

            String sql = "UPDATE " + kasir.TB_NAME + " "
                    + " SET " + kasir.COLUMN_NAME[0] + " = '" + kasir.getKasir() + "' "
                    + "WHERE id_kasir = " + kasir.getId_kasir() + ";";

            stmt.executeUpdate(sql);

            stmt.close();
        }
        return kasir;
    }
    
    public void delDataKasir(Kasir kasir) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + kasir.TB_NAME + " where id_kasir "
                    + "=" + kasir.getId_kasir();

            stmt.execute(sql);

            stmt.close();
        }
    }
    
    public DefaultTableModel setToTable() throws SQLException, ParseException {

        Object[][] rowData = new Object[this.getAllData().size()][6];
        for (int i = 0; i < this.getAllData().size(); i++) {

            rowData[i][0] = this.getAllData().get(i).getId_kasir();
            rowData[i][1] = this.getAllData().get(i).getKasir();

        }

        Object columnNames[] = {"ID ", "KASIR"};

        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KasirDB;
import Model.Login;
import Tools.Widget;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andreo
 */
public class LoginManager {
    
    private final Connection connection;
    
    public LoginManager(KasirDB db){
        this.connection = db.getConnection();
    }
    
    public Login addLogin(Login login) throws SQLException{
        
        try (Statement stmt = connection.createStatement()) {
            String column = Widget.columntoinput(login.COLUMN_NAME);

            String sql = " INSERT INTO " + login.TABLE_NAME + "(" + column + ") "
                    + "VALUES ('" + login.getId_operator() + "',(Select strftime('%Y-%m-%d %H:%M:%S','now')))";

            String sql_max_id = "SELECT MAX(id_login)  FROM " + login.TABLE_NAME;
            System.out.println(sql);

            stmt.execute(sql);

            try (ResultSet rs = stmt.executeQuery(sql_max_id)) {
                while (rs.next()) {

                    login.setId_login(rs.getInt(1));

                }
                rs.close();
//                stmt.close();
            }

            stmt.close();
        }

        return login;
       
    }
    
    public Login updateLogin(Login login) throws SQLException{
        try (Statement stmt = connection.createStatement()) {

            String sql = "UPDATE " + login.TABLE_NAME + " "
                    + " SET "
//                    + login.COLUMN_NAME[0] + " = " + login.getId_operator() + ","
//                    + login.COLUMN_NAME[1] + " = '" + login.getWaktu_login() + "',"
                    + "time_disaktif" + " = (SELECT strftime('%Y-%m-%d %H:%M:%S', 'now') )"
                    + " WHERE id_login = " + login.getId_login()+ ";";

            stmt.executeUpdate(sql);
            stmt.close();
        }
        return login;
    }
    
    
    
}

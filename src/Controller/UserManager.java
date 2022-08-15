/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KasirDB;
import Model.User;
import Model.User.type;
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
public class UserManager {

    private final Connection connection;

    public UserManager(KasirDB db) {
        this.connection = db.getConnection();
    }

    public User addUser(User user) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            String column = Widget.columntoinput(user.COLUMN_NAME);

//            "username","status","password"
            String sql = " INSERT INTO " + user.TABLE_NAME + "(" + column + ") "
                    + "VALUES ('" + user.getName() + "','" + user.getTempat() + "','" + user.getTgl_lahir() + "',"
                    + "" + user.getKelamin() + ",'" + user.getAlamat() + "','" + user.getTelp() + "',"
                    + "'" + user.getUsername() + "','" + user.getStatus() + "','"
                    + user.getPassword() + "')";

            String sql_max_id = "SELECT MAX(id_user)  FROM " + User.TABLE_NAME;
            System.out.println(sql);

            stmt.execute(sql);

            try (ResultSet rs = stmt.executeQuery(sql_max_id)) {
                while (rs.next()) {

                    user.setId_user(rs.getInt(1));

                }
                rs.close();
//                stmt.close();
            }

            stmt.close();
        }

        return user;
    }

    public ArrayList<User> getAllData() throws SQLException, ParseException {

        ArrayList<User> users;

        try (Statement stmt = connection.createStatement()) {
            users = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_user;")) {
                while (rs.next()) {
                    User user = new User();

                    user.setId_user(rs.getInt("id_user"));
                    user.setName(rs.getString("name"));
                    user.setTempat(rs.getString("tempat"));

                    user.setTgl_lahir(Widget.converttoDate(rs.getString("tgl_lahir")));
//                    user.setTgl_lahir(rs.getString("tgl_lahir"));
                    user.setKelamin(rs.getInt("kelamin"));
                    user.setAlamat(rs.getString("alamat"));
                    user.setTelp(rs.getString("telp"));
                    user.setUsername(rs.getString("username"));
                    user.setStatus(type.valueOf(rs.getString("status")));
                    user.setPassword(rs.getString("password"));

                    users.add(user);
                }
                rs.close();
                stmt.close();
            }
        }
        return users;
    }

    public ArrayList<User> getDataByUserName(String name) throws SQLException, ParseException {

        ArrayList<User> users;
        try (Statement stmt = connection.createStatement()) {
            users = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_user where username ='" + name + "';")) {
                while (rs.next()) {
                    User user = new User();

                    user.setId_user(rs.getInt("id_user"));
                    user.setName(rs.getString("name"));
                    user.setTempat(rs.getString("tempat"));
                    user.setTgl_lahir(Widget.converttoDate(rs.getString("tgl_lahir")));
                    user.setKelamin(rs.getInt("kelamin"));
                    user.setAlamat(rs.getString("alamat"));
                    user.setTelp(rs.getString("telp"));
                    user.setUsername(rs.getString("username"));
                    user.setStatus(type.valueOf(rs.getString("status")));
                    user.setPassword(rs.getString("password"));

                    users.add(user);
                }

                rs.close();
                stmt.close();
            }
        }
        return users;
    }

    public ArrayList<User> getDataById(int id) throws SQLException, ParseException {

        ArrayList<User> users;
        try (Statement stmt = connection.createStatement()) {
            users = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM tb_user where id_user =" + id + ";")) {
                while (rs.next()) {
                    User user = new User();

                    user.setId_user(rs.getInt("id_user"));
                    user.setName(rs.getString("name"));
                    user.setTempat(rs.getString("tempat"));
                    user.setTgl_lahir(Widget.converttoDate(rs.getString("tgl_lahir")));
                    user.setKelamin(rs.getInt("kelamin"));
                    user.setAlamat(rs.getString("alamat"));
                    user.setTelp(rs.getString("telp"));
                    user.setUsername(rs.getString("username"));
                    user.setStatus(type.valueOf(rs.getString("status")));
                    user.setPassword(rs.getString("password"));

                    users.add(user);
                }

                rs.close();
                stmt.close();
            }
        }
        return users;
    }

    public User updateDataUser(User user) throws SQLException {
        try (Statement stmt = connection.createStatement()) {

            String sql = "UPDATE " + User.TABLE_NAME + " "
                    + " SET "
                    + User.COLUMN_NAME[0] + " = '" + user.getName() + "',"
                    + User.COLUMN_NAME[1] + " = '" + user.getTempat() + "',"
                    + User.COLUMN_NAME[2] + " = '" + user.getTgl_lahir() + "',"
                    + User.COLUMN_NAME[3] + " = '" + user.getKelamin() + "',"
                    + User.COLUMN_NAME[4] + " = '" + user.getAlamat() + "',"
                    + User.COLUMN_NAME[5] + " = '" + user.getTelp() + "',"
                    + User.COLUMN_NAME[6] + " = '" + user.getUsername() + "',"
                    + User.COLUMN_NAME[7] + " = '" + user.getStatus() + "',"
                    + User.COLUMN_NAME[8] + " = '" + user.getPassword() + "'"
                    + " WHERE id_user = " + user.getId_user() + ";";

            stmt.executeUpdate(sql);
            stmt.close();
        }
        return user;
    }

    public void delDataUser(User user) throws SQLException {

        try (Statement stmt = connection.createStatement()) {
            String sql = "DELETE from " + User.TABLE_NAME + " where id_user "
                    + "=" + user.getId_user();

            stmt.execute(sql);
            stmt.close();
        }
    }

    public DefaultTableModel setToTable() throws SQLException, ParseException {

        Object[][] rowData = new Object[this.getAllData().size()][10];
        for (int i = 0; i < this.getAllData().size(); i++) {

            rowData[i][0] = this.getAllData().get(i).getId_user();
            rowData[i][1] = this.getAllData().get(i).getName();
            rowData[i][2] = this.getAllData().get(i).getTempat();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            rowData[i][3] = formatter.format(this.getAllData().get(i).getTgl_lahir());
//            rowData[i][3] = this.getAllData().get(i).getTgl_lahir();
            rowData[i][4] = Widget.convertGender(this.getAllData().get(i).getKelamin());
            rowData[i][5] = this.getAllData().get(i).getAlamat();
            rowData[i][6] = this.getAllData().get(i).getTelp();
            rowData[i][7] = this.getAllData().get(i).getUsername();
            rowData[i][8] = this.getAllData().get(i).getStatus();
            rowData[i][9] = this.getAllData().get(i).getStatus();
        }

        Object columnNames[] = {"ID ", "Nama", "Tempat", "Tanggal", "JenKel", "Alamat", "Telp", "Username", "Status", "Password"};

        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;
    }
}

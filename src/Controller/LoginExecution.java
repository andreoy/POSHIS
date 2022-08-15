/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.KasirDB;
import Model.Login;
import Model.User;



import app.form.adminobat.FormAdmin;
import app.form.kasir.FormKasir;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author andreo
 */
public class LoginExecution {

    private final String username;
    private final String password;


    public LoginExecution(String username, String password) throws SQLException {

        this.username = username;
        this.password = password;
        

    }

    public void doLogin(JFrame frame) throws SQLException, ParseException {

        final KasirDB kasirdb = new KasirDB();
        

        UserManager um = new UserManager(kasirdb);
        LoginManager lm = new LoginManager(kasirdb);


        if (um.getDataByUserName(username).size() > 0) {

            User user = um.getDataByUserName(username).get(0);

            if (password.equals(user.getPassword())) {
                
                final Login login = new Login();
                login.setId_operator(user.getId_user());
                
                Calendar calender = Calendar.getInstance();
                    
                Date date = new Date();
                
                login.setWaktu_login(date);
                
                final Login login_berhasil=lm.addLogin(login);
                

                switch (user.getStatus()) {
                    case Administrator:

                        java.awt.EventQueue.invokeLater(new Runnable() {

                            @Override
                            public void run() {
                                try {
                                    new FormAdmin(kasirdb, login_berhasil).setVisible(true);
                                } catch (SQLException | ParseException ex) {
                                    Logger.getLogger(LoginExecution.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });

                        frame.dispose();

                        break;

                    case Kasir:
                        
                        java.awt.EventQueue.invokeLater(new Runnable() {

                            @Override
                            public void run() {
                                try {
                                    new FormKasir(kasirdb, login_berhasil).setVisible(true);
                                } catch (SQLException | ParseException ex) {
                                    Logger.getLogger(LoginExecution.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });

                        frame.dispose();

                        break;

                }
                
//                return login;
            } else {
                JOptionPane.showMessageDialog(null, "Password yang anda Masukkan salah");
                
//                return null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username tidak ditemukan");
            
//            return null;
        }

    }

}

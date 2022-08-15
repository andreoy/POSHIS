/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rscasier;

import Controller.CheckInManager;
import Controller.CheckOutManager;
import Controller.KategoriManager;
import Controller.KunjunganManager;
import Controller.LayananManager;
import Controller.PasienManager;
import Controller.RuanganManager;
import Controller.TransaksiManager;
import Controller.UserManager;
import Model.InfoCheckIn;
import Model.InfoCheckOut;
import Model.KasirDB;
import Model.Kategori;
import Model.Kunjungan;
import Model.Layanan;
import Model.Pasien;

import Model.Ruangan;
import Model.Transaksi;
import Model.User;
import Tools.Widget;
import app.form.FormLogin;
import app.form.adminkamar.checkinForm;
import app.form.adminobat.FormAdmin;
import app.form.kasir.FormKasir;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andreo
 */
public class RSCasier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        try {
        // TODO code application logic here

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new FormLogin().setVisible(true);
                FormLogin frame = new FormLogin();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });

//                
//            Date date = new Date();
//            date.getTime();
//            
//            final KasirDB kasirdb= new KasirDB();
//            
//            Pasien pasien = new Pasien();
//            pasien.setName("Andreo");
//            pasien.setAlamat("Sungai Penuh");
//            pasien.setId_pasien(1);
//            pasien.setTmpt_lahir("Sungai Penuh");
//            pasien.setTgl_lahir(Widget.convertJavaDateToSqlDate(date));
//            
//            PasienManager  pm = new PasienManager(kasirdb);
//            
//            pm.addDataPasien(pasien);
//            
//            Ruangan ruangan = new Ruangan();
//            ruangan.setId_ruangan(1);
//            ruangan.setNama_ruang("Melati 2");
//            ruangan.setStatus(0);
//            
//            RuanganManager rm = new RuanganManager(kasirdb);
//            rm.addRuangan(ruangan);
//            
//            System.out.println(rm.getAllData().get(0));
//            Kategori kategori = new Kategori();
//            kategori.setKategori("Obat");
//            kategori.setId_kategori(1);
//            kategori.setKeterangan("obat berbahaya");
//            
//            KategoriManager km = new KategoriManager(kasirdb);
//            km.addKategori(kategori);
//            
//            Layanan layanan = new Layanan();
//            layanan.setId_kategori(1);
//            layanan.setBiaya(20000);
//            layanan.setLayanan("Suntik mati");
//            layanan.setKeterangan("untuk hukuman mati");
//            
//            Layanan layanan2 = new Layanan();
//            layanan2.setId_kategori(1);
//            layanan2.setBiaya(20000);
//            layanan2.setLayanan("Suntik pingsan");
//            layanan2.setKeterangan("untuk bius");
//            
//            LayananManager lm = new LayananManager(kasirdb);
//            lm.addLayanan(layanan);
//            lm.addLayanan(layanan2);
//            
////        
//                java.awt.EventQueue.invokeLater(new Runnable() {
//
//                    public void run() {
//                       
////                             new FormAdmin(kasirdb).setVisible(true);
//                         FormKasir form= new FormKasir(kasirdb);
//                         form.setVisible(true);
//                         form.setMaximized(true);
//                           
//                            
//                      
//                    }
//                });
//            
//            Layanan layanan = new Layanan(10, "Suntik", 34000, "Injeksi");
//            Layanan layanan2 = new Layanan(13, "Obat", 43000, "Minum obat"); 
//            
//            LayananManager lm = new LayananManager(kasirdb);
//            
//            lm.addLayanan(layanan);
//            lm.addLayanan(layanan2);
//            
//            Transaksi transaksi = new Transaksi("ds123", 1, 23, Widget.convertJavaDateToSqlDate(date));
//            Transaksi transaksi2 = new Transaksi("ds123", 3, 23, Widget.convertJavaDateToSqlDate(date));
//            
//            ArrayList<Transaksi> transaksis= new ArrayList();
//            
//            transaksis.add(transaksi);
//            transaksis.add(transaksi2);
//            
//            TransaksiManager tm = new TransaksiManager(kasirdb);
//            
//            tm.addTransaksi(transaksis);
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(RSCasier.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}

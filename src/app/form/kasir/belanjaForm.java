/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.form.kasir;

import Controller.CheckInManager;
import Controller.LayananManager;
import Controller.PembayaranManager;
import Controller.TransaksiManager;
import Model.InfoCheckIn;
import Model.KasirDB;
import Model.Layanan;
import Model.Pembayaran;
import Model.Transaksi;
import Model.User;
import Tools.Widget;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author root
 */
public class belanjaForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form belanjaForm
     */
    KasirDB db;


    CheckInManager cim;
    TransaksiManager tm;
    LayananManager lm;
    PembayaranManager pm;
    
    
    DefaultTableModel model;
    
    DefaultTableModel model_pilihan;
    
    final TableRowSorter<TableModel> sorter;

    ArrayList<Transaksi> transaksis;
    InfoCheckIn cekin;

    double total;
    
    SimpleDateFormat formatter;
    
    DecimalFormat myFormatter;
    
    User user;

    public belanjaForm(KasirDB db, User user) throws SQLException {

        this.db = db;
        this.user = user;
        
        tm = new TransaksiManager(db);
        lm = new LayananManager(db);
        pm = new PembayaranManager(db);
        cim = new CheckInManager(db);
        
        model = this.setToTable();

        transaksis = new ArrayList<>();
        total = 0;
         model_pilihan = lm.setToTable();
        initComponents();
        
        Calendar calender = Calendar.getInstance();
        txt_tgl.setDate(calender.getTime());
        
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        myFormatter = new DecimalFormat("###.###");
        
        sorter = new TableRowSorter<TableModel>(model_pilihan);
         jTable1.setRowSorter(sorter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
      * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Temp = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btn_hapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id_pasien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nama_produk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_tgl_masuk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nama_ruang = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_id_produk = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nama_pasien = new javax.swing.JTextField();
        txt_harga_produk = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btn_id_pasien = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btn_id_product = new javax.swing.JButton();
        txt_tgl = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        txt_total_harga_item = new javax.swing.JTextField();
        notifikasi = new javax.swing.JLabel();
        btn_batal1 = new javax.swing.JButton();

        jTable1.setModel(model_pilihan);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_searchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txt_search)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setClosable(true);
        setTitle("Data Pemakaian Layanan");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_Temp.setModel(model);
        jScrollPane1.setViewportView(table_Temp);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 640, 340));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("Total Pembayaran = Rp");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, 28));

        txt_total.setEditable(false);
        txt_total.setBackground(new java.awt.Color(0, 0, 0));
        txt_total.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_total.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 250, 28));

        btn_hapus.setText("Hapus");
        btn_hapus.setEnabled(false);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel2.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 170, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID Pasien");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(txt_id_pasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 200, -1));

        jLabel2.setText("Nama Pasien");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txt_nama_produk.setEditable(false);
        jPanel1.add(txt_nama_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 270, -1));

        jLabel3.setText("Tanggal Masuk");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txt_tgl_masuk.setEditable(false);
        jPanel1.add(txt_tgl_masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 270, -1));

        jLabel4.setText("No. Ruangan");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txt_nama_ruang.setEditable(false);
        jPanel1.add(txt_nama_ruang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 270, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 390, 10));

        jLabel5.setText("ID Produk");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Jumlah");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel7.setText("Harga");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        txt_id_produk.setEditable(false);
        txt_id_produk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_id_produkKeyPressed(evt);
            }
        });
        jPanel1.add(txt_id_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 200, -1));

        jLabel8.setText("Nama Produk");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_nama_pasien.setEditable(false);
        jPanel1.add(txt_nama_pasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 270, -1));

        txt_harga_produk.setEditable(false);
        jPanel1.add(txt_harga_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 210, 232, -1));

        jLabel9.setText("Rp.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("Total");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, 28));

        txt_jumlah.setEditable(false);
        txt_jumlah.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyReleased(evt);
            }
        });
        jPanel1.add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 270, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Rp.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, 28));

        btn_id_pasien.setText("Cari");
        btn_id_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_id_pasienActionPerformed(evt);
            }
        });
        jPanel1.add(btn_id_pasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 10, -1, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 390, 10));

        btn_id_product.setText("Cari");
        btn_id_product.setEnabled(false);
        btn_id_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_id_productActionPerformed(evt);
            }
        });
        jPanel1.add(btn_id_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 140, -1, 20));
        jPanel1.add(txt_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 270, -1));

        jLabel12.setText("Tanggal / Waktu");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        btn_tambah.setText("Tambah");
        btn_tambah.setEnabled(false);
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 90, -1));

        txt_total_harga_item.setEditable(false);
        txt_total_harga_item.setBackground(new java.awt.Color(0, 0, 0));
        txt_total_harga_item.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_total_harga_item.setForeground(new java.awt.Color(255, 0, 0));
        txt_total_harga_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_harga_itemActionPerformed(evt);
            }
        });
        jPanel1.add(txt_total_harga_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 230, 28));

        notifikasi.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(notifikasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 390, 20));

        btn_batal1.setText("Batal");
        btn_batal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_batal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
        double jumlah, harga;
        jumlah = Double.parseDouble(txt_jumlah.getText());
        harga = Double.parseDouble(txt_harga_produk.getText());

        double total_harga_item = jumlah * harga;
        
        txt_total_harga_item.setText(myFormatter.format(total_harga_item));
    }//GEN-LAST:event_txt_jumlahKeyReleased

    private void btn_id_pasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_id_pasienActionPerformed
        try {
            ArrayList<InfoCheckIn> cekins=cim.getDataByIdPasien(Integer.parseInt(txt_id_pasien.getText()));
            ArrayList<Pembayaran> pembayaran;
              
            if(cekins.size()==1){
                cekin = cekins.get(0);
                pembayaran = pm.getDataByIdCheckIn(cekin.getId_checkIn());
                if(pembayaran.get(0).getStatus()==0){
                    ArrayList<Transaksi> transaksi_show = tm.getDataByKodeKunjungan(cekin.getId_checkIn());
                    if(model.getRowCount()==0) this.setTableData(transaksi_show);
                    txt_nama_pasien.setText(cekin.getNama());
                    txt_tgl_masuk.setText(cekin.getTgl_masuk().toString());
                    txt_nama_ruang.setText(cekin.getRuang());
                         enableTextfield();
                }else{
                    JOptionPane.showMessageDialog(null, "Tidak bisa input layanan \nKarena Telah lunas dibayar");
                }
            }
            else if(cekins.size()<=0){
                JOptionPane.showMessageDialog(null,"Tidak ada Data Kunjungan");
            }
            else if(cekins.size()>=2){
                ArrayList<InfoCheckIn> checkin_belum_bayar;
                checkin_belum_bayar = new ArrayList<>();
                for (int i=0; i<cekins.size();i++){
                    pembayaran = pm.getDataByIdCheckIn(cekins.get(i).getId_checkIn());
                    
                    if(pembayaran.get(0).getStatus()==0){
                        checkin_belum_bayar.add(cekins.get(i));
                    }
                }
                if(checkin_belum_bayar.size()==1){
                    cekin=checkin_belum_bayar.get(0);
                    ArrayList<Transaksi> transaksi_show = tm.getDataByKodeKunjungan(cekin.getId_checkIn());
                    if(model.getRowCount()==0) this.setTableData(transaksi_show);
                    txt_nama_pasien.setText(cekin.getNama());
                    txt_tgl_masuk.setText(cekin.getTgl_masuk().toString());
                    txt_nama_ruang.setText(cekin.getRuang());
                         enableTextfield();
                }
                else if(checkin_belum_bayar.size()<=0){
                    JOptionPane.showMessageDialog(null, "Tidak ada kunjungan");
                }
                else if(checkin_belum_bayar.size()>=2){
                    JOptionPane.showMessageDialog(null, "Ada lebih dari 1 kunjungan belum lunas");
                }

            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(belanjaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_id_pasienActionPerformed

    private void btn_id_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_id_productActionPerformed
        findByID();
    }//GEN-LAST:event_btn_id_productActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String nama_pasien = txt_nama_pasien.getText();
        String nama_produk = txt_nama_produk.getText();
        String jumlah_produk = txt_jumlah.getText();

        if (nama_pasien.equals("")) {
            notifikasi.setText("Nama Pasien Tidak Boleh kosong");
        } else if (nama_produk.equals("")) {
            notifikasi.setText("Produk Tidak Boleh kosong");
        } else if (jumlah_produk.equals("")) {
            notifikasi.setText("Jumlah Produk Tidak Boleh kosong");
        } else {
            try {
                Transaksi transaksi = new Transaksi();
                transaksi.setId_Checkin(cekin.getId_checkIn());
                transaksi.setId_layanan(Integer.parseInt(txt_id_produk.getText()));
                transaksi.setJumlah(Integer.parseInt(txt_jumlah.getText()));
                transaksi.setTgl_layanan(Widget.convertJavaDateToSqlDate(txt_tgl.getDate()));
                transaksi.setId_user(user.getId_user());
                
               
                Transaksi transaksi_baru_basuk =tm.addTransaksi(transaksi);
                
                transaksis.add(transaksi);
                
                double harga = Double.parseDouble(txt_harga_produk.getText());
                int jumlah = Integer.parseInt(txt_jumlah.getText());
                
//                "KODE ", "LAYANAN","HARGA" ,"JUMLAH", "TOTAL", "TANGGAL"
                model.addRow(new Object[]{transaksi_baru_basuk.getIdtransaksi(),
                       txt_nama_produk.getText(), harga, jumlah, (jumlah * harga),formatter.format(txt_tgl.getDate())});
                
                total = total + (harga * jumlah);
                 txt_total.setText(myFormatter.format(total));
               
            } catch (SQLException ex) {
                Logger.getLogger(belanjaForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void txt_total_harga_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_harga_itemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_harga_itemActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
            int row = table_Temp.getSelectedRow();
            
            Object object_id = model.getValueAt(row, 0);
            Object object_total = model.getValueAt(row, 4);
            tm.delDataTransaksi(Integer.parseInt(object_id.toString()));
            model.removeRow(row);
            total = total - Double.parseDouble(object_total.toString());
            txt_total.setText(myFormatter.format(total));
        } catch (NumberFormatException | SQLException ex) {
            Logger.getLogger(belanjaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal1ActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_batal1ActionPerformed

    private void txt_id_produkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_produkKeyPressed
       
        System.out.println("fd"+evt.getKeyCode());
        switch (evt.getKeyCode()){
            case 112:
                JOptionPane.showConfirmDialog(null, jPanel3, "Daftar Layanan", JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE);                
                break;
                
            case 10:
                findByID();
                break;
        }
    }//GEN-LAST:event_txt_id_produkKeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == 10) {
       
            int row =jTable1.getSelectedRow();
            Object object = jTable1.getValueAt(row, 0);
            txt_id_produk.setText(object.toString());
    
            JOptionPane.getRootFrame().dispose();
       }
    }//GEN-LAST:event_jTable1KeyPressed

    private void txt_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyTyped
        if (txt_search.getText().length() == 0) {
            
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(txt_search.getText()));
        }
    }//GEN-LAST:event_txt_searchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal1;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_id_pasien;
    private javax.swing.JButton btn_id_product;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel notifikasi;
    private javax.swing.JTable table_Temp;
    private javax.swing.JTextField txt_harga_produk;
    private javax.swing.JTextField txt_id_pasien;
    private javax.swing.JTextField txt_id_produk;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_nama_pasien;
    private javax.swing.JTextField txt_nama_produk;
    private javax.swing.JTextField txt_nama_ruang;
    private javax.swing.JTextField txt_search;
    private com.toedter.calendar.JDateChooser txt_tgl;
    private javax.swing.JTextField txt_tgl_masuk;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_harga_item;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel setToTable() {

        Object[][] rowData = new Object[0][5];

        Object columnNames[] = {"KODE ", "LAYANAN","HARGA" ,"JUMLAH", "TOTAL", "TANGGAL"};

        DefaultTableModel jtable = new DefaultTableModel(rowData, columnNames);

        return jtable;
    }

     private void setTableData(ArrayList<Transaksi> transaksis) {

        double total_bayar = 0;

        
        for (int i = 0; i < transaksis.size(); i++) {
             
         
            
            model.addRow(new Object[]{
                transaksis.get(i).getIdtransaksi(),
                transaksis.get(i).getNamaLayanan(),
                transaksis.get(i).getHarga(),
                transaksis.get(i).getJumlah(),
                transaksis.get(i).getHarga() * transaksis.get(i).getJumlah(),
                formatter.format(transaksis.get(i).getTgl_layanan())
            });

            total_bayar = total_bayar + (transaksis.get(i).getHarga() * transaksis.get(i).getJumlah());    

        }
        total = total_bayar;
        txt_total.setText(myFormatter.format(total));
    }
     
    public void enableTextfield() {
        if (txt_nama_pasien.getText().length() != 0) {
            txt_id_produk.setEditable(true);
            btn_id_product.setEnabled(true);
            txt_jumlah.setEditable(true);
            btn_tambah.setEnabled(true);
            btn_hapus.setEnabled(true);
        }
    }

    private void clearForm() {
        txt_id_pasien.setText("");
        txt_nama_pasien.setText("");
        txt_tgl_masuk.setText("");
        txt_nama_ruang.setText("");
        txt_id_produk.setText("");
        txt_nama_produk.setText("");
        txt_harga_produk.setText("");
        txt_jumlah.setText("");
        txt_total_harga_item.setText("");
        txt_tgl.setDateFormatString("");
        txt_jumlah.setEditable(false);
        txt_id_produk.setEditable(false);
        btn_tambah.setEnabled(false);
        btn_id_product.setEnabled(false);
        btn_hapus.setEnabled(false);
    }

    private void clearFormProduk() {
        txt_nama_ruang.setText("");
        txt_id_produk.setText("");
        txt_nama_produk.setText("");
        txt_harga_produk.setText("");
        txt_jumlah.setText("");
        txt_total_harga_item.setText("");
    }
    
    private void findByID(){
         String nama_produk = txt_id_produk.getText();
        Layanan layanan;
        if (nama_produk.equals("")) {
            notifikasi.setText("ID Produk Masih Kosong");
        } else {
            try {
                if (lm.getDataById(Integer.parseInt(txt_id_produk.getText())).size() == 1) {
                    layanan = lm.getDataById(Integer.parseInt(txt_id_produk.getText())).get(0);
                    txt_nama_produk.setText(layanan.getLayanan());
                    txt_harga_produk.setText(layanan.getBiaya() + "");
                    notifikasi.setText("");
                } else if (lm.getDataById(Integer.parseInt(txt_id_produk.getText())).size() != 1) {
                    notifikasi.setText("Data Produk Tidak Ditemukan");
                    clearFormProduk();
                }
            } catch (SQLException ex) {
                Logger.getLogger(belanjaForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author andreo
 */
import Model.KasirDB;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

    public static void makeKwitansi(String filename, int vid_cekin,String dari, String banyak, String pembayaran, String jumlah, KasirDB kasirdb) {
        String reportSource;
        String reportDest;

        reportSource = "report/"
                + "jrxml/" + filename + ".jrxml";
        reportDest = "report/"
                + "html/" + filename + ".html";

        Map<String, Object> params = new HashMap<>();

        params.put("id_cekin", vid_cekin);
        params.put("diterima_dari", dari);
        params.put("text_jumlah_uang", banyak);
        params.put("text_untuk_pembayaran", pembayaran);
        params.put("total_bayar", jumlah);

        try {
            JasperReport jasperReport
                    = JasperCompileManager.compileReport(reportSource);

            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(
                            jasperReport, params, kasirdb.getConnection());

            JasperExportManager.exportReportToHtmlFile(
                    jasperPrint, reportDest);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
        }
    }

    public static void makeRekening(String filename,int id_cekin,double jumlah_bayar ,KasirDB kasirdb) {
        String reportSource;
        String reportDest;

        reportSource = "report/"
                + "jrxml/" + filename + ".jrxml";
        reportDest = "report/"
                + "html/" + filename + ".html";

        Map<String, Object> params = new HashMap<>();

        params.put("id_cekin", id_cekin);
        params.put("angsuran_telah_bayar", jumlah_bayar);
    

        try {
            JasperReport jasperReport
                    = JasperCompileManager.compileReport(reportSource);

            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(
                            jasperReport, params, kasirdb.getConnection());

            JasperExportManager.exportReportToHtmlFile(
                    jasperPrint, reportDest);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
        }
    }
    
    public static void makeLapLog(String filename,Date dari,Date sampai ,KasirDB kasirdb) {
        String reportSource;
        String reportDest;

        reportSource = "report/"
                + "jrxml/" + filename + ".jrxml";
        reportDest = "report/"
                + "html/" + filename + ".html";

        Map<String, Object> params = new HashMap<>();

        System.out.println(dari);
        System.out.println(sampai);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        params.put("date_bawah",formatter.format(dari));
        params.put("date_atas", formatter.format(sampai));
    

        try {
            JasperReport jasperReport
                    = JasperCompileManager.compileReport(reportSource);

            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(
                            jasperReport, params, kasirdb.getConnection());

            JasperExportManager.exportReportToHtmlFile(
                    jasperPrint, reportDest);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
        }
    }
    
    public static void makeLapKasir(String filename,Date dari,Date sampai ,KasirDB kasirdb) {
        String reportSource;
        String reportDest;

        reportSource = "report/"
                + "jrxml/" + filename + ".jrxml";
        reportDest = "report/"
                + "html/" + filename + ".html";

        Map<String, Object> params = new HashMap<>();

        System.out.println(dari);
        System.out.println(sampai);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        params.put("buka",formatter.format(dari));
        params.put("tutup", formatter.format(sampai));
    

        try {
            JasperReport jasperReport
                    = JasperCompileManager.compileReport(reportSource);

            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(
                            jasperReport, params, kasirdb.getConnection());

            JasperExportManager.exportReportToHtmlFile(
                    jasperPrint, reportDest);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
        }
    }
    
    public static void makeReport(String filename,KasirDB kasirdb) {
        String reportSource;
        String reportDest;

        reportSource = "report/"
                + "jrxml/" + filename + ".jrxml";
        reportDest = "report/"
                + "html/" + filename + ".html";

        Map<String, Object> params = new HashMap<>();


        try {
            JasperReport jasperReport
                    = JasperCompileManager.compileReport(reportSource);

            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(
                            jasperReport, params, kasirdb.getConnection());

            JasperExportManager.exportReportToHtmlFile(
                    jasperPrint, reportDest);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author andreo
 */
public class Widget {

    public static String columntoinput(String[] column_name) {

        String column = "";

        for (int i = 0; i < column_name.length; i++) {

            column = column + column_name[i];

            if (i != column_name.length - 1) {
                column = column + ",";
            }

        }
        return column;
    }

    public static java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {

        return new java.sql.Date(date.getTime());
    }
//    
//    public static java.sql.Time convertJavaDateToSqlTime(java.util.Date date) {
//
//        return new java.sql.Time(date.getTime());
//    }

    public static java.util.Date converttoDate(String string) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        DateFormat df = new SimpleDateFormat("MMM d, yyyy");
        java.util.Date date;
        date = df.parse(string);
        return date;
    }


    public static String convertGender(int kel) {
        if (kel == 0) {
            return "Laki-laki";
        } else {
            return "Perempuan";
        }
    }
    
    public static Date convertToTimeDate(String originalString) throws ParseException{
        
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(originalString);
        
        return date;
    }
}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Model;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
///**
// *
// * @author andreo
// */
//public abstract class DataEntitas {
//    
//    abstract String[] getField();
//    abstract String getTableName();
////    
//    public ArrayList getDataEntry(){
//     
//        ArrayList dataEntry = new ArrayList();
//       
//        
//        switch (""+this.getClass()){
//            case "class Model.User":
//                
//                User user = new User();
//                
//                dataEntry.add(user.getId_user());
//                dataEntry.add(user.getUsername());
//                dataEntry.add(user.getStatus());
//                dataEntry.add(user.getPassword());
//                
//                
//                return dataEntry;
////                
////            case TRANSAKSI:
////            case RUANGAN:
//            case "class Model.Pasien":
//                
//                Pasien pasien = new Pasien();
//                
//                dataEntry.add(pasien.getId_pasien());
//                dataEntry.add(pasien.getName());
//                dataEntry.add(pasien.getTgl_lahir());
//                
//                return dataEntry;
////            case LAYANAN:
////            case KUNJUNGAN:
////            case KATEGORI:
////            case INFOCHECKOUT:
////            case INFOCHECKIN:
//            default:
//                System.out.println(""+this.getClass());
//                return null;
//                        
//                
//        }
//        
//    }
//    
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.form.kasir;

import app.form.superuser.*;


/**
 *
 * @author andreo
 */
class Item  {

    private final int id;
    private final String description;
  
   

    public Item(int id_kasir, String kategori) {
         this.id = id_kasir;
            this.description = kategori;
    }
        public int getId()
        {
            return id;
        }
  
        public String getDescription()
        {
            return description;
        }
  
    @Override
        public String toString()
        {
            return description;
        }
    
}

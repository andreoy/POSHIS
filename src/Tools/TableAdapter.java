/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author andreo
 */
public class TableAdapter extends JTable {

    public TableAdapter(ArrayList dataList, String[] column) {

        super(dataList.size(), column.length);

    }

}

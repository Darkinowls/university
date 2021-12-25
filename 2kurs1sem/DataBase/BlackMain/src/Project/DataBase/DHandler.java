package Project.DataBase;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DHandler extends DConnector {

    public ResultSet getTable(String table) {
        String select = "select * from mydb." + table + " ;";
        return executeQuery(select);
    }

    public void deleteRowFromWhere(String table, String where, String value) {
        String select = "delete From mydb." + table + " Where " + where + " = " + value + " ;";
        execute(select);
    }

    public void editData(String table, String state) {
        String select = "Update mydb." + table + " set " + state + " ;";
        execute(select);
    }

    public void insertData(String table, String state) {
        String select = "Insert into mydb." + table + " values (" + state + ") ;";
        execute(select);
    }


    public ResultSet selectFromWhere(String name, String table, String where, String value) {
        String select = "select " + name + " From mydb." + table + " where " + where + " = " + value + " ;";
        return executeQuery(select);
    }


    public boolean execute(String select) {

        System.out.println(select + "\n");

        try {
            PreparedStatement prSt;
            prSt = getDConnection().prepareStatement(select);
            prSt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error in executing MySQL Command. Problem with data",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public ResultSet executeQuery(String select) {

        System.out.println(select + "\n");

        try {

            PreparedStatement prSt;
            prSt = getDConnection().prepareStatement(select);
            return prSt.executeQuery();

        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error in executing MySQL Query. Problem with data",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }


    }
}

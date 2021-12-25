package Project.Controllers;

import Project.Controllers.TableControllers.Tables.Worker;
import Project.DataBase.DHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;


import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerMenu {

    @FXML
    protected Tab TabWorkers;

    @FXML
    protected Tab TabCert;

    @FXML
    protected Tab TabTask;

    @FXML
    protected Tab TabDic;


    @FXML
    void initialize() throws IOException {



        FXMLLoader loader = new FXMLLoader();
        AnchorPane pane = loader.load(getClass().getResource("/Project/FXMLs/Tabs/TabWorkers.fxml"));
        TabWorkers.setContent(pane);

        loader = new FXMLLoader();
        pane = loader.load(getClass().getResource("/Project/FXMLs/Tabs/TabCert.fxml"));
        TabCert.setContent(pane);

        loader = new FXMLLoader();
        pane = loader.load(getClass().getResource("/Project/FXMLs/Tabs/TabTask.fxml"));
        TabTask.setContent(pane);

        loader = new FXMLLoader();
        pane = loader.load(getClass().getResource("/Project/FXMLs/Tabs/TabDic.fxml"));
        TabDic.setContent(pane);

    }


    public static ResultSet setHeadTableAndGetTable(String s, TableColumn temp[]) throws SQLException {
        ResultSet rs = new DHandler().getTable(s);
        for (int i = 1; i <= temp.length; i++) {
            temp[i - 1].setCellValueFactory(new PropertyValueFactory<>(rs.getMetaData().getColumnName(i)));
        }
        return rs;
    }


    public static void errorDelete(){
        JOptionPane.showMessageDialog(null,
                "Select row to delete",
                "Error",  JOptionPane.ERROR_MESSAGE );
    }
    public static void errorFill() {
        JOptionPane.showMessageDialog(null,
                "Fill the Buffer below the table",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void errorInit() {
        JOptionPane.showMessageDialog(null,
                "Error in initializing",
                "Error",  JOptionPane.ERROR_MESSAGE );
    }

    public static void errorId(TextField FieldId) throws Exception {
        if ( "".equals(FieldId.getText()) || FieldId.getText() == null || 0 > Integer.parseInt(FieldId.getText())) {
            JOptionPane.showMessageDialog(null,
                    "Id should not less 0 ",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Id should not less 0  ");
        }
    }

}

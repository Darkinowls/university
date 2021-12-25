
package Project.Controllers.TableControllers;

import Project.Controllers.ControllerMenu;
import Project.Controllers.TableControllers.Tables.*;
import Project.DataBase.DHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Project.Controllers.ControllerMenu.*;


public class ControllerWorkers {

    @FXML
    private AnchorPane Pane;
    @FXML
    private TableView<Worker> TableWorkers;
    @FXML
    private TableColumn<Worker, Integer> Id_PWorker;
    @FXML
    private TableColumn<Worker, String> Full_Name;
    @FXML
    private TableColumn<Worker, String> Post;
    @FXML
    private TableColumn<Worker, Integer> Spent;
    @FXML
    private TableColumn<Worker, Integer> Id_Cert;
    @FXML
    private TextField FieldId;
    @FXML
    private TextField FieldName;
    @FXML
    private TextField FieldPost;
    @FXML
    private TextField FieldSpent;
    @FXML
    private TextField FieldCert;
    @FXML
    private TextField FieldFillter;
    @FXML
    private Button ButtonDelete;
    @FXML
    private Button ButtonNew;
    @FXML
    private Button ButtonReflesh;
    @FXML
    private Button ButtonCalc;
    @FXML
    private ComboBox<String> ComboBox;
    private ObservableList<Worker> List = FXCollections.observableArrayList();

    @FXML
    void initialize() throws Exception {

        TableColumn t[] = new TableColumn[]{Id_PWorker, Full_Name, Post, Spent, Id_Cert};
        initTable("Worker", t , List);

        checkMouse();

        checkButtons();

        checkFilter();




    }

    private void checkFilter(){

        ComboBox.getItems().add("Worker Id");
        ComboBox.getItems().add("Full Name");
        ComboBox.getItems().add("Post");
        ComboBox.getItems().add("Spent");
        ComboBox.getItems().add("Cert Id");
        ComboBox.getItems().add("All");

        ComboBox.getSelectionModel().select("All");

        FilteredList<Worker> filteredData = new FilteredList<>(List, p -> true);

        FieldFillter.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(Worker->{
                if (newValue == null || newValue.isEmpty()  ) {
                    return true;
                }

                String lowerValue = newValue.toLowerCase();


                if (Worker.getFull_Name().toLowerCase().contains(lowerValue)
                && (ComboBox.getSelectionModel().getSelectedItem().equals("Full Name")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))) {
                    return true;
                }else if ( String.valueOf(Worker.getSpent()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Spent")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(Worker.getId_Cert()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Cert Id")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(Worker.getId_Worker()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Worker Id")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( Worker.getPost().toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Post")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }
                return false;
            });



        });

        SortedList<Worker> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(TableWorkers.comparatorProperty());

        TableWorkers.setItems(sortedData);

    }

    private void checkButtons() {

        ButtonCalc.setOnAction(actionEvent -> {

            try {

                errorId(FieldId);
                errorId(FieldCert);

                if ("".equals(FieldId.getText()) || FieldId.getText() == null || "0".equals(FieldId.getText()) ||
                        "".equals(FieldCert.getText()) || FieldCert.getText() == null || "0".equals(FieldCert.getText())) {

                    throw new Exception("Calculation error");

                }

                ResultSet rs = new DHandler().selectFromWhere("Sum", "certification",
                        "Id_Cert", FieldCert.getText());
                rs.next();

                if ("".equals(FieldSpent.getText()) || FieldSpent.getText() == null ) FieldSpent.setText("0");

                int sum = Integer.parseInt(FieldSpent.getText()) - rs.getInt(1);

                String result;
                if (sum > 0) {
                    result = "The company should return " + FieldName.getText() + " : ";
                    result += FieldSpent.getText() + " - " + rs.getInt(1);
                    result += " = " + sum + " money " ;
                } else if (sum < 0) {
                    result = FieldName.getText() + " should return the company : ";
                    result += rs.getInt(1) + " - " + FieldSpent.getText();
                    sum = rs.getInt(1) - Integer.parseInt(FieldSpent.getText());
                    result += " = " + sum + " money " ;
                } else result = "no debt ";


                JOptionPane.showMessageDialog(null,
                        result ,
                        "Calculated debt", JOptionPane.PLAIN_MESSAGE);


            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Calculation error. Select row with certification to calculate.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }


        });

        ButtonReflesh.setOnAction(actionEvent -> {

            int size = List.size();
            Worker[] w = List.sorted().toArray(new Worker[0]);

            for (int i = 0; i < size; i++) {

                FieldId.setText(String.valueOf(w[i].getId_Worker()));

                if (w[i].getId_Cert() == 0) {
                    FieldCert.setText("0");
                    FieldSpent.setText("0");
                } else {
                    FieldCert.setText(String.valueOf(w[i].getId_Cert()));
                    FieldSpent.setText(String.valueOf(w[i].getSpent()));
                }

                FieldPost.setText(w[i].getPost());
                FieldName.setText(w[i].getFull_Name());

                try {
                    ResultSet rs = editData();
                    List.remove(w[i]);
                    if (!rs.next()) continue;


                    List.add(new Worker(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            FieldId.setText("");
            FieldPost.setText("");
            FieldCert.setText("");
            FieldName.setText("");
            FieldSpent.setText("");
        });

        ButtonDelete.setOnAction(actionEvent -> {

            try {

                if (TableWorkers.getSelectionModel().isEmpty()) throw new Exception("error deleting");

                new DHandler().deleteRowFromWhere("Worker", "Id_Worker",
                        String.valueOf(TableWorkers.getSelectionModel().getSelectedItem().getId_Worker()));

                List.remove(TableWorkers.getSelectionModel().getSelectedItem());

            } catch (Exception e) {
                errorDelete();
            }

        });

        ButtonNew.setOnAction(actionEvent -> {

            if ("".equals(FieldSpent.getText()) || FieldSpent.getText() == null) FieldSpent.setText("0");

            try {


                if (0 > Integer.parseInt(FieldSpent.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Spent should be not less 0 ",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    throw new Exception("Spent should be not less 0 ");
                }

                errorId(FieldId);


                boolean create = true;
                for (Worker w : List) {
                    if ( "0".equals(FieldId.getText()) ) {
                        System.out.println("AAAAAAAAAAAAAAAAAAAa");
                        errorFill();
                        create = false;
                        break;
                    } else if (w.getId_Worker() == Integer.parseInt(FieldId.getText())) {
                        create = false;
                        List.remove(w);

                        ResultSet rs = editData();
                        rs.next();
                        List.add(new Worker(rs));
                        break;
                    }
                }
                if (create) {
                    ResultSet rs = addData();
                    rs.next();
                    List.add(new Worker(rs));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            FieldSpent.setText("");

        });
    }


    private ResultSet editData() throws SQLException {

        if ("".equals(FieldCert.getText()) || "0".equals(FieldCert.getText())) FieldCert.setText(null);

        String check = "Select Id_Cert\n" +
                "    from mydb.Certification " +
                " where Id_Cert = " + FieldCert.getText();

        System.out.println(check);
        ResultSet rs = new DHandler().executeQuery(check);

        if (!rs.next()) FieldCert.setText(null);

        if (FieldCert.getText() == null) FieldSpent.setText(null);


        String s = "Full_Name = '" + FieldName.getText() + "', Post = '" + FieldPost.getText() +
                "', Spent = " + FieldSpent.getText() + ", Id_cert = " + FieldCert.getText() +
                " where Id_Worker = " + FieldId.getText();


        new DHandler().editData("Workers", s);
        return new DHandler().selectFromWhere("*", "Workers",
                "Id_Worker", String.valueOf(FieldId.getText()));
    }

    private ResultSet addData() {
        if ("".equals(FieldCert.getText()) || "0".equals(FieldCert.getText())) FieldCert.setText(null);
        if (FieldCert.getText() == null) FieldSpent.setText(null);

        String s = FieldId.getText() + ", '" + FieldName.getText() + "', '" + FieldPost.getText() +
                "', " + FieldSpent.getText() + ", " + FieldCert.getText();


        new DHandler().insertData("Workers", s);
        return new DHandler().selectFromWhere("*", "Workers",
                "Id_Worker", String.valueOf(FieldId.getText()));
    }

    private void checkMouse() {
        TableWorkers.setOnMouseClicked(mouseEvent -> {
            if (!TableWorkers.getSelectionModel().isEmpty()) {
                Worker w = TableWorkers.getSelectionModel().getSelectedItem();
                FieldId.setText(String.valueOf(w.getId_Worker()));
                FieldName.setText(String.valueOf(w.getFull_Name()));
                FieldPost.setText(String.valueOf(w.getPost()));
                FieldSpent.setText(String.valueOf(w.getSpent()));
                FieldCert.setText(String.valueOf(w.getId_Cert()));
                if ("0".equals(FieldCert.getText())) FieldCert.setText("");
                if ("0".equals(FieldSpent.getText())) FieldSpent.setText("");
            }
        });

        Pane.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                FieldId.setText("");
                FieldName.setText("");
                FieldPost.setText("");
                FieldSpent.setText("");
                FieldCert.setText("");
            }
        });
    }


    private void initTable(String s, TableColumn temp[] , ObservableList<Worker> List) {

        try {
            ResultSet rs = ControllerMenu.setHeadTableAndGetTable(s, temp);
            while (rs.next()) {

                Worker w = new Worker(rs);
                if (w.getId_Cert() == 0) w.setSpent(0);
                List.add(w);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorInit();
        }
        TableWorkers.setItems(List);

    }

}



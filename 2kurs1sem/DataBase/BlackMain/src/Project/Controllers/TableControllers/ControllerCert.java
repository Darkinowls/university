package Project.Controllers.TableControllers;

import Project.Controllers.ControllerMenu;
import Project.Controllers.TableControllers.Tables.Cert;
import Project.Controllers.TableControllers.Tables.Task;
import Project.Controllers.TableControllers.Tables.Worker;
import Project.DataBase.DHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.concurrent.ExecutionException;

import static Project.Controllers.ControllerMenu.*;

public class ControllerCert {

    @FXML
    private TableView<Cert> TableCert;
    @FXML
    private TableColumn<Cert, Integer> Id_PCert;
    @FXML
    private TableColumn<Cert, Date> Issue_Date;
    @FXML
    private TableColumn<Cert, Integer> Sum;
    @FXML
    private TableColumn<Cert, Integer> Id_Task1;
    @FXML
    private TableColumn<Cert, Integer> Id_Task2;

    @FXML
    private AnchorPane Pane;
    @FXML
    private Button ButtonDelete;
    @FXML
    private Button ButtonNew;
    @FXML
    private Button ButtonReflesh;
    @FXML
    private TextField FieldId;
    @FXML
    private TextField FieldTask2;
    @FXML
    private TextField FieldTask1;
    @FXML
    private TextField FieldFillter;

    @FXML
    private ComboBox<String> ComboBox;

    private ObservableList<Cert> List = FXCollections.observableArrayList();


    @FXML
    void initialize() throws SQLException {


        TableColumn[] t = new TableColumn[]{Id_PCert, Issue_Date, Sum, Id_Task1, Id_Task2};
        initTable("Certification", t , List);

        checkMouse();
        checkButtons();
        checkFilter();


    }

    private void checkFilter() {

        ComboBox.getItems().add("Cert Id");
        ComboBox.getItems().add("Issue Date");
        ComboBox.getItems().add("Sum");
        ComboBox.getItems().add("Task 1 Id");
        ComboBox.getItems().add("Task 2 Id");
        ComboBox.getItems().add("All");

        ComboBox.getSelectionModel().select("All");

        FilteredList<Cert> filteredData = new FilteredList<>(List, p -> true);

        FieldFillter.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(Cert->{
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerValue = newValue.toLowerCase();

                if ( String.valueOf(Cert.getId_Cert()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Cert Id")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(Cert.getId_Task2()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Task 2 Id")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(Cert.getId_Task1()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Task 1 Id")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                } else if ( String.valueOf(Cert.getSum()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Sum")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                } else if ( String.valueOf(Cert.getIssue_Date()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Issue Date")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }
                return false;
            });
        });

        SortedList<Cert> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(TableCert.comparatorProperty());

        TableCert.setItems(sortedData);

    }

    private void checkButtons() {

        ButtonReflesh.setOnAction(actionEvent -> {

            int size = List.size();
            Cert [] w = List.sorted().toArray(new Cert[0]);

                for (int i = 0 ; i < size ; i++) {

                    FieldId.setText(String.valueOf(w[i].getId_Cert()));

                    if (w[i].getId_Task2() == 0)FieldTask2.setText("0");
                    else  FieldTask2.setText(String.valueOf(w[i].getId_Task2()));

                    if (w[i].getId_Task1() == 0)FieldTask1.setText("0");
                    else  FieldTask1.setText(String.valueOf(w[i].getId_Task1()));

                    try {
                        ResultSet rs = editData() ;
                        List.remove(w[i]);
                        if (!rs.next() ) continue;

                        List.add(new Cert(rs));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            FieldTask2.setText("");
            FieldTask1.setText("");
            FieldId.setText("");
        });

        ButtonDelete.setOnAction(actionEvent -> {

            try {


                if (TableCert.getSelectionModel().isEmpty())throw new Exception("error deleting");

                new DHandler().deleteRowFromWhere("Certification", "Id_Cert",
                        String.valueOf(TableCert.getSelectionModel().getSelectedItem().getId_Cert()));

                List.remove(TableCert.getSelectionModel().getSelectedItem());

            } catch (Exception e) {
                errorDelete();
            }

        });

        ButtonNew.setOnAction(actionEvent -> {

            boolean create = true;

            if ("".equals(FieldTask1.getText()) || FieldTask1.getText() == null) FieldTask1.setText("0");
            if ("".equals(FieldTask2.getText()) || FieldTask2.getText() == null) FieldTask2.setText("0");

            try {

                checkData();

                errorId(FieldId);

                for (Cert w : List) {

                    if (((w.getId_Task1() == Integer.parseInt(FieldTask1.getText())) &&
                            (w.getId_Task2() == Integer.parseInt(FieldTask2.getText()))) ||

                            ((w.getId_Task1() == Integer.parseInt(FieldTask2.getText())) &&
                                    (w.getId_Task2() == Integer.parseInt(FieldTask1.getText())))) {

                        System.out.println("AAAAAAAAAAa");

                        JOptionPane.showMessageDialog(null,
                                "The same Certification exists",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        create = false;

                        break;
                    }

                    if (("".equals(FieldId.getText())|| "0".equals(FieldId.getText()) || FieldId.getText() == null)) {
                        errorFill();
                        create = false;
                        break;
                    }

                    if (w.getId_Cert() == Integer.parseInt(FieldId.getText())) {

                        create = false;
                        List.remove(w);
                        ResultSet rs = editData();
                        rs.next();

                        List.add(new Cert(rs));
                        break;
                    }
                }
                if (create) {

                    ResultSet rs = addData();
                    rs.next();
                    List.add(new Cert(rs));
                }

            } catch (Exception e) {
                e.printStackTrace();

            }

            if (FieldTask2.getText() == null) FieldTask2.setText("");
            if (FieldTask1.getText() == null) FieldTask1.setText("");

        });
    }


    private ResultSet editData() throws Exception {
        String s = null;

        if ("0".equals(FieldTask1.getText()) && "0".equals(FieldTask2.getText())) {

            JOptionPane.showMessageDialog(null,
                    "Should be 1 or 2 tasks",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("0".equals(FieldTask1.getText()) || "0".equals(FieldTask2.getText())) {

            if ("0".equals(FieldTask1.getText())) FieldTask1.setText(FieldTask2.getText());
            FieldTask2.setText(null);

            s = "Sum = (select Price_way + Price_residence \n" +
                    " from mydb.Task \n" +
                    "        where Id_task = " + FieldTask1.getText() + "),\n";

            s += "Issue_Date = (select  (Start_Date - interval 7 day)\n " +
                    "   from mydb.Task\n" +
                    "        where Id_task = " + FieldTask1.getText() + " ),\n ";

            s += "Id_Task1 = " + FieldTask1.getText();

            s += ", Id_Task2 = " + FieldTask2.getText();

            s += " where Id_Cert = " + FieldId.getText();


        } else {

            s = "Sum = ((select Price_way + Price_residence \n" +
                    " from mydb.Task \n" +
                    "        where Id_task = " + FieldTask1.getText() + ")\n" +
                    "          + (select Price_way + Price_residence \n" +
                    "from mydb.Task \n" +
                    "        where Id_task = " + FieldTask2.getText() + ")\n" +
                    "        ), \n";

            s += " Issue_Date = least((select  (Start_Date - interval 7 day)\n" +
                    "   from mydb.Task\n" +
                    "        where Id_task = " + FieldTask1.getText() + " ) , (select (Start_date - interval 7 day)\n" +
                    "   from mydb.Task\n" +
                    "        where Id_task = " + FieldTask2.getText() + " )\n" +
                    "        ),";

            s += "Id_Task1 = " + FieldTask1.getText() + ", Id_Task2 = " + FieldTask2.getText();

            s += " where Id_Cert = " + FieldId.getText();


        }


        new DHandler().editData("Certification", s);
        return new DHandler().selectFromWhere("*", "Certification",
                "Id_Cert", String.valueOf(FieldId.getText()));
    }

    private ResultSet addData() throws Exception {
        String s = null;

        if ("0".equals(FieldTask1.getText()) && "0".equals(FieldTask2.getText())) {
            JOptionPane.showMessageDialog(null,
                    "Should be 1 or 2 tasks",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("0".equals(FieldTask1.getText()) || "0".equals(FieldTask2.getText())) {

            if ("0".equals(FieldTask1.getText())) FieldTask1.setText(FieldTask2.getText());
            FieldTask2.setText(null);

            System.out.println(FieldId.getText());

            s = FieldId.getText() + " , ";

            s += "(select  (Start_Date - interval 7 day)\n" +
                    "   from mydb.Task\n" +
                    "        where Id_task = " + FieldTask1.getText() + " ), ";

            s += "(select Price_way + Price_residence \n" +
                    " from mydb.Task \n" +
                    "        where Id_task = " + FieldTask1.getText() + "), \n";

            s += FieldTask1.getText() + " , " + FieldTask2.getText();


        } else {

            s = FieldId.getText() + ", ";

            s += "least((select  (Start_Date - interval 7 day)\n" +
                    "   from mydb.Task\n" +
                    "        where Id_task = " + FieldTask1.getText() + " ) , (select  (Start_date - interval 7 day)\n" +
                    "   from mydb.Task\n" +
                    "        where Id_task = " + FieldTask2.getText() + " )\n" +
                    "        ),";

            s += "((select Price_way + Price_residence \n" +
                    " from mydb.Task \n" +
                    "        where Id_task = " + FieldTask1.getText() + ")\n" +
                    "          + (select Price_way + Price_residence \n" +
                    "from mydb.Task \n" +
                    "        where Id_task = " + FieldTask2.getText() + ")\n" +
                    "        ), \n";

            s += FieldTask1.getText() + ", " + FieldTask2.getText();
        }
        new DHandler().insertData("Certification", s);
        return new DHandler().selectFromWhere("*", "Certification",
                "Id_Cert", String.valueOf(FieldId.getText()));
    }


    private void checkData() throws Exception {
        if (FieldTask1.getText().equals(FieldTask2.getText())) {
            JOptionPane.showMessageDialog(null,
                    "Two the same tasks",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Two the same tasks");

        }
    }

    private void checkMouse() {
        TableCert.setOnMouseClicked(mouseEvent -> {
            if (!TableCert.getSelectionModel().isEmpty()) {
                Cert w = TableCert.getSelectionModel().getSelectedItem();
                FieldId.setText(String.valueOf(w.getId_Cert()));
                FieldTask1.setText(String.valueOf(w.getId_Task1()));
                FieldTask2.setText(String.valueOf(w.getId_Task2()));
                if ("0".equals(FieldTask1.getText())) FieldTask1.setText("");
                if ("0".equals(FieldTask2.getText())) FieldTask2.setText("");
            }
        });

        Pane.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                FieldId.setText("");
                FieldTask1.setText("");
                FieldTask2.setText("");
            }
        });
    }


    protected void initTable(String s, TableColumn temp[] , ObservableList<Cert> List) throws SQLException {
        ResultSet rs = ControllerMenu.setHeadTableAndGetTable(s, temp);
        while (rs.next()) {

            Cert w = new Cert(rs);
            List.add(w);

        }
        TableCert.setItems(List);


    }

}

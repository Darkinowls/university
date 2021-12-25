package Project.Controllers.TableControllers;

import Project.Controllers.ControllerMenu;
import Project.Controllers.TableControllers.Tables.Cert;
import Project.Controllers.TableControllers.Tables.Task;
import Project.Controllers.TableControllers.Tables.Worker;
import Project.DataBase.DHandler;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
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

import static Project.Controllers.ControllerMenu.*;

public class ControllerTask {

    @FXML
    private AnchorPane Pane;
    @FXML
    private TableView<Task> TableTask;
    @FXML
    private TableColumn<Task, Integer> Id_PTask;
    @FXML
    private TableColumn<Task, Date> Start_Date;
    @FXML
    private TableColumn<Task, Date> End_Date;
    @FXML
    private TableColumn<Task, Integer> Number_Days;
    @FXML
    private TableColumn<Task, Integer> Price_Way;
    @FXML
    private TableColumn<Task, Integer> Price_Residence;
    @FXML
    private TableColumn<Task, Integer> Id_City;

    @FXML
    private Button ButtonDelete;
    @FXML
    private Button ButtonNew;
    @FXML
    private Button ButtonReflesh;
    @FXML
    private TextField FieldId;
    @FXML
    private TextField FieldEnd;
    @FXML
    private TextField FieldStart;
    @FXML
    private TextField FieldWay;
    @FXML
    private TextField FieldCity;
    @FXML
    private TextField FieldFillter;
    private ObservableList<Task> List = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> ComboBox;

    @FXML
    void initialize() {

        TableColumn[] t = new TableColumn[]{Id_PTask, Start_Date, End_Date, Number_Days, Price_Way, Price_Residence, Id_City};
        initTable("Task", t , List);

        checkMouse();
        checkButtons();
        checkFilter();



    }

    private void checkFilter(){

        ComboBox.getItems().add("Task Id");
        ComboBox.getItems().add("Start Date");
        ComboBox.getItems().add("End Date");
        ComboBox.getItems().add("Days");
        ComboBox.getItems().add("Price for Way");
        ComboBox.getItems().add("Price for Residence");
        ComboBox.getItems().add("City Id");
        ComboBox.getItems().add("All");

        ComboBox.getSelectionModel().select("All");

        FilteredList<Task> filteredData = new FilteredList<>(List, p -> true);

        FieldFillter.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(Task->{
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerValue = newValue.toLowerCase();

                if ( String.valueOf(Task.getId_Task()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Task Id")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(Task.getId_City()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("City Id")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(Task.getPrice_Way()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Price for Way")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(Task.getNumber_Days()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Days")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(Task.getStart_Date()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Start Date")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(Task.getEnd_Date()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("End Date")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))) {
                    return true;
                }else if ( String.valueOf(Task.getPrice_Residence()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Price for Residence")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Task> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(TableTask.comparatorProperty());

        TableTask.setItems(sortedData);


    }

    private void checkButtons() {

        ButtonReflesh.setOnAction(actionEvent -> {

            int size = List.size();
            Task[] w = List.sorted().toArray(new Task [0]);

            for (int i = 0 ; i < size ; i++) {

                FieldId.setText(String.valueOf(w[i].getId_Task()));
                FieldCity.setText(String.valueOf(w[i].getId_City()));
                FieldStart.setText(String.valueOf(w[i].getStart_Date()));
                FieldEnd.setText(String.valueOf(w[i].getEnd_Date()));
                FieldWay.setText(String.valueOf(w[i].getPrice_Way()));


                try {
                    ResultSet rs = editData() ;
                    List.remove(w[i]);
                    if (!rs.next() ) continue;

                    List.add(new Task(rs));
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
            FieldId.setText("");
            FieldCity.setText("");
            FieldStart.setText("");
            FieldEnd.setText("");
            FieldWay.setText("");

        });

        ButtonDelete.setOnAction(actionEvent -> {

            try{

                if (TableTask.getSelectionModel().isEmpty())throw new Exception("error deleting");

                new DHandler().deleteRowFromWhere("Task", "Id_Task",
                        String.valueOf(TableTask.getSelectionModel().getSelectedItem().getId_Task()));

                List.remove(TableTask.getSelectionModel().getSelectedItem());

            }catch (Exception e){
                errorDelete();
        }
        });

        ButtonNew.setOnAction(actionEvent -> {

            if (FieldWay.getText() == null || "".equals(FieldWay.getText()) || 0 > Integer.parseInt(FieldWay.getText())){
                JOptionPane.showMessageDialog(null,
                        "Price way should be not less 0  ",
                        "Error", JOptionPane.ERROR_MESSAGE);
                FieldWay.setText("0");
            }

            try {

                errorId(FieldId);

                boolean create = true;
                for (Task w : List) {
                    if ("".equals(FieldId.getText())|| "0".equals(FieldId.getText()) || FieldId.getText() == null) {
                        errorFill();
                        create = false;
                        break;
                    } else if (w.getId_Task() == Integer.parseInt(FieldId.getText())) {
                        create = false;
                        List.remove(w);

                        ResultSet rs = editData();
                        rs.next();
                        List.add(new Task(rs));
                        break;
                    }
                }
                if (create) {
                    ResultSet rs = addData();
                    rs.next();
                    List.add(new Task(rs));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    private ResultSet editData() {
        String s = "Start_Date = '" + FieldStart.getText() + "', End_Date = '" + FieldEnd.getText() +
                "', Price_Way = " + FieldWay.getText() + ", Id_City = " + FieldCity.getText() + ", ";

        s += "Number_Days = datediff(End_date,Start_date), \n"
                + " Price_Residence = (datediff(End_date,Start_date) * ( select Price_day from mydb.Type_city \n"
                + " where Id_type =  (  select Id_type \n"
                + " from mydb.City "
                + " where Id_city = " + FieldCity.getText() + " )))\n";

        s += " where Id_Task = " + FieldId.getText();

        new DHandler().editData("Task", s);
        return new DHandler().selectFromWhere("*", "Task",
                "Id_Task", String.valueOf(FieldId.getText()));
    }

    private ResultSet addData() {

        String s = FieldId.getText() + ", '" + FieldStart.getText() + "', '" + FieldEnd.getText();
        s += "', datediff(End_date,Start_date), \n";
        s += FieldWay.getText() + ", \n";
        s += "(datediff(End_date,Start_date) * ( select Price_day from mydb.Type_city \n"
                + "where Id_type =  (  select Id_type \n"
                + "from mydb.City \n"
                + "where Id_city = " + FieldCity.getText() + " ))), \n";

        s += FieldCity.getText();

        new DHandler().insertData("Task", s);
        return new DHandler().selectFromWhere("*", "Task",
                "Id_Task", String.valueOf(FieldId.getText()));
    }

    private void checkMouse() {
        TableTask.setOnMouseClicked(mouseEvent -> {
            if (!TableTask.getSelectionModel().isEmpty()) {
                Task w = TableTask.getSelectionModel().getSelectedItem();
                FieldId.setText(String.valueOf(w.getId_Task()));
                FieldEnd.setText(String.valueOf(w.getEnd_Date()));
                FieldStart.setText(String.valueOf(w.getStart_Date()));
                FieldWay.setText(String.valueOf(w.getPrice_Way()));
                FieldCity.setText(String.valueOf(w.getId_City()));
            }
        });

        Pane.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                FieldId.setText("");
                FieldEnd.setText("");
                FieldStart.setText("");
                FieldWay.setText("");
                FieldCity.setText("");
            }
        });
    }


    protected void initTable(String s, TableColumn temp[],ObservableList<Task> List)  {
        try{
            ResultSet rs = ControllerMenu.setHeadTableAndGetTable(s, temp);
            while (rs.next()) {

                Task w = new Task(rs);
                List.add(w);

            }
        }catch (SQLException e){
            e.printStackTrace();
            errorInit();
        }
        TableTask.setItems(List);
    }
}

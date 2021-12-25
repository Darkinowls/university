package Project.Controllers.TableControllers;

import Project.Controllers.ControllerMenu;
import Project.Controllers.TableControllers.Tables.Cert;
import Project.Controllers.TableControllers.Tables.City;
import Project.Controllers.TableControllers.Tables.Task;
import Project.Controllers.TableControllers.Tables.Worker;
import Project.DataBase.DHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Project.Controllers.ControllerMenu.*;

public class ControllerDic {

    @FXML
    private AnchorPane Pane;

    @FXML
    private TableView<City> TableCities;

    @FXML
    private TableColumn<City, Integer> Id_PCity;

    @FXML
    private TableColumn<City, String> NameCity;

    @FXML
    private TableColumn<City, Integer> Id_Type;

    @FXML
    private TableColumn<City, String> NameType;

    @FXML
    private TableColumn<City, Integer> Price_day;

    @FXML
    private Button ButtonDelete;

    @FXML
    private TextField FieldId;

    @FXML
    private TextField FieldType;

    @FXML
    private TextField FieldName;

    @FXML
    private Button ButtonNew;
    @FXML
    private TextField FieldFillter;

    @FXML
    private ComboBox<String> ComboBox;

    private ObservableList<City> List = FXCollections.observableArrayList();


    @FXML
    void initialize() throws SQLException {
        TableColumn[] t = new TableColumn[]{Id_PCity, NameCity, Id_Type, NameType, Price_day};


        String Table = "(Select Id_City, Name , city.Id_Type, Type , Price_day  \n" +
                "from mydb.City \n" +
                "INNER JOIN mydb.Type_city ON city.Id_Type = type_city.Id_Type )";

        initTable(Table, t , List);

        checkButtons();

        checkMouse();

        checkFilter();



    }

    private void checkFilter(){

        ComboBox.getItems().add("City Id");
        ComboBox.getItems().add("Name");
        ComboBox.getItems().add("Type id");
        ComboBox.getItems().add("Type");
        ComboBox.getItems().add("Price for day");
        ComboBox.getItems().add("All");

        ComboBox.getSelectionModel().select("All");

        FilteredList<City> filteredData = new FilteredList<>(List, p -> true);

        FieldFillter.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(City->{
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerValue = newValue.toLowerCase();

                if ( String.valueOf(City.getId_City()).toLowerCase().contains(lowerValue)
                        &&
                        (ComboBox.getSelectionModel().getSelectedItem().equals("City Id")
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(City.getId_Type()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Type id" )
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( String.valueOf(City.getPrice_day()).toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Price for day" )
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( City.getName().toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Name" )
                        || ComboBox.getSelectionModel().getSelectedItem().equals("All"))){
                    return true;
                }else if ( City.getType().toLowerCase().contains(lowerValue)
                        && (ComboBox.getSelectionModel().getSelectedItem().equals("Type" )||
                        ComboBox.getSelectionModel().getSelectedItem().equals("All"))){

                    return true;
                }
                return false;
            });
        });

        SortedList<City> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(TableCities.comparatorProperty());

        TableCities.setItems(sortedData);

    }

    private void checkButtons() {
        ButtonDelete.setOnAction(actionEvent -> {


            try {

                if (TableCities.getSelectionModel().isEmpty())throw new Exception("error deleting");

                String delete = "delete mydb.City \n" +
                        "From mydb.City \n" +
                        " inner join mydb.Type_City On City.Id_Type = Type_City.Id_Type \n" +
                        "Where  mydb.City.Id_City = " + TableCities.getSelectionModel().getSelectedItem().getId_City();

                new DHandler().execute(delete);

                List.remove(TableCities.getSelectionModel().getSelectedItem());


            } catch (Exception e) {
                errorDelete();
            }

        });

        ButtonNew.setOnAction(actionEvent -> {

            try {

            if ("".equals(FieldType.getText()) || Integer.parseInt(FieldType.getText()) <= 0 ||
                    Integer.parseInt(FieldType.getText()) > 3 ){
                JOptionPane.showMessageDialog(null,
                        "Type Id should be x|  1<= x <= 3",
                        "Error",  JOptionPane.ERROR_MESSAGE );
                    throw new Exception("Type Id should be x|  1<= x <= 3");

            }

                boolean create = true;
                for (City w : List) {
                    if ("".equals(FieldId.getText())|| "0".equals(FieldId.getText()) || FieldId.getText() == null) {
                        errorFill();
                        create = false;
                        break;
                    } else if (w.getId_City() == Integer.parseInt(FieldId.getText())) {
                        create = false;
                        List.remove(w);

                        ResultSet rs = editData();
                        rs.next();
                        List.add(new City(rs));
                        break;
                    }
                }
                if (create) {

                    ResultSet rs = addData();
                    rs.next();
                    List.add(new City(rs));
                }

            }  catch ( Exception e) {
                e.printStackTrace();
            }

        });
    }

    private ResultSet editData() {

        String table = "City c\n" +
                "  inner join  mydb.Type_City t on  t.Id_Type = c.Id_Type \n";
         String state = "  Name = '"+  FieldName.getText()  +"', \n" +
                        "  c.Id_Type = " + FieldType.getText() + " \n" +
                        "  where Id_City = " + FieldId.getText() ;


        new DHandler().editData(table, state);

        String name = "Id_City, Name , c.Id_Type, t.Type , t.Price_day \n";

        return new DHandler().selectFromWhere(name , table, "Id_City", String.valueOf(FieldId.getText()));

    }

    private ResultSet addData() {

        String s = FieldId.getText() + ", '" +FieldName.getText() + "', " + FieldType.getText();
        new DHandler().insertData("City", s);

        String table = "City c\n" +
                "  inner join  mydb.Type_City t on  t.Id_Type = c.Id_Type \n";

        String name = "Id_City, Name , c.Id_Type, t.Type , t.Price_day \n";

        return new DHandler().selectFromWhere(name , table,
                "Id_City", String.valueOf(FieldId.getText()));
    }


    protected void initTable(String s, TableColumn temp[], ObservableList<City> List) throws SQLException {

        try {
            ResultSet rs = new DHandler().executeQuery(s);
            for (int i = 1; i <= temp.length; i++) {
                temp[i - 1].setCellValueFactory(new PropertyValueFactory<>(rs.getMetaData().getColumnName(i)));
            }
            while (rs.next()) {
                City w = new City(rs);
                List.add(w);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorInit();
        }
        TableCities.setItems(List);

    }

    private void checkMouse() {
        TableCities.setOnMouseClicked(mouseEvent -> {
            if (!TableCities.getSelectionModel().isEmpty()) {
                City w = TableCities.getSelectionModel().getSelectedItem();
                FieldId.setText(String.valueOf(w.getId_City()));
                FieldType.setText(String.valueOf(w.getId_Type()));
                FieldName.setText(w.getName());
                if ("0".equals(FieldType.getText())) FieldType.setText("");
            }
        });

        Pane.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                FieldId.setText("");
                FieldType.setText("");
                FieldName.setText("");
            }
        });
    }
}

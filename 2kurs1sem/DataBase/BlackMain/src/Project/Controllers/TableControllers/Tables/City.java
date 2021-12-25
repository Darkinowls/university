package Project.Controllers.TableControllers.Tables;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class City {
    private int Id_City;
    private SimpleStringProperty Name;
    private int Id_Type;
    private SimpleStringProperty Type;
    private int Price_day;

    public City(ResultSet rs) throws SQLException {
        Id_City = rs.getInt(1);
        Name = new SimpleStringProperty(rs.getString(2));
        Id_Type = rs.getInt(3);
        Type = new SimpleStringProperty(rs.getString(4));
        Price_day = rs.getInt(5);

    }


    public int getId_City() {
        return Id_City;
    }


    public int getId_Type() {
        return Id_Type;
    }

    public String getName() {
        return Name.get();
    }


    public String getType() {
        return Type.get();
    }


    public int getPrice_day() {
        return Price_day;
    }
}

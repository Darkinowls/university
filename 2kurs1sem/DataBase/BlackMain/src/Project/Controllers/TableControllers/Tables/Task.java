package Project.Controllers.TableControllers.Tables;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task {
    private int Id_Task;
    private Date Start_Date;
    private Date End_Date;
    private int Number_Days;
    private int Price_Way;
    private int Price_Residence;
    private int Id_City;
    public Task(ResultSet rs) throws SQLException {

        Id_Task = rs.getInt(1);
        Start_Date = rs.getDate(2);
        End_Date =  rs.getDate(3);
        Number_Days =  rs.getInt(4);
        Price_Way  = rs.getInt(5);
        Price_Residence = rs.getInt(6);
        Id_City = rs.getInt(7);
    }

    public int getId_Task() {
        return Id_Task;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public Date getEnd_Date() {
        return End_Date;
    }

    public int getNumber_Days() {
        return Number_Days;
    }

    public int getPrice_Way() {
        return Price_Way;
    }

    public int getPrice_Residence() {
        return Price_Residence;
    }

    public int getId_City() {
        return Id_City;
    }
}

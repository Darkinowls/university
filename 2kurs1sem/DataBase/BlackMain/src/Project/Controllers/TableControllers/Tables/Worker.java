package Project.Controllers.TableControllers.Tables;


import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Worker {
    private int Id_Worker;
    private SimpleStringProperty Full_Name;
    private SimpleStringProperty Post;
    private int Spent;
    private int Id_Cert;


    public Worker(ResultSet rs) throws SQLException {

        Id_Worker = rs.getInt(1);
        Full_Name = new SimpleStringProperty(rs.getString(2));
        Post = new SimpleStringProperty(rs.getString(3));
        Spent = rs.getInt(4);
        Id_Cert = rs.getInt(5);


    }

    public void setSpent(int spent) {
        Spent = spent;
    }

    public void setId_Cert(int id_Cert) {
        Id_Cert = id_Cert;
    }

    public int getId_Worker() {
        return Id_Worker;
    }

    public String getFull_Name() {
        return Full_Name.get();
    }


    public String getPost() {
        return Post.get();
    }


    public int getSpent() {
        return Spent;
    }

    public int getId_Cert() {
        return Id_Cert;
    }


}

package Project.DataBase;

import java.sql.*;


public class DConnector {
    private String Host = "localhost";
    private String Port = "3306";
    private String User = "root";
    private String Pass = "root";
    private String Name = "mydb";
    private Connection dbConnection;

    protected Connection getDConnection() throws ClassNotFoundException, SQLException {
        String connectionStr = "jdbc:mysql://" + Host +":"+ Port +"/"+ Name +"?useUnicode=true&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionStr, User, Pass);
        return dbConnection;
    }



}

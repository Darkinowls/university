package Project.Controllers.TableControllers.Tables;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cert {
    private int Id_Cert;
    private Date Issue_Date;
    private int Sum;
    private int Id_Task1;
    private int Id_Task2;

    @Override
    public String toString() {
        return "Cert{" +
                "Id_Cert=" + Id_Cert +
                ", Issue_Date=" + Issue_Date +
                ", Sum=" + Sum +
                ", Id_Task1=" + Id_Task1 +
                ", Id_Task2=" + Id_Task2 +
                '}';
    }

    public Cert(ResultSet rs) throws SQLException {

        Id_Cert = rs.getInt(1);
        Issue_Date = rs.getDate(2);
        Sum = rs.getInt(3);
        Id_Task1 = rs.getInt(4);
        Id_Task2 = rs.getInt(5);

    }


    public Date getIssue_Date() {
        return Issue_Date;
    }

    public int getId_Cert() {
        return Id_Cert;
    }

    public int getSum() {
        return Sum;
    }

    public int getId_Task1() {
        return Id_Task1;
    }

    public int getId_Task2() {
        return Id_Task2;
    }
}

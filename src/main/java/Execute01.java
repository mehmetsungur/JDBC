import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        //Connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","dev","password");

        //Connection Status
        Statement st = con.createStatement();
        System.out.println("Connection Success");

        // Table Add
        //boolean sql1 = st.execute("create table workers(worker_id int,worker_name varchar(50),salary real)");
        //System.out.println("sql 1: " + sql1);

        //Table Update
        //String sql2 = "Alter table workers add column city varchar(20)";
        //st.execute(sql2);

        //Table Delete
        //String sql3 = "Drop table workers";
        //st.execute(sql3);

        //Connection Close
        st.close();
        con.close();
    }
}

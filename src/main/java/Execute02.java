import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws SQLException {
        //Connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","dev","password");

        //Connection Status
        Statement st = con.createStatement();
        System.out.println("Connection Success");

        System.out.println("----------------------");
        String query1 = "select country_name from countries where id between 1 and 2";
        boolean sql1 = st.execute(query1);
        System.out.println("Sql1: " + sql1);

        ResultSet rs1 = st.executeQuery(query1);
        //resultSet.next();
        //System.out.println(resultSet.getString("country_name"));

        System.out.println("----------------------");
        while (rs1.next()){
            System.out.println("Ülke ismi: " + rs1.getString("country_name"));
        }

        System.out.println("----------------------");
        String q2 = "select phone_code from countries where id between 1 and 2";
        ResultSet rs2 = st.executeQuery(q2);

        while (rs2.next()){
            System.out.println("Telefon Kodu: " + rs2.getString("phone_code"));
        }

        System.out.println("----------------------");
        String q3 = "select * from countries";
        ResultSet rs3 = st.executeQuery(q3);

        while (rs3.next()){
            System.out.println(
                            rs3.getInt("id") + " " +
                            rs3.getInt("phone_code") + " " +
                            rs3.getString("country_code") + " " +
                            rs3.getString("country_name"));
        }

        System.out.println("----------------------");
        String q4 = "select MAX(phone_code) from countries";
        ResultSet rs4 = st.executeQuery(q4);
        rs4.next();
        int max = rs4.getInt(1);
        //while (rs4.next()){
        //    System.out.println(rs4.getInt("phone_code"));
        //}

        System.out.println(max);
    }
}

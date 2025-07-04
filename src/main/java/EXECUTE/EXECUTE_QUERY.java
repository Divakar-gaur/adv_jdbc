package EXECUTE;

import java.sql.*;

public class EXECUTE_QUERY {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "123";
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    System.out.println("PostgreSQL JDBC Driver not found.");
                    e.printStackTrace();
                    return;
                }


        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to PostgreSQL successfully!");
            Statement stmt = conn.createStatement();
            String sql="select * from s1";
            stmt.executeQuery(sql);

            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+ rs.getString(2));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}


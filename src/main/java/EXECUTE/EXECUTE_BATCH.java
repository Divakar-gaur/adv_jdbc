package EXECUTE;

import java.sql.*;

public class EXECUTE_BATCH {
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
            String sql = "insert into s1 values(?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,225);
            pstm.setString(2,"xyz");
            pstm.setInt(3,30);

            pstm.addBatch();

            pstm.setInt(1,226);
            pstm.setString(2,"xxyz");
            pstm.setInt(3,31);

            pstm.addBatch();
            pstm.executeBatch(); 

            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}


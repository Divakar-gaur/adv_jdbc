package fetching_practice;

import java.sql.*;
public class name {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/students";
        String name="postgres";
        String pass="123";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
        }
        try (Connection conn=DriverManager.getConnection(url,name,pass)){
            Statement stmt=conn.createStatement();
            String sql="select s_name from s1";
            ResultSet rs= stmt.executeQuery(sql);
            while (rs.next()){
                String k=rs.getString("s_name");
                System.out.println(k);
            }
        } catch (SQLException e) {
        }
    }
}


package fetching_practice;

import java.sql.*;
public class age {
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
            String sql="select s_age from s1";
            ResultSet rs= stmt.executeQuery(sql);
            while (rs.next()){
                int age=rs.getInt("s_age");
                System.out.println(age);
            }
        } catch (SQLException e) {
        }
    }
}



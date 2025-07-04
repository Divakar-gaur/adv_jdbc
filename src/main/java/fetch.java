import java.sql.*;
public class fetch {
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
            String sql="select * from s1";
            ResultSet rs= stmt.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt("s_id");
                String k=rs.getString("s_name");
                int age=rs.getInt("s_age");
                System.out.print(id +", "+k +", "+age);
                System.out.println();
            }
        } catch (SQLException e) {
        }
    }
}
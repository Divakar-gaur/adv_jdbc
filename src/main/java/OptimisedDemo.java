import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OptimisedDemo {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/students";
        String user="postgres";
        String pass="123";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn= DriverManager.getConnection(url,user,pass);
            Statement smt= conn.createStatement();
            String sql="insert into s1 values (001,'devesh',25)";
            smt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }
}

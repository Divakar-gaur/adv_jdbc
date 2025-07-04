
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "123";
//        try {

//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("PostgreSQL JDBC Driver not found.");
//            e.printStackTrace();
//            return;
//        }



//        in string sql we have to write our sql query either it is update or insert or anything


        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            System.out.println("Connected to PostgreSQL successfully!");
            Statement stmt = conn.createStatement();
            String sql="insert into s1 values (105,'pranav',18)";
            stmt.executeUpdate(sql);
            conn.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}

import java.sql.*;

public class delete_dynamic {
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
            System.out.println("Connected to PostgreSQL successfully!");
            String sql = "delete from s1 where s_id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, 101);
            pstm.execute();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}

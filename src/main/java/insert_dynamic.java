
import java.sql.*;

public class insert_dynamic {
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
            String sql="insert into s1 values (?,?,?)";
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1,109);
            pstm.setString(2,"abc");
            pstm.setInt(3,115);
            pstm.execute();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}


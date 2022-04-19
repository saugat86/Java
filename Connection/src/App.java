import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mrs", "root", "");
        Statement st = conn.createStatement();
        PreparedStatement ps= conn.prepareStatement("insert into movie values(?,?,?,?)");
        ps.setString(1, "Soorya");
        ps.setString(2, "Action");
        ps.setString(3, "hindi");
        ps.setString(4, "2.5hrs");
        int i=ps.executeUpdate();
        System.out.println("No. of rows updated= "+i);
        ps.close();
        conn.close();
    }
}

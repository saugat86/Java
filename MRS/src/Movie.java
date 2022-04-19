import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Movie extends JFrame implements ActionListener {
    JFrame jf;
    JTextField t1, t2,t3,t4;
    JLabel l1,l2,l3,l4;
    JButton b1;
    public Movie(){
        jf = new JFrame("Movie Rental System");
        l1= new JLabel("Title");
        l2= new JLabel("Genera");
        l3= new JLabel("Language");
        l4= new JLabel("Length");
        t1= new JTextField(10);
        t2= new JTextField(10);
        t3= new JTextField(10);
        t4= new JTextField(10);
        b1= new JButton("ADD");
        jf.add(l1);
        jf.add(t1);
        jf.add(l2);
        jf.add(t2);
        jf.add(l3);
        jf.add(t3);
        jf.add(l4);
        jf.add(t4);
        jf.add(b1);
        jf.setSize(500,700);
        jf.setLayout(new FlowLayout());
        b1.addActionListener(this);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        Connection conn=null;
        Statement stmt= null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mrs","root","");
            System.out.println("Database connected successfully");
            stmt = conn.createStatement();
            String sql="insert into movie(title, genera, language, length) values (?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1, t1.getText());
            ps.setString(2, t2.getText());
            ps.setString(3, t3.getText());
            ps.setString(4, t4.getText());
            ps.executeUpdate();
            conn.close();
            System.out.println("Inserted successfully"); 

        }catch(Exception se){
        System.out.println(se);
        }
    }
    public static void main(String[] args) {
    new Movie();
}
}

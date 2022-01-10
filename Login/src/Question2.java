import java.sql.*;
import javax.swing.*; import java.awt.*;
import java.awt.event.*;
public class Question2 extends JFrame implements KeyListener
{
JLabel l1,l2;
JTextField username; JPasswordField pass; JButton ok, cancel; Question2()
{
l1=new JLabel("UserId:");
username = new JTextField(20); l2=new JLabel("Password:");
pass = new JPasswordField(20); ok = new JButton("Ok");
cancel = new JButton("Cancel"); add(l1);
add(username); add(l2);
add(pass); add(ok);
add(cancel);
FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 80, 20); setSize(400,400);
setVisible(true);
 
setLayout(fl);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); ok.addKeyListener(this);
cancel.addKeyListener(this);
}
public void keyPressed(KeyEvent ke)
{
if(ke.getKeyChar()== 'i')
{
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection
("jdbc:mysql://localhost:3306/account", "root", "");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from user");

while(rs.next())
{

String un = username.getText();
char[] pw = new char[12]; 

pw = pass.getPassword();
String password = String.valueOf(pw); 
String name = rs.getString(1);
String pass = rs.getString(2);

if (un.equals(name) && password.equals(pass))
{
System.out.println("Login successful");
}
}
stmt.close();
con.close();
}catch(Exception e)
{
System.out.println(e);
}
}
 
else if (ke.getKeyChar()=='c')
{
username.setText(""); pass.setText("");
username.requestFocus();
}
}
public void keyTyped(KeyEvent ke){
    
}
public void keyReleased(KeyEvent ke){}
public static void main(String[] args) {
     new Question2();
}
}

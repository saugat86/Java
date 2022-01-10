import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Example1 extends JFrame implements ActionListener{
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3,t4;
    JButton b1;
    JFrame jf;
    double x, y, z, m;
    public Example1(){
        
        jf= new JFrame("Simpe Interest Calculator");
        l1= new JLabel("Principle:");
        l2= new JLabel("Time:");
        l3= new JLabel("Rate:");
        l4= new JLabel("Result:");
        t1= new JTextField(10);
        t2= new JTextField(10);
        t3= new JTextField(10);
        t4= new JTextField(10);
        jf.setSize(500,800);
        jf.setLayout(new FlowLayout());
        b1= new JButton("Calculate");
        jf.add(l1);
        jf.add(t1);
        jf.add(l2);
        jf.add(t2);
        jf.add(l3);
        jf.add(t3);
        jf.add(l4);
        jf.add(t4);
        jf.add(b1);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(this);
    }
    public static void main(String[] args) {
        new Example1();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        x= Integer.parseInt(t1.getText());
        y=Integer.parseInt(t2.getText());
        z= Integer.parseInt(t3.getText());
        if(e.getActionCommand()=="Calculate")
        m= (x*y*z)/100;
        t4.setText(String.valueOf(m));
    }
}
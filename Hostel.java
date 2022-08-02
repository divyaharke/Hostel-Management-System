import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class Hostel extends JFrame implements ActionListener
{
JButton b1,b2,b3,b4,b5,b6;
JLabel l1;
public Hostel()
{	
super("Hostel Management System");
setup();
addWindowListener(new WindowEventHandler());
setVisible(true);
}
public void setup()
{
setLayout(null);
l1=new JLabel("Hostel Management System");
l1.setFont(new Font("Monotype Corsiva",Font.ITALIC,25));
l1.setBounds(250,100,400,25);
l1.setForeground(Color.red);
b1=new JButton("Student Info");
b1.setBounds(150,200,150,25);
b2=new JButton("Room Allotment");
b2.setBounds(150,250,150,25);
b3=new JButton("Fee Details");
b3.setBounds(450,200,150,25);
b4=new JButton("EXIT");
b4.setBounds(300,380,150,25);
b5=new JButton("Attendance");
b5.setBounds(450,250,150,25);
//b7=new JButton("Refund");
//b7.setBounds(150,300,150,25);
//b6=new JButton("Reports");
//b6.setBounds(450,300,150,25);
add(l1);add(b1);add(b2);add(b3);add(b5);add(b4);
setBackground(Color.cyan);
setForeground(Color.black);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
//b6.addActionListener(this);
//b7.addActionListener(this);
setSize(800,600);
}
public static void main(String s[])
{
Hostel h=new Hostel();
}
public void actionPerformed(ActionEvent ae)
{
String sst=ae.getActionCommand();
if(sst.equals("Student Info"))
{
dispose();
StudentInfo si=new StudentInfo();
   si.setVisible(true);
   JLabel label = new JLabel("Welcome to student info");
   si.getContentPane().add(label);
//new Hostel();
}
else if(sst.equals("Room Allotment"))
{
dispose();
Room1 r1=new Room1();
   r1.setVisible(true);
   JLabel label = new JLabel("Welcome to room");
   r1.getContentPane().add(label);
//new Hostel();
}
else if(sst.equals("Fee Details"))
{
dispose();
Fee f=new Fee();
  f.setVisible(true);
   JLabel label = new JLabel("Welcome to Fee details");
   f.getContentPane().add(label);
//new Hostel();
}
else if(sst.equals("Attendance"))
{
dispose();
Attend1 a1=new Attend1();
a1.setVisible(true);
   JLabel label = new JLabel("Welcome to Student Attendance");
   a1.getContentPane().add(label);
}
else if(sst.equals("EXIT"))
{
System.exit(0);
}
else if(sst.equals("Reports"))
{
dispose();
Report2 r2=new Report2();
   r2.setVisible(true);
   JLabel label = new JLabel("Welcome to report");
   r2.getContentPane().add(label);
//new Hostel();
}
/*else if(sst.equals("Refund"))
{
dispose();
Refund re=new Refund();
   re.setVisible(true);
   JLabel label = new JLabel("Welcome to refund");
   re.getContentPane().add(label);

}*/
}
class WindowEventHandler extends WindowAdapter
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
}
}
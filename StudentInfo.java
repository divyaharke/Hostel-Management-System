import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class StudentInfo extends JFrame implements ActionListener
{
JButton b1,b2,b3,b4;
JLabel l1;
public StudentInfo()
{	
super("Student Information");
setup();
addWindowListener(new WindowEventHandler());
setVisible(true);
}

public void setup()
{
setLayout(null);
l1=new JLabel("Student Information");
l1.setFont(new Font("Monotype Corsiva",Font.ITALIC,25));
l1.setBounds(250,100,400,25);
l1.setForeground(Color.red);
b1=new JButton("Insert");
b1.setBounds(150,200,150,25);
b2=new JButton("Update");
b2.setBounds(150,250,150,25);
b3=new JButton("Delete");
b3.setBounds(450,200,150,25);
b4=new JButton("Home");
b4.setBounds(450,250,150,25);

add(l1);
add(b1);
add(b2);
add(b3);
add(b4);

setBackground(Color.cyan);
setForeground(Color.black);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
setSize(800,600);
}

public static void main(String s[])
{
StudentInfo si=new StudentInfo();
}

public void actionPerformed(ActionEvent ae)
{
String sst=ae.getActionCommand();
if(sst.equals("Insert"))
{
dispose();
Student st=new Student();
   st.setVisible(true);
   JLabel label = new JLabel("Welcome to student info");
   st.getContentPane().add(label);
//new Hostel();
}

if(sst.equals("Delete"))
{
dispose();
Deletion1 d1=new Deletion1();
   d1.setVisible(true);
   JLabel label = new JLabel("Welcome to student deletion form");
   d1.getContentPane().add(label);
//new Hostel();
}

if(sst.equals("Update"))
{
dispose();
Updation1 u1=new Updation1();
   u1.setVisible(true);
   JLabel label = new JLabel("Welcome to student updation form");
   u1.getContentPane().add(label);
//new Hostel();
}
else if(sst.equals("Home"))
{
dispose();
Hostel h=new Hostel();
h.setVisible(true);
}
}

class WindowEventHandler extends WindowAdapter
{
public void windowClosing(WindowEvent we)
{
dispose();
//new Hostel();
//System.exit(0);
}
}
}














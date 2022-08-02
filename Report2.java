import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Report2 extends JFrame implements ActionListener
{
JButton b1,b2,b3;
JLabel l1;

public Report2()
{	
super("Student Reports");
setup();
addWindowListener(new WindowEventHandler());
setVisible(true);
}

public void setup()
{
setLayout(null);
l1=new JLabel("Student Reports");
l1.setFont(new Font("Monotype Corsiva",Font.ITALIC,25));
l1.setBounds(250,100,400,25);
l1.setForeground(Color.red);
b1=new JButton("Student");
b1.setBounds(150,200,150,25);
//b2=new JButton("Fee Details");
//b2.setBounds(150,200,150,25);
b3=new JButton("Fee Details");
b3.setBounds(450,200,150,25);
b2=new JButton("Cancel");
b2.setBounds(300,250,150,25);

add(l1);
add(b1);
add(b2);
add(b3);
//add(b4);

setBackground(Color.cyan);
setForeground(Color.black);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
//b4.addActionListener(this);
setSize(800,600);
}

public static void main(String s[])
{
Report2 r2=new Report2();
}

public void actionPerformed(ActionEvent ae)
{
String sst=ae.getActionCommand();
if(sst.equals("Student"))
{
dispose();
//Student st=new Student();
//   st.setVisible(true);
   JLabel label = new JLabel("Welcome to student info");
//   st.getContentPane().add(label);
//new Hostel();
}

else if(sst.equals("Fee Details"))
{
dispose();
//Deletion d=new Deletion();
  // d.setVisible(true);
   JLabel label = new JLabel("Welcome to Fee details");
 //  d.getContentPane().add(label);
//new Hostel();
}

/*else if(sst.equals("Update"))
{
dispose();
Updation u=new Updation();
   u.setVisible(true);
   JLabel label = new JLabel("Welcome to student info");
   u.getContentPane().add(label);
//new Hostel();
}*/

else if(sst.equals("Cancel"))
{
dispose();
//Hostel h=new Hostel();
//h.setVisible(true);
System.exit(0);
}
}

class WindowEventHandler extends WindowAdapter
{
public void windowClosing(WindowEvent we)
{
dispose();
new Hostel();
//System.exit(0);
}
}
}














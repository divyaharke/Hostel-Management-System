import java.awt.*; 
import java.awt.event.*; 
import java.io.*;
 import javax.swing.*; 
import javax.swing.event.*; 
import java.util.*; 
import java.sql.*; 
 
public class Attend1 extends JFrame implements ActionListener,FocusListener 
{ 
JLabel l1,l2,l3,l4,l5,l6; 
JTextField t1,t2,t3,t6; 
//JTextArea ta1; 
JButton b1,b2,b3; 
//Choice ch; 
//String mon[]={"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"}; 
Choice ch2,ch1; 

Connection con; 
Statement st; 
ResultSet rs; 
PreparedStatement pst;

public Attend1() 
{ 
super("Attendance Information"); 
setup(); 
addWindowListener(new WindowEventHandler());
 setVisible(true);
 }

public void setup() 
{
 setLayout(null);
 l1=new JLabel("Attendance Information"); 
l1.setFont(new Font("Monotype Corsiva",Font.ITALIC,25)); 
l1.setBounds(250,50,400,25);  
 l1.setForeground(Color.red); 
 
setFont(new Font("Courier",Font.BOLD,15)); 
l2=new JLabel("Student ID"); 
l2.setBounds(70,120,100,25);
 /*t2=new JTextField(); t2.setBounds(240,120,180,25);*/ 
ch2=new Choice();
 ch2.setBounds(240,120,180,25);
 ch2.add("");

l3=new JLabel("Month");
 l3.setBounds(70,160,100,25);
 //t3=new JTextField();
 //t3.setBounds(240,160,60,25);
ch1=new Choice();
 ch1.setBounds(240,160,60,25);
 ch1.add("");
ch1.add("Jan");
ch1.add("Feb");
ch1.add("March");
ch1.add("April");
ch1.add("May");
ch1.add("June");
ch1.add("Jully");
ch1.add("Aug");
ch1.add("Sapt");
ch1.add("Oct");
ch1.add("Nov");
ch1.add("Dec");


l4=new JLabel("Total Days"); 
l4.setBounds(70,200,160,25);
 t1=new JTextField();
 t1.setBounds(240,200,60,25);

l5=new JLabel("Present Days"); 
l5.setBounds(70,240,100,25);
 t2=new JTextField();
 t2.setBounds(240,240,60,25);

l6=new JLabel("Absent Days"); 
l6.setBounds(70,280,120,25); 
t3=new JTextField(); 
t3.setBounds(240,280,80,25); 
 
b1=new JButton("Save");
 b1.setBounds(200,450,100,25);
 b2=new JButton("Cancel");
 b2.setBounds(340,450,100,25); 
b3=new JButton("Clear"); 
b3.setBounds(480,450,100,25);

add(l1);
add(l2);
//add(ch2);
add(l3);
//add(ch1);
add(l4);
//add(t1);
add(l5);
//add(t2);
add(l6);
add(ch2);
add(ch1);
add(t1);
add(t2);
add(t3);
//add(t6);
add(b1);
add(b2);
add(b3);

//td.setEditable(false); 
//t8.addFocusListener(this); 
t2.addFocusListener(this);
 b1.addActionListener(this);
 b2.addActionListener(this); 
b3.addActionListener(this);
 setBackground(Color.cyan);
 setSize(800,600); 

/* b1.addActionListener(this);
 b2.addActionListener(this); 
b3.addActionListener(this);
 setBackground(Color.cyan);
 setSize(800,600); */
try
 { 
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
 con=DriverManager.getConnection("jdbc:odbc:acdsn"); 
  st=con.createStatement();
  rs=st.executeQuery("select id from student");
  while(rs.next())
  {  
 int a=rs.getInt(1);   
ch2.add(""+a); 
  
 } 
} 
catch(Exception e)
 {  
System.out.println(e);  
JOptionPane.showMessageDialog(null,"Sql error occured");
 } 
 } 

public void focusLost(FocusEvent f)
 {  
if(f.getSource()==t2)  
{ 
  int res=Integer.parseInt(t1.getText())-Integer.parseInt(t3.getText());
  t2.setText(""+res);
  } 
 } 
public void focusGained(FocusEvent fe) 
{   }



public void actionPerformed(ActionEvent ae)
 {  
String sst=ae.getActionCommand(); 
 if(sst.equals("Save")) 
 {   
String id=ch2.getSelectedItem();
   String month=ch1.getSelectedItem();  
 String tdays=t1.getText();   
String pdays=t2.getText();   
String adays=t3.getText();  
 //String dat=td.getText(); 
 

 try 
 {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
 con=DriverManager.getConnection("jdbc:odbc:acdsn");  
st=con.createStatement(); 
 st.executeUpdate("insert into attend values("+id+",'"+month+"',"+tdays+","+pdays+","+adays+")");
 // st.executeUpdate("insert into address values("+id+",'"+dno+"','"+city+"','"+sta+"',"+pin+")");  

/*String sql="insert into attend values (?,?,?,?,?)";
pst=con.prepareStatement(sql);
pst.setString(1,id);
pst.setString(2,month);
pst.setString(3,tdays);
pst.setString(4,pdays);
pst.setString(5,adays);
int val=pst.executeUpdate();*/

JOptionPane.showMessageDialog(null," Record insert sucessfully");       
  con.close();
  st.close();
  dispose();    
    new Hostel();
  }   
catch(Exception e) 
 {
  System.out.println("SqlException Caught:"+e);   
      JOptionPane.showMessageDialog(null," sql Error is occured");
  }      
       }  

 else if(sst.equals("Cancel"))  
{   
dispose(); 
   Student1 s1=new Student1(); 
 }
  else if(sst.equals("Clear"))   
{
    t1.setText(""); 
   t2.setText("");
    t3.setText("");   
// t6.setText("");   
 //a1.setText("");  
  //a2.setText(""); 
   //a3.setText("");
//ch.select(0);
 }
}

public static void main(String s[])
 { 
 Attend1 at1=new Attend1();
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











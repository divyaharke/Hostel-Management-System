import java.awt.*; 
import java.awt.event.*; 
import java.io.*;
 import javax.swing.*; 
import javax.swing.event.*; 
import java.util.*; 
import java.sql.*; 
 
public class Room1 extends JFrame implements ActionListener,FocusListener 
{ 
JLabel l1,l2,l3,l5,l7,l8,l9,l10; 
JTextField t3,t5,t7,t8,t9,t10; 
//JTextArea ta1; 
JButton b1,b2,b3; 
Choice ch; 
//String mon[]={"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"}; 
Choice ch2; 
Connection con; 
Statement st; 
ResultSet rs; 
 
public Room1() 
{ 
super("Room Allotment"); 
setup(); 
addWindowListener(new WindowEventHandler());
 setVisible(true);
 } 

public void setup() 
{
 setLayout(null);
 l1=new JLabel("Room Allotment"); 
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
 
 
l3=new JLabel("Course");
 l3.setBounds(70,160,100,25);
 t3=new JTextField();
 t3.setBounds(240,160,60,25);
// t3.setText("9000"); 
//t3.setEditable(false); 
 
/*l4=new JLabel("Mess");
 l4.setBounds(360,160,60,25);
 t4=new JTextField();
 t4.setBounds(430,160,60,25); 
t4.setText("6000"); 
 
t4.setEditable(false); */
 
l5=new JLabel("Room No"); 
l5.setBounds(70,200,160,25);
 t5=new JTextField();
 t5.setBounds(240,200,60,25);
// t5.setText("2000");
// t5.setEditable(false); 
 
/*l6=new JLabel("No of Months"); 
l6.setBounds(360,200,100,25); 
t6=new JTextField(); 
t6.setBounds(520,200,40,25); */
 
l10=new JLabel("Floor No"); 
l10.setBounds(70,240,100,25);
 t10=new JTextField();
 t10.setBounds(240,240,60,25);
 //t10.setText("9000"); 
//t10.setEditable(false); 
 
 
l7=new JLabel("Total Rooms"); 
l7.setBounds(70,280,120,25); 
t7=new JTextField(); 
t7.setBounds(240,280,80,25); 
t7.setText("30");
 t7.setEditable(false);
 
l8=new JLabel("Filled Rooms"); 
l8.setBounds(70,330,120,25); 
t8=new JTextField(); 
t8.setBounds(240,330,80,25); 
 
l9=new JLabel("Vacancy Rooms"); 
l9.setBounds(360,320,80,25); 
t9=new JTextField();
 t9.setBounds(450,320,80,25); 

/*ld=new JLabel("Date"); 

ld.setBounds(500,120,100,25);
 td=new JTextField();
 td.setBounds(550,120,120,25); 
 
Calendar cal=Calendar.getInstance(); 
String dat=cal.get(Calendar.DATE)+"/"+mon[cal.get(Calendar.MONTH)]+"/"+cal. get(Calendar.YEAR);
 td.setText(""+dat); */
 
b1=new JButton("Save");
 b1.setBounds(200,450,100,25);
 b2=new JButton("Cancel");
 b2.setBounds(340,450,100,25); 
b3=new JButton("Clear"); 
b3.setBounds(480,450,100,25); 
//b4=new JButton("Clear"); 
//b4.setBounds(620,450,100,25); 


add(l1);
add(l2);
add(ch2);
add(l3);
//add(l4);
add(l5);
//add(l6);
add(l7);
add(l9);
add(l8);
add(l10);
add(t3);
//add(t4);
add(t5);
add(t10);
//add(t6);
add(t7);
add(t9);
add(t8); 
add(b1);
add(b2);
add(b3); 
//add(b4);

//add(ld);
//add(td); 
//td.setEditable(false); 
t8.addFocusListener(this); 
//t6.addFocusListener(this);
 b1.addActionListener(this);
 b2.addActionListener(this); 
b3.addActionListener(this);
//b4.addActionListener(this); 
setBackground(Color.cyan);
 setSize(800,600); 
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
if(f.getSource()==t8)  
{ 
  int b=Integer.parseInt(t7.getText())-Integer.parseInt(t8.getText());
  t9.setText(""+b);
  } 
/* else if(f.getSource()==t6) 
 {
 int res=Integer.parseInt(t3.getText())+Integer.parseInt(t4.getText())+Integer.parseInt(t5.getText())+Integer.parseInt(t10.getText());  
 int mon=Integer.parseInt(t6.getText());  
 res=(res*mon);   
t7.setText(""+res);    
 }*/
 } 
public void focusGained(FocusEvent fe) 
{   } 
 
 
 
public void actionPerformed(ActionEvent ae)
 {  
String sst=ae.getActionCommand(); 
 if(sst.equals("Save")) 
 {   
String id=ch2.getSelectedItem();
 String course=t3.getText();  
 String total_rooms=t7.getText();   
String filled_rooms=t8.getText();   
String vacancy_rooms=t9.getText();  
String floor=t10.getText();
String room_no=t5.getText();
 //String dat=td.getText(); 
 
  if(id.length()==0)
{   
 JOptionPane.showMessageDialog(null,"invalid ID");
}  
 else if(course.length()==0)
{   
 JOptionPane.showMessageDialog(null,"invalid course");
}  
 else if(total_rooms.length()==0)
{    
JOptionPane.showMessageDialog(null,"invalid rooms");
}  
 else   
{   
 int n=0;   
  if(n==0)    
 {         
try       
{     
 int an=Integer.parseInt(floor);                 
 n=1;       
}       
 catch(Exception e)      
 {       
JOptionPane.showMessageDialog(null,"Enter numbers only in floor field");    
   }          
 }   
  if(n==1)   
  {        
 try      
 {      
int an=Integer.parseInt(room_no);                  
n=2;      
 }     
   catch(Exception e)  
     {     
  JOptionPane.showMessageDialog(null,"Enter numbers only in room_no");  
     }       
 
    }    
if(n==2)   
 {  
   try 
 { 
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
con=DriverManager.getConnection("jdbc:odbc:acdsn");  
st=con.createStatement(); 
 st.executeUpdate("insert into room values("+id+",'"+course+"',"+room_no+","+floor+")");
  JOptionPane.showMessageDialog(null," Record insert sucessfully"); 
        con.close();
  st.close();
  dispose();     
    new Hostel();  
}  
 catch(Exception e)  
{ 
 System.out.println("SqlException Caught:"+e);  
       JOptionPane.showMessageDialog(null," sql Error is occured:   "); 

}
    }
   }
}  
 else if(sst.equals("Cancel")) 
 {   
dispose();
   new Hostel(); 
 }
  else if(sst.equals("Clear"))
  { 
  // t6.setText(""); 
   t7.setText("");  
  t8.setText("");  
 // t9.setText("");  
  ch.select(0); 
 }
 } 
 
public static void main(String s[])
 { 
 Room1 r1=new Room1();
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
 
 
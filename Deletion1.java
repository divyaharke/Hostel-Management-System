
import java.awt.*; 
import java.awt.event.*;
 import java.io.*; 
import javax.swing.*; 
import javax.swing.event.*;
import java.sql.*;
 import java.util.*; 
import java.lang.*; 
 
public class Deletion1 extends JFrame implements ActionListener
 { 
JLabel l1,l2,l3,l,l9,l10;
 JLabel an,as,ast; 
JTextField t3; 
//JTextField a1,a2,a3,a4;
 TextArea ta1;
 JButton b1,b2,b3; 
Choice ch1,ch2;
// String mon[]={"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct"," Nov","Dec"}; 
 
Connection con; 
Statement st; 
ResultSet rs;
PreparedStatement pst;
 
public Deletion1()
 {
 super("Student Info");
 setup(); 
addWindowListener(new WindowEventHandler());
 setVisible(true);
 } 

public void setup() 
{ 
setLayout(null);
 l1=new JLabel("Student Deletion"); 
l1.setFont(new Font("Monotype Corsiva",Font.ITALIC,25));
 l1.setBounds(280,50,200,25);  
 l1.setForeground(Color.red); 
 
setFont(new Font("Courier",Font.BOLD,15)); 
l2=new JLabel("Student ID"); 
l2.setBounds(70,120,100,25);
 //t2=new JTextField(); 
ch2=new Choice();
ch2.setBounds(240,120,180,25); 
ch2.add("");

l3=new JLabel("Student Name"); 
l3.setBounds(70,160,120,25);
 t3=new JTextField();
 t3.setBounds(240,160,200,25);

// l4=new JLabel("Father's Name"); 
//l4.setBounds(70,200,140,25);
// t4=new JTextField(); 
//t4.setBounds(240,200,200,25); 
//l5=new JLabel("Age");
// l5.setBounds(70,240,160,25); 
 
/*l6=new JLabel("Address");
 l6.setBounds(70,280,160,25); 
 
an=new JLabel("House No"); 
an.setBounds(240,300,160,25); 
a1=new JTextField();
 a1.setBounds(300,300,100,25); 
 
as=new JLabel("City"); 
as.setBounds(420,300,160,25);
 a2=new JTextField();
 a2.setBounds(470,300,100,25); 
 
ast=new JLabel("State");
 ast.setBounds(240,350,160,25); 
a4=new JTextField();
 a4.setBounds(470,300,100,25);


ch2=new Choice(); 
ch2.add(""); 
ch2.add("Andhra Pradesh");
ch2.add("Assam");
ch2.add("Bihar");
ch2.add("Chandigarh");
ch2.add("Chhattisgarh");
ch2.add("Dadar and Nagar Haveli");
ch2.add("Daman and Diu");
ch2.add("Delhi");
ch2.add("Goa");
ch2.add("Gujarat");
ch2.add("Haryana");
ch2.add("Jammu and Kashmir");
ch2.add("Jharkhand");
ch2.add("Karnataka");
ch2.add("Kerala");
ch2.add("Maharashtra");
ch2.add("Manipur");
ch2.add("Meghalaya");
ch2.add("Mizoram");
ch2.add("Nagaland");
ch2.add("Orissa");
ch2.add("Punjab");
ch2.add("Rajasthan");
ch2.add("Sikkim");
ch2.add("Tamil Nadu");
ch2.add("Tripura");
ch2.add("Uttaranchal");
ch2.add("Uttar Pradesh");
ch2.setBounds(300,350,100,25);

 
pin=new JLabel("Pincode");
 pin.setBounds(420,350,160,25); 
a3=new JTextField(); 
a3.setBounds(470,350,100,25); 
 
 
l7=new JLabel("Mobile"); 
l7.setBounds(70,400,160,25);
// l8=new JLabel("Gender");
 //l8.setBounds(500,240,200,25);
 t6=new JTextField();
 t6.setBounds(240,400,200,25); */
 
b1=new JButton("Delete");
 b1.setBounds(200,450,100,25); 
b2=new JButton("Cancel");
 b2.setBounds(340,450,100,25);
 b3=new JButton("Clear"); 
b3.setBounds(480,450,100,25); 
 
l=new JLabel("*"); 
l.setVisible(false);
 l10=new JLabel("* Invalid Values");
 l10.setBounds(20,30,200,25);
 l10.setVisible(false); 
 
/*ld=new JLabel("Date");
 ld.setBounds(500,120,100,25);
 t7=new JTextField();
 t7.setBounds(550,150,120,25); 
 
ch=new Choice();
 ch.add("Male"); 
ch.add("Female"); 
ch.setBounds(550,260,100,25); */
 
/*ag=new Choice(); 
ag.add(""); 
for(int i=0;i<=100;i++)  
ag.add(""+i); 
ag.setBounds(240,240,70,25); */
 
l9=new JLabel("Hostel Name");
l9.setBounds(70,200,140,25);
//l9.setBounds(500,180,100,25); 
ch1=new Choice(); 
ch1.add(""); 
ch1.add("Pratapgad(girls)");
 ch1.add("Rajgad(boys)"); 
ch1.add("Sajjangad(boys)"); 
ch1.add("Shivneri(boys)"); 
ch1.add("Jijau(girls)"); 
ch1.setBounds(240,210,150,25); 
 
/*Calendar cal=Calendar.getInstance(); 
String dat=cal.get(Calendar.DATE)+"/"+mon[cal.get(Calendar.MONTH)]+"/"+cal. get(Calendar.YEAR);
 t7.setText(""+dat);
 t7.setEditable(false); */
 
add(l);
 add(l1);
add(l2);
add(ch2);
add(l3);
//add(l4);
//add(l5);
//add(l6);
//add(t2); 
//add(t4);
add(t3);
//add(l7);
//add(t6);
//add(an);
//add(a1);
//add(as); 
//add(a2);
//add(a4);
//add(ast);

//add(a3);
//add(pin);
//add(ch2);
//add(ast);
 add(b1);
add(b2);
//add(l8);
//add(ch);
//add(ag);
add(l10);
add(ch1);
 add(l9);
//add(t7);
add(b3);
//add(ld); 
b1.addActionListener(this); 
b2.addActionListener(this);
 b3.addActionListener(this); 
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
 
public void actionPerformed(ActionEvent ae)
 { 
   String sst=ae.getActionCommand(); 
 if(sst.equals("Delete")) 
 {
  String id=ch2.getSelectedItem(); 
 String nam=t3.getText(); 
 //String fname=t4.getText();  
//String age=ag.getSelectedItem(); 
   String hname=ch1.getSelectedItem();
  //String gender=ch.getSelectedItem(); 
// String mob=t6.getText(); 
 //Double a=Double.parseDouble(id);
 // String da=t7.getText();  
//String no=a1.getText();
 // String str=a2.getText();
  //String pin=a3.getText();
//String sta=a4.getText();
//  String sta=ch2.getSelectedItem();   
     
try 
 {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
 con=DriverManager.getConnection("jdbc:odbc:acdsn");  
st=con.createStatement(); 
 //st.executeUpdate("insert into student values("+id+",'"+nam+"','"+hname+"',"+ mob+")");
  //st.executeUpdate("insert into address values("+id+",'"+no+"','"+str+"','"+sta+"',"+pin+")");  
//st.executeQuery("delete from student where("+id+",'"+nam+"','"+hname+"')");

//String nm=t3.getText();
String sql="delete from student where id=?";
pst=con.prepareStatement(sql);
pst.setString(1,id);
int val=pst.executeUpdate();
//st.executeUpdate(sql);

String sql1="delete from address where id=?";
pst=con.prepareStatement(sql1);
pst.setString(1,id);
int val1=pst.executeUpdate();



//st.executeUpdate("delete from address values("+id+",'"+no+"','"+str+"','"+sta+"')");

JOptionPane.showMessageDialog(null," Record deleted sucessfully");       
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
   StudentInfo si=new StudentInfo(); 
 }
  else if(sst.equals("Clear"))   
{
//    t2.setText(""); 
   t3.setText("");
//    t4.setText("");   
// t6.setText("");   
// a1.setText("");  
  //a2.setText(""); 
   //a3.setText("");
 }
} 
public static void main(String s[])
 {
  Deletion1 d1=new Deletion1(); 
}  
 
class WindowEventHandler extends WindowAdapter
 {
 public void windowClosing(WindowEvent we)
 {
  dispose(); 
 //new StudentInfo(); 
} 
}  
 } 
 
 

 
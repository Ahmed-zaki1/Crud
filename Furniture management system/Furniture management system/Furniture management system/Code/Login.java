import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
 JLabel log,pass;
 JTextField login;
 JPasswordField pw;
 JButton ok,cancel;
 JPanel p1,p2,p3;
 String password,user;
//Container c=getContentPane();  
 Login()
 {
     
    
  p1=new JPanel();
  p2=new JPanel();
  p3=new JPanel();

  log=new JLabel(" User ID:");
  pass=new JLabel("Enter Password:");
  


  login=new JTextField(20);
  //login.setText("operator");
  //login.disable();
  pw=new JPasswordField(20);
  
  ok=new JButton("OK",new ImageIcon("Images/login.png"));
  cancel=new JButton("CANCEL",new ImageIcon("Images/cancel.png"));

  p1.add(log);
  p1.add(login);
  p1.setLayout(new GridLayout(1,2));
  add(p1);
   
  p2.add(pass);
  p2.add(pw);
  p2.setLayout(new GridLayout(1,2));
  add(p2);

  p3.add(ok);
  p3.add(cancel);
  p3.setLayout(new GridLayout(1,2));
  add(p3);

//ok.setMnemonic(KeyEvent.VK_UP);
  setLayout(new FlowLayout());
//ok.setMnemonic(KeyEvent.VK_L);
ok.addActionListener(this);  
// ok.addActionListener(this);
  cancel.addActionListener(this);
  
//ok.setMnemonic(KeyEvent.VK_L);
  // c.setBackground(Color.GRAY);
  setSize(470,130);
  setVisible(true);
  setResizable(false);
  setTitle("Admin...");
 setLocation(180,260);
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
  public void actionPerformed(ActionEvent ae)
  { 
   String bu = ae.getActionCommand();
   if(bu == "OK")
    {
    /*	String pa = new String(pw.getPassword());
    	String na = login.getText();
     if((pa.compareTo("admin")==0)&& (na.compareTo("admin")==0))

         try
        {
        	
    Class.forName("org.gjt.mm.mysql.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tangent","root","");

 Statement stmt=con.createStatement();
      //Statement st = con.createStatement();
      String qry=("select * from login");
      ResultSet rs=stmt.executeQuery(qry);
      while(rs.next())
      {
        user = rs.getString("username");
        password = rs.getString("password");
      }
     con.close();
   }
   catch(Exception i)
   {
     System.out.println(i);
   }*/
	String user=login.getText();
	String pass= new String(pw.getPassword());
   if(user.compareTo("Indian")==0 && pass.compareTo("Furniture")==0)

    	{
    	  	
          JOptionPane.showMessageDialog(null,"Login Successfull","Message",JOptionPane.INFORMATION_MESSAGE);        
         new FurnitureMenu();
         dispose();
          
       //new passoper()= passoper.dispose();
        }
       else
       JOptionPane.showMessageDialog(null,"Incorrect Passward,Please Enter Correct Passward","Error Message",JOptionPane.ERROR_MESSAGE);
        pw.setText(" ");
    }
   
 /*
   String str2=pw.getText();
   
   
   if(ae.getActionCommand()=="OK")
  {
     if(str2.equals("admin"))
       {
        JOptionPane.showMessageDialog(null,"Login Successfull","Message",JOptionPane.INFORMATION_MESSAGE);        
         new SystemDetails();
         dispose();
       }
     else
        {
        JOptionPane.showMessageDialog(null,"Incorrect Passward,Please Enter Correct Passward","Error Message",JOptionPane.ERROR_MESSAGE);
        pw.setText("");
        }
    }
   */
   
   if(ae.getActionCommand()=="CANCEL")
     {
      dispose();
      }

  }
 

public static void main(String args[])
  {
   new Login();
   }
}    
   

  

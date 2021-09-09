import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class Furniture extends JFrame 
{
	public static String d,tt;//date
	public static String logd,logid;//Log
        Label[] infoLabel = new Label[16];
        TextField[] inputText=new TextField[16];
        Button save = new Button("Save");
        Button update=new Button("Update");
        Button print=new Button("Print");
        Button delete=new Button("Delete");
        Button cancel = new Button("Cancel");
        Button Addnew=new Button("Add New");
        Button first=new Button("First");
        Button previous=new Button("Previous");
	   Button next=new Button("Next");
	   Button last=new Button("Last");
	    Button reset =new Button("Reset");
	    Button OKButton =new Button("OK");
	    	Label lbl,lbl1,lbl2,lblexit;
	JLabel title;
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	
	//CONNECTION
	Connection c;
	ResultSet rs;
    Statement st,st1,st2;
    String str;
    public Furniture()
    {
    
    		//Connection Creation
		try
	   {
		//Class.forName("org.gjt.mm.mysql.Driver");
		//Class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
		Class.forName("com.mysql.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture","root","sonali");
		st=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
		st1=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		st2=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//System.out.println(c);
	   }
	   catch(Exception h1){System.out.println(h1);}
	   //Panel Back
	   p1.setBackground(new Color(249,180,134));
	   p2.setBackground(new Color(249,180,134));
	   p3.setBackground(new Color(249,180,134));
	   p4.setBackground(new Color(249,180,134));
	   
	   //Button Color
	   
	   save.setBackground(new Color(200,180,134));
	update.setBackground(new Color(200,180,134));
	 delete.setBackground(new Color(200,180,134));
   cancel.setBackground(new Color(200,180,134));
	   Addnew.setBackground(new Color(200,180,134));
	   first.setBackground(new Color(200,180,134));
	   next.setBackground(new Color(200,180,134));
	   last.setBackground(new Color(200,180,134));
	   previous.setBackground(new Color(200,180,134));
	   
    	//TextBox 
    	inputText[1] = new TextField(20);
	    inputText[2] = new TextField(20);
	    inputText[3] = new TextField(20);
	    inputText[4] = new TextField(20);
	    inputText[5] = new TextField(20);
	    inputText[6] = new TextField(20);
	    inputText[7] = new TextField(20);
	    inputText[8] = new TextField(20);
	    inputText[9] = new TextField(20);
	    inputText[10] = new TextField(20);
	    inputText[11] = new TextField(20);
	    inputText[12] = new TextField(20);
    	inputText[13] = new TextField(20);
	    inputText[14] = new TextField(20);
	    inputText[15] = new TextField(20);
}	   
	public static void main(String args[])throws Exception
	{
		new Furniture();	
	 
	    
	}
		
}

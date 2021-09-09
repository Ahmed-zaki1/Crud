import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

	 public class ReportMonthlyPayment extends Furniture implements ActionListener
	{
 		String h[]={"PID","EMPID","SALARY","DATE"};
		//Label l1;
                Label lblch;
		JScrollPane jpane;
		JTable t1=new JTable();
		Button b1,go;
		int k=0;
		Choice ch;
		TextField txtch;
		Statement st,st1,st2;
		ResultSet rs,rs1,rs2;
		Connection c;
		String record[][]={{""}};
		
		public ReportMonthlyPayment()
		{
			setLayout(null);
			setBackground( Color.DARK_GRAY );	
			
		 
			ch=new Choice();
			
			//Choice Add*******************
		 	for(int i=1;i<=12;i++)				
			 {
			  if(i<10)
			  	ch.addItem("0"+new Integer(i).toString());
			  else
			 		ch.addItem(new Integer(i).toString());	 
			 }			
			 //**********************************
			 lblch=new Label("Select Month:");
lblch.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,12));
			 go=new Button("Find");go.addActionListener(this);
			 //*********************************************
			 //button
			 b1=new Button("OK");
			b1.addActionListener(this);b1.setBackground(Color.gray);
			//***************
lblch.setBounds(150,30,100,30);
			ch.setBounds(280,35,200,20);
			go.setBounds(480,35,50,20);
			
			//jpane.setBounds(20,70,550,150);
			b1.setBounds(250,230,80,30);
			add(lblch);
			add(ch);
			add(go);
			//add(jpane,new BorderLayout().CENTER);
                        setLayout(new BorderLayout());  
			add(b1,BorderLayout.SOUTH);
			setSize(590,270);
			setLocation(300,200);
			setVisible(true);

			addWindowListener(new WindowAdapter()
        			 {
             			public void windowClosing(WindowEvent e)
             			 {
               				 dispose();
               		  }
        			  });
		}
		
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)	
			{
					dispose();
			}
			if(ae.getSource()==go)	
			{
					int cnt=0,i=0;
					try
					{	String monthsel=ch.getSelectedItem();
						Class.forName("org.gjt.mm.mysql.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Furniture","root","");
						Statement st=c.createStatement();
						String s="select PID,EID,Pdate from Payment";
						rs=st.executeQuery(s);					 			 
						while(rs.next())
						{
		String monthdb=rs.getString(3).substring(5,7);
						 	
							 if(monthdb.equals(monthsel))
							 {
						 		 cnt++;
							 }				
						}
				 
							String record1[][]=new String [cnt][4];
					 
		String str="select PID,EID,Basic,Inc,Pdate from Payment";
							rs=st.executeQuery(str);
								 i=0;
							while(rs.next())                                 
							{
							  
							 String d=rs.getString(5);
						 	 String monthdb=d.substring(5,7);
						
							 if(monthdb.equals(monthsel))
							 {	 
							 	record1[i][0]=rs.getString(1);
						 	   	record1[i][1]=rs.getString(2);
						 	   	float sal=rs.getFloat(3)+rs.getFloat(4);
				 			 	record1[i][2]=String.valueOf(sal);
				 			  	record1[i][3]=d;
				 			  	i++;
				 			  	
				 			 } 
						 	 
							}
					 	
						 
							 //****************************************************************/	
					record=record1;
					
					
					//Table
						t1=null;
t1=new JTable(record,h); 
t1.setBackground(new Color(211,220,148));t1.setSelectionBackground(new Color(113,232,232));
jpane=new JScrollPane(t1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
jpane.setBackground(new Color(211,220,148));
jpane.setBounds(20,70,550,150);
add(jpane,BorderLayout.CENTER);
}catch(Exception qe){System.out.println("Member Name Ex"+qe);}//Array out of bound exception

					 
				
			}
			
		}
		
		
		public static void main(String args[])
		{
			new ReportMonthlyPayment().show();
		}
}

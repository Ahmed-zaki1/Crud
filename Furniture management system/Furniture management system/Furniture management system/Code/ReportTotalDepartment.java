import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

	 public class ReportTotalDepartment extends Furniture implements ActionListener
	{
 		String h[]={"Department ID","Department Name"};
		int cnt=0,i=0;
		//Label l1;
		JScrollPane jpane;
		JTable t1;
		Button b1;
		int k=0;
		
		public ReportTotalDepartment()
		{
			setLayout(null);
			setBackground(Color.DARK_GRAY);	
			String record[][]={{""}};
			try{
			Class.forName("org.gjt.mm.mysql.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Furniture","root","");
			Statement st=c.createStatement();
			ResultSet rs;
			
			String str="select * from Department";
			rs=st.executeQuery(str);
			while(rs.next())
			{
				cnt++;
			}
			rs.close();//dc
			String record1[][]=new String [cnt][2];
			String s="select * from Department";
			rs=st.executeQuery(s);
			
			
			while(rs.next())
			{
				record1[i][0]=rs.getString("DeptID");
				record1[i][1]=rs.getString("Dname");
			 	i++;
			} 
			
			record=record1;
			}
			catch(Exception e){System.out.println("Main"+e);	}
			 //l1=new Label("Supplier Details");
                	//	 l1.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,10));
			 b1=new Button("OK");
			b1.addActionListener(this);b1.setBackground(Color.gray);
			t1=new JTable(record,h);t1.setBackground(Color.white);
jpane=new JScrollPane(t1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			jpane.setBackground(new Color(160,200,100));
				
				
			//l1.setBounds(220,30,800,30);
			jpane.setBounds(20,70,550,150);
			b1.setBounds(250,230,80,30);
			//add(l1);
                        setLayout(new BorderLayout());
			add(jpane,BorderLayout.CENTER);
			add(b1,BorderLayout.SOUTH);
			setSize(590,270);
			setLocation(300,200);
			setTitle("Department Details");
			setVisible(true);

			addWindowListener(new WindowAdapter()
        			 {
             			public void windowClosing(WindowEvent e)
             			 {
               				  setVisible(false);
               		     }
        			  });
		}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)	
			{
				 dispose();
				
			}
		}
		public static void main(String args[])
		{
			new ReportTotalDepartment().show();
		}
}

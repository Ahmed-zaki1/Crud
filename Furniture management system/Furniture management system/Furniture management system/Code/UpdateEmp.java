import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateEmp extends Furniture implements ActionListener, ItemListener
{
	public Choice desgn;
	Choice dept;
	public UpdateEmp()
	{ 
		//Title		
		title=new JLabel("Employee Details",JLabel.CENTER);
		title.setFont(new Font("Cambria", Font.BOLD, 14));  
		//Exit
		lbl=new Label(); 	lbl1=new Label(); 
		lbl2=new Label();    lblexit=new Label();

		infoLabel[1] = new Label("Department ID",Label.LEFT);
		infoLabel[2] = new Label("Name",Label.LEFT);
		infoLabel[3] = new Label("Address",Label.LEFT);
		infoLabel[4] = new Label("Phone no",Label.LEFT);
		infoLabel[5] = new Label("Designation",Label.LEFT);
		desgn=new Choice();
		Panel pc=new Panel(); pc.setLayout(new GridLayout(1,1));

		desgn.add("Cashier");  	
		desgn.add("Worker");  	
		desgn.add("Manager");  	
		pc.add(desgn);


		infoLabel[6] = new Label("Password",Label.LEFT);
		infoLabel[7] = new Label("MDate ",Label.LEFT);
		infoLabel[8] = new Label("Salary",Label.LEFT);
		infoLabel[9] = new Label("Employee ID",Label.LEFT);

		inputText[1] = new TextField(20);
		inputText[2] = new TextField(20);
		inputText[3] = new TextField(20);
		inputText[4] = new TextField(20);

		inputText[6] = new TextField(20);  
		inputText[7] = new TextField(20);
		inputText[8] = new TextField(20);
		dept=new Choice();
		try
		{
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select EID from Employee"); 
			while(rs.next())
				dept.add(rs.getString(1));
		}catch(Exception e){System.out.print(e);}
		dept.addItemListener(this);
		p1.setLayout(new GridLayout(1, 1, 1, 1));
		p1.add(title);



		//ExitButton
		p4.setLayout(new GridLayout(1, 3,5, 1));
		save.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		save.addActionListener(this);
		p4.add(save);save.setLabel("Update");
		reset.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		reset.addActionListener(this);
		p4.add(reset);
		OKButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		OKButton.addActionListener(this);
		p4.add(OKButton);

		//P2 Center
		p2.setLayout(new GridLayout(11, 2,0,3));

		p2.add(infoLabel[9]);
		p2.add(dept);
		p2.add(infoLabel[1]);
		p2.add(inputText[1]);
		p2.add(infoLabel[2]);
		p2.add(inputText[2]);
		p2.add(infoLabel[3]);
		p2.add(inputText[3]);
		p2.add(infoLabel[4]);
		p2.add(inputText[4]);
		p2.add(infoLabel[5]);
		p2.add(pc);
		p2.add(infoLabel[6]);
		p2.add(inputText[6]);
		p2.add(infoLabel[7]);
		p2.add(inputText[7]);
		p2.add(infoLabel[8]);
		p2.add(inputText[8]);
		p2.add(lbl);
		p2.add(lbl1);
		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),"Personal Details"));

		//Panel Arrangment
		p3.setLayout(new BorderLayout());
		p3.add(p1,BorderLayout.NORTH);
		p3.add(p2 ,BorderLayout.CENTER);
		p3.add(p4,BorderLayout.SOUTH );
		add(p3);
		addWindowListener(new WindowAdapter()
				{
				public void windowClosing(WindowEvent e)
				{
				dispose();
				}
				});

		//Window Arrangment
		setTitle("Upadte Employee");
		setSize(400,360);
		setLocation(320,200);
		setVisible(true);
		setResizable(false);
	}
	public void cleartext()
	{	
		for(int i=1;i<=7;i++)
		{
			inputText[i].setText("");
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		try{
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select DeptID,EName,Address,PhoneNo,Designation,Password,Mdate,salary from Employee where EID='"+ie.getItem()+"'");
			if(rs.next())
			{
				inputText[1].setText(rs.getString("DeptID"));
				inputText[2].setText(rs.getString("EName"));
				inputText[3].setText(rs.getString("Address"));
				inputText[4].setText(rs.getString("PhoneNo"));

				desgn.select(rs.getString("Designation"));
				inputText[6].setText(rs.getString("Password")); inputText[6].setEchoChar('#');
				inputText[7].setText(rs.getString("MDate"));inputText[7].setEditable(false);
				inputText[8].setText(rs.getString("Salary"));

			}


		}catch(Exception e){ e.printStackTrace() ;}

	} 



	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==OKButton)
		{
			setVisible(false);
		}
		if(ae.getSource()==reset)
		{
			cleartext();

		}
		if(ae.getSource()==save)
		{

			String name=inputText[2].getText();
			String addr=inputText[3].getText();
			String phno=inputText[4].getText();
			String pass=inputText[6].getText();
			String sal=inputText[8].getText();
			Validate v = new Validate();
			//validation for blank field
			if(v.checkBlank(name,this,"Name"))
				return;					

			if(v.checkBlank(addr,this,"Address"))
				return;

			if(v.checkBlank(phno,this,"Phone no"))	
				return;
			if(v.checkBlank(pass,this,"Password"))	
				return;
			if(v.checkBlank(sal,this,"Salary"))	
				return;
			//validation for text only
			if(v.checkOnlyText(name,this,"Name"))	
				return;		

			//validation for Numbers
			if(v.checkOnlyNumber(phno,this,"Phone No"))	
				return;
			if(v.checkOnlyNumber(sal,this,"Salary"))	
				return;
			
			
			if(phno.length()!=10)
			{
				JOptionPane.showMessageDialog( this,"invalid phone no","phno",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			


				try
				{
					String str1="Update Employee set EName='"+inputText[2].getText()+"',Address='"+inputText[3].getText()+"',PhoneNo='"+inputText[4].getText()+"',Designation='"+desgn.getSelectedItem()+"',DeptID='"+inputText[1].getText()+"',salary="+inputText[8].getText()+",Password='"+inputText[6].getText()+"',Mdate='"+inputText[7].getText()+"' where EID='"+dept.getSelectedItem()+"'";

					int a=st.executeUpdate(str1);
					if(a>0)
					{
						JOptionPane.showMessageDialog( this,"Record Successfully Updated","Update",JOptionPane.INFORMATION_MESSAGE);
						//clear text & generate new id
						cleartext();

					}
				}catch(Exception se){System.out.println(se);}




		}
	}



	public static void main(String args[])
	{
		new UpdateEmp();
	}
}

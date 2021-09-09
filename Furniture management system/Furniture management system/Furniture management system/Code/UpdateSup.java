import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateSup extends Furniture implements ActionListener, ItemListener
{
	public Choice SupID;

	public UpdateSup()
	{ 
		//Title		
		title=new JLabel("Supplier Details",JLabel.CENTER);
		title.setFont(new Font("Cambria", Font.BOLD, 14));  
		//Exit
		lbl=new Label(); 	lbl1=new Label(); 
		lbl2=new Label();    lblexit=new Label();

		infoLabel[1] = new Label("Supplier ID",Label.LEFT);
		infoLabel[2] = new Label("Name",Label.LEFT);
		infoLabel[3] = new Label("Address",Label.LEFT);
		infoLabel[4] = new Label("Phone no",Label.LEFT);

		SupID=new Choice();
		inputText[2] = new TextField(20);
		inputText[3] = new TextField(20);
		inputText[4] = new TextField(20);

		try
		{
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select SupplierID from Supplier"); 
			while(rs.next())
				SupID.add(rs.getString(1));
		}catch(Exception e){System.out.print(e);}
		SupID.addItemListener(this);
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
		p2.setLayout(new GridLayout(4,2,0,35));

		p2.add(infoLabel[1]);
		p2.add(SupID);
		p2.add(infoLabel[2]);
		p2.add(inputText[2]);
		p2.add(infoLabel[3]);
		p2.add(inputText[3]);
		p2.add(infoLabel[4]);
		p2.add(inputText[4]);



		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),"Personal Details"));


		//Panel Arrangment
		p3.setLayout(new BorderLayout());
		p3.add(p1,BorderLayout.NORTH);
		p3.add(p2 ,BorderLayout.CENTER);
		p3.add(p4,BorderLayout.SOUTH );
		add(p3);


		//**************************	

		addWindowListener(new WindowAdapter()
				{
				public void windowClosing(WindowEvent e)
				{
				dispose();
				}
				});

		//Window Arrangment
		setTitle("Upadte Supplier");
		setSize(400,300);
		setLocation(320,200);
		setVisible(true);

		setResizable(false);


	}


	public void cleartext()
	{	
		for(int i=2;i<=4;i++)
		{
			inputText[i].setText("");
		}
	}

	public void itemStateChanged(ItemEvent ie)
	{
		try{
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select SupplierID ,SuppName,Address,PhoneNo from Supplier where SupplierID='"+SupID.getSelectedItem()+"'");
			if(rs.next())
			{
				inputText[1].setText(rs.getString("SupplierID"));
				inputText[2].setText(rs.getString("SuppName"));
				inputText[3].setText(rs.getString("Address"));
				inputText[4].setText(rs.getString("PhoneNo"));
			}


		}catch(Exception e){ e.printStackTrace() ;}

	} 



	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==OKButton)
		{
			dispose();
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

			Validate v = new Validate();
			//validation for blank field
			if(v.checkBlank(name,this,"Name"))
				return;					

			if(v.checkBlank(addr,this,"Address"))
				return;

			if(v.checkBlank(phno,this,"Phone no"))	
				return;
			//validation for text only
			if(v.checkOnlyText(name,this,"Name"))	
				return;	

			//validation for Numbers
			if(v.checkOnlyNumber(phno,this,"Phone No"))	
				return;

			if(phno.length()!=10)
			{
				JOptionPane.showMessageDialog( this,"invalid phone no","phno",JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			try
			{
				String str1="Update Supplier set SuppName='"+inputText[2].getText()+"',Address='"+inputText[3].getText()+"',PhoneNo='"+inputText[4].getText()+"'  where SupplierID='"+SupID.getSelectedItem()+"'";

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
		new UpdateSup();
	}
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddSup extends Furniture implements ActionListener
{

	public AddSup()
	{ 
		//Title		
		title=new JLabel("Supplier Details",JLabel.CENTER);
		title.setFont(new Font("Cambria", Font.BOLD, 14));  
		//Exit
		lbl=new Label();lbl1=new Label(); 
		lbl2=new Label();lblexit=new Label();

		infoLabel[1] = new Label("Supplier ID",Label.LEFT);
		infoLabel[2] = new Label("Name",Label.LEFT);
		infoLabel[3] = new Label("Address",Label.LEFT);
		infoLabel[4] = new Label("Phone no",Label.LEFT);
		inputText[1] = new TextField(20);
		inputText[2] = new TextField(20);
		inputText[3] = new TextField(20);
		inputText[4] = new TextField(20);
		p1.setLayout(new GridLayout(1, 1, 1, 1));
		p1.add(title);
		//ExitButton
		p4.setLayout(new GridLayout(1,3,5, 1));
		save.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		save.addActionListener(this);
		p4.add(save);
		reset.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		reset.addActionListener(this);
		p4.add(reset);
		OKButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		OKButton.addActionListener(this);
		p4.add(OKButton);

		//P2 Center
		p2.setLayout(new GridLayout(4, 2 ,1,40));
		p2.add(infoLabel[1]);
		p2.add(inputText[1]);
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


		//Auto Genrating Book ID
		id();


		//Read Only**********************
		inputText[1].setEnabled(false);
		inputText[7].setEnabled(false);
		//**************************	

		addWindowListener(new WindowAdapter()
				{
				public void windowClosing(WindowEvent e)
				{
				dispose();
				}
				});

		//Window Arrangment
		setTitle("Add New Supplier");
		setSize(400,360);
		setLocation(320,200);
		setVisible(true);
		setResizable(false);


	}

	public void id()
	{

		//Auto Genrating Book ID
		try
		{	
			str="select * from SupplierDelete";
			rs=st.executeQuery(str);

			int cnt=0;
			while(rs.next())
			{
				cnt++;
			}
			if(cnt>0)
			{
				rs.first();
				inputText[1].setText(rs.getString("SupplierID"));	
				st.executeUpdate("delete from SupplierDelete where SupplierID='"+inputText[1].getText()+"'");	

			}

			else
			{
				str="select * from Supplier";
				rs=st.executeQuery(str);

				int rcount=0;
				while(rs.next())
				{
					rcount++;
				}

				if(rcount==0)
					inputText[1].setText("SUP00001");
				else
				{
					rcount=rcount+1;
					if(rcount>0)
						inputText[1].setText("SUP0000"+rcount);
					if(rcount>9)
						inputText[1].setText("SUP000"+rcount);
					if(rcount>99)
						inputText[1].setText("SUP00"+rcount);
					if(rcount>999)
						inputText[1].setText("SUP0"+rcount);
				}
			}
		}catch(Exception adde){System.out.println("AUTO NUMBERING"+adde);}

	}

	public void cleartext()
	{	
		for(int i=2;i<=4;i++)
		{
			inputText[i].setText("");
		}
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
				String str1="insert into Supplier values('"+inputText[1].getText()+"','"+inputText[2].getText()+"','"+inputText[3].getText()+"',"+inputText[4].getText()+")";

				int a=st.executeUpdate(str1);
				if(a>0)
				{
					JOptionPane.showMessageDialog( this,"Record Successfully Added","Save",JOptionPane.INFORMATION_MESSAGE);
					//clear text & generate new id
					cleartext();
					id();
				}
			}catch(Exception se){System.out.println(se);}




		}
	}



	public static void main(String args[])
	{
		new AddSup();
	}
}

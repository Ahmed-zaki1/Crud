import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddDept extends Furniture implements ActionListener
{
	public CheckboxGroup cbg;
	Choice dept;
	public AddDept()
	{ 
		//Title		
		title=new JLabel("Department Details",JLabel.CENTER);
		title.setFont(new Font("Cambria", Font.BOLD, 14));  
		//Exit
		lbl=new Label(); 	lbl1=new Label(); 
		lbl2=new Label();    lblexit=new Label();

		infoLabel[1] = new Label("Department ID",Label.LEFT);
		infoLabel[2] = new Label("Name",Label.LEFT);

		inputText[1] = new TextField(20);
		inputText[2] = new TextField(20);


		p1.setLayout(new GridLayout(1, 1, 1, 1));
		p1.add(title);



		//ExitButton
		p4.setLayout(new GridLayout(1, 3,5, 1));
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
		p2.setLayout(new FlowLayout());
		p2.add(infoLabel[1]);
		p2.add(inputText[1]);
		p2.add(infoLabel[2]);
		p2.add(inputText[2]);



		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),"Details"));


		//Panel Arrangment
		p3.setLayout(new BorderLayout());
		p3.add(p1,BorderLayout.NORTH);
		p3.add(p2 ,BorderLayout.CENTER);
		p3.add(p4,BorderLayout.SOUTH );
		add(p3);


		//Auto Genrating Book ID
		id();




		//************************

		//Read Only**********************
		inputText[1].setEnabled(false);

		//**************************	

		addWindowListener(new WindowAdapter()
				{
				public void windowClosing(WindowEvent e)
				{
				dispose();
				}
				});

		//Window Arrangment
		setTitle("Add New Depratment");
		setSize(230,260);
		setLocation(320,200);
		setVisible(true);

		setResizable(false);


	}

	public void id()
	{

		//Auto Genrating Book ID
		try
		{	
			str="select * from DepartmentDelete";
			rs=st.executeQuery(str);

			int cnt=0;
			while(rs.next())
			{
				cnt++;
			}
			if(cnt>0)
			{
				rs.first();
				inputText[1].setText(rs.getString("DeptID"));	
				st.executeUpdate("delete from DepartmentDelete where DeptID='"+inputText[1].getText()+"'");
			}

			else
			{
				str="select * from Department";
				rs=st.executeQuery(str);

				int rcount=0;
				while(rs.next())
				{
					rcount++;
				}

				if(rcount==0)
					inputText[1].setText("DEPT00001");
				else
				{
					rcount=rcount+1;
					if(rcount>0)
						inputText[1].setText("DEPT0000"+rcount);
					if(rcount>9)
						inputText[1].setText("DEPT000"+rcount);
					if(rcount>99)
						inputText[1].setText("DEPT00"+rcount);
					if(rcount>999)
						inputText[1].setText("DEPT0"+rcount);
				}
			}
		}catch(Exception adde){System.out.println("AUTO NUMBERING"+adde);}

	}

	public void cleartext()
	{	
		inputText[2].setText("");

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

			String dname=inputText[2].getText();

			Validate v = new Validate();
			//validation for blank field
			if(v.checkBlank(dname,this,infoLabel[2].getText()))
				return;
			if(v.checkOnlyText(dname,this,infoLabel[2].getText()))
				return;					

			try
			{
				String str1="insert into Department values('"+inputText[1].getText()+"','"+inputText[2].getText()+"')";

				int a=st.executeUpdate(str1);
				if(a>0)
				{
					JOptionPane.showMessageDialog( this,"Record Successfully Added","Save",JOptionPane.INFORMATION_MESSAGE);
					//clear text & generate new id
					cleartext();
					id();
				}
			}catch(Exception se){System.out.println("My Mistake");
				System.out.println(se);
			}




		}
	}



	public static void main(String args[])
	{
		new AddDept();
	}
}

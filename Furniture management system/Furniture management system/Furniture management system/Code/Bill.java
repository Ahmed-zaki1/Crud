import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Bill extends Furniture  implements ActionListener,ItemListener
{		
	static float total=0.0f;
	static int r;
	String h[]={"FurnitureID","FurnitureName","Company","Quantity","Rate"};
	JScrollPane jpane;
	JPanel cinfo,purdet;
	Button add,rem;
	Choice empid,itemno;
	JTable jt;
	public Bill()
	{
		try
		{ 	
		String	record[][]=new String [50][5];
		cinfo=new JPanel();
		purdet=new JPanel();
		jt=new JTable(record,h);
		jpane=new JScrollPane(jt,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jpane.setBackground(new Color(160,200,100));
		add=new Button("Add");add.addActionListener(this);
		rem=new Button("Remove");rem.addActionListener(this);
		//Title		
		//	title=new JLabel("Bill Details",JLabel.CENTER);
		//	title.setFont(new Font("Cambria", Font.BOLD, 14));  
		infoLabel[1] = new Label("Bill ID",Label.LEFT);
		infoLabel[2] = new Label("Date",Label.LEFT);
		infoLabel[3] = new Label("Cutomer Name",Label.LEFT);
		infoLabel[4] = new Label("Phone No",Label.LEFT);
		infoLabel[5] = new Label("Employee ID",Label.LEFT);
		infoLabel[6] = new Label("Item ID",Label.LEFT);
		infoLabel[7] = new Label("Total",Label.LEFT);
		infoLabel[8] = new Label("Qunatity",Label.LEFT);
		infoLabel[9] = new Label("Rate(in Rs-/)",Label.LEFT);
		inputText[1] = new TextField(10);
		inputText[2] = new TextField(10);
		inputText[3] = new TextField(20);
		inputText[4] = new TextField(15);
		empid=new Choice();
		try{
			st=c.createStatement();
			rs=st.executeQuery("select EID from Employee");
			while(rs.next())
				empid.add(rs.getString(1));
		}catch(Exception e){e.printStackTrace();}
		itemno=new Choice();
		itemno.addItemListener(this);
		try{
			st=c.createStatement();
			rs=st.executeQuery("select FurnitureID from FurnitureStock");
			while(rs.next())
				itemno.add(rs.getString(1));
		}catch(Exception e){e.printStackTrace();}

		inputText[7] = new TextField(5);
		inputText[7].setText(new Float(total).toString());	
		inputText[8] = new TextField(3);	
		inputText[9] = new TextField(10);	
		//p1.setLayout(new GridLayout(1, 1, 1, 1));
		//	p1.add(title);
		//ExitButton
		p4.setLayout(new FlowLayout());
		save.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		save.addActionListener(this);
		p4.add(save);
		print.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,14));
		print.addActionListener(this);
		p4.add(print);
		reset.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		reset.addActionListener(this);
		p4.add(reset);
		OKButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		OKButton.addActionListener(this);
		p4.add(OKButton);
		p4.add(infoLabel[7]);
		p4.add(inputText[7]);

		//cinfo Center
		cinfo.setLayout(new GridLayout(5, 2,0,3));
		cinfo.add(infoLabel[1]);
		cinfo.add(inputText[1]);
		cinfo.add(infoLabel[2]);
		cinfo.add(inputText[2]);
		cinfo.add(infoLabel[3]);
		cinfo.add(inputText[3]);
		cinfo.add(infoLabel[4]);
		cinfo.add(inputText[4]);
		cinfo.add(infoLabel[5]);
		cinfo.add(empid);

		p3.setLayout(new FlowLayout( ));
		p3.add(infoLabel[6]);
		p3.add(itemno);
		p3.add(infoLabel[8]);
		p3.add(inputText[8]);
		p3.add(infoLabel[9]);
		p3.add(inputText[9]);
		p3.add(add);
		p3.add(rem);
		//jt.setAutoCreateRowSorter(true);

		cinfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),"Cutomer Details"));
		purdet.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),"Purchease Details")); 

		//Panel Arrangment
		purdet.setLayout(new  BorderLayout());
		purdet.add(p3,BorderLayout.NORTH);
		purdet.add(jpane,BorderLayout.CENTER); 
		purdet.add(p4,BorderLayout.SOUTH);
		this.setLayout(new GridLayout(2,1));
		add(cinfo);
		add(purdet);
		//Auto Genrating Book ID
		id();
		//date/time*********************
		new Dt();

		inputText[2].setText(d);
		//************************
		//Read Only**********************
		inputText[1].setEnabled(false);
		inputText[2].setEnabled(false);
		//**************************	

		addWindowListener(new WindowAdapter()
				{
				public void windowClosing(WindowEvent e)
				{
				dispose();
				}
				});

		//Window Arrangment
		setTitle("Generate Bill");
		setSize(600,400);
		setLocation(320,200);
		setVisible(true);
		setResizable(false);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}

	public void id()
	{
		//Auto Genrating Book ID
		try
		{	


			str="select * from Bill";
			rs=st.executeQuery(str);
			int rcount=0;
			while(rs.next())
				rcount++;

			if(rcount==0)
				inputText[1].setText("BILL00001");
			else
			{
				rcount=rcount+1;
				if(rcount>0)
					inputText[1].setText("BILL0000"+rcount);
				if(rcount>9)
					inputText[1].setText("BILL000"+rcount);
				if(rcount>99)
					inputText[1].setText("BILL00"+rcount);
				if(rcount>999)
					inputText[1].setText("BILL0"+rcount);
			}

		}catch(Exception adde){System.out.println("AUTO NUMBERING"+adde);}

	}

	public void cleartext()
	{	
		for(int i=3;i<=7;i++)
		{
			if(i==5||i==6)
				continue;	
			inputText[i].setText("");
		}
	}
	         public void itemStateChanged(ItemEvent ie)
                {
                        try
                        {	
				st.close();
				rs.close();
				st=c.createStatement();
                                rs=st.executeQuery("select UnitPrice from FurnitureStock where FurnitureID='"+ie.getItem()+"'");
                                while(rs.next())
                                {
                                        inputText[9].setText(rs.getString(1));
                                }
                        }
                        catch(Exception e1)
                        {
                                e1.printStackTrace();
                        }
                }


	public void actionPerformed(ActionEvent ae)
	{

		if(ae.getSource()==add)
		{
			String BillID=inputText[1].getText();
			String date=inputText[2].getText();
			String name=inputText[3].getText();	
			String PhoneNo=inputText[4].getText();
			String EmpID=empid.getSelectedItem();
			String Quantity=inputText[8].getText();
			String Rate=inputText[9].getText();	
			Validate v= new Validate();
			if(v.checkBlank(Quantity,this,"Quantity"))
				return;
			if(v.checkBlank(Rate,this,"Rate"))
				return;
			if(v.checkOnlyNumber(Quantity,this,"Quantity"))
				return;
			if(v.checkOnlyNumber(Rate,this,"Quantity"))
				return;
			String FurnitureID=itemno.getSelectedItem();
			try{

				st=c.createStatement();
				rs=st.executeQuery("select * from FurnitureStock where FurnitureID='"+FurnitureID+"'");
				rs.next();
				if(Integer.parseInt(Rate)+20<Integer.parseInt(rs.getString("UnitPrice")))
				{
					JOptionPane.showMessageDialog(this,"Rate is Low!");
					return;
				}
                                if(Integer.parseInt(Quantity)>Integer.parseInt(rs.getString("Qty")))
                                {
                                        JOptionPane.showMessageDialog(this,"Quantity Under Flow!!");
                                        return;
                                }
	

				jt.setValueAt(FurnitureID,r,0);//clothId
				jt.setValueAt(rs.getString("FurnitureName"),r,1);//name of cloth
				jt.setValueAt(rs.getString("CompanyNm"),r,2);//compnay
				jt.setValueAt(Quantity,r,3);//qty
				jt.setValueAt(Rate,r,4);//rate
				r++;
				total=total+Integer.parseInt(Quantity)*Float.parseFloat(Rate);
				inputText[7].setText(""+total);
				int n=st.executeUpdate("insert into Purchase values('"+BillID+"','"+FurnitureID+"',"+Quantity+","+Rate+")");
				if(n>0)
					JOptionPane.showMessageDialog(this,"Item Inserted in Purchease Master");
			}catch(Exception ex){ex.printStackTrace();}
		}
		if(ae.getSource()==rem)
		{
			int rd=jt.getSelectedRow();
			if(r==0)
			{
				JOptionPane.showMessageDialog(this,"Please select Items!");
				return;
			}
			String FurnitureId,qty,rate;
			FurnitureId=jt.getValueAt(rd,0).toString();

			Validate v=new Validate();

			qty=jt.getValueAt(rd,3).toString();
			rate=jt.getValueAt(rd,4).toString();
			if(v.checkOnlyNumber(qty,this,"Quantity"))
				return;
			if(v.checkOnlyNumber(rate,this,"Quantity"))
				return;
			if(v.checkBlank(qty,this,"Quantity"))
				return;
			if(v.checkBlank(rate,this,"Rate"))
				return;

			total-=Float.parseFloat(jt.getValueAt(rd,3).toString())* Float.parseFloat(jt.getValueAt(rd,4).toString());					
			inputText[7].setText(""+total);
			String BillID=inputText[1].getText();
			try
			{
				int d=st.executeUpdate("delete from Purchase where BillID='"+BillID+"' and FurnitureID='"+FurnitureId+"'and Qty="+qty+" and Rate="+rate);
				if(d>0)
					JOptionPane.showMessageDialog(this,"Item Removed From Purchease Master");	
			}catch(Exception	ex){ex.printStackTrace();}
			r--;
			for(int c=0;c<5;c++)
				jt.setValueAt("",rd,c);	
		}	
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
			String BillID=inputText[1].getText();
			String date=inputText[2].getText();
			String cname=inputText[3].getText();
			String phno=inputText[4].getText();
			String tot=inputText[7].getText();
			String EID=empid.getSelectedItem().toString(); 

			Validate v= new Validate();
			//validation for blank field
			if(v.checkBlank(cname,this,"Name"))
				return;					

			if(v.checkBlank(phno,this,"Address"))
				return;

			if(tot.equals("0.0"))	
			{
				JOptionPane.showMessageDialog(this,"Total is Zero!");
				return;
			}		
			if(r==0)	
			{
				JOptionPane.showMessageDialog(this,"No Item Purcheased!");
				return;
			}	
			//validation for text only
			if(v.checkOnlyText(cname,this,"Name"))	
				return;		

			//validation for Numbers
			if(v.checkOnlyNumber(phno,this,"Phone No"))	
				return;
			try
			{
				int d=0;
				while(jt.getValueAt(d,3)!=null)
				{
					//System.out.print("  Cloth Qty:  "+jt.getValueAt(d,3));System.out.print(" \n Cloth Id : "+jt.getValueAt(d,0));						
					//System.out.println("update ClothStock set Qty = Qty - "+jt.getValueAt(d,3)+" where ClothID =  '"+jt.getValueAt(d,0)+"'");
					int no=st.executeUpdate("update FurnitureStock set Qty=qty-"+jt.getValueAt(d,3)+" where FurnitureID='"+jt.getValueAt(d,0)+"'");
					if(no==0)
					{
						JOptionPane.showMessageDialog(this,"Quantity Underflow");
						return;
					}
					d++;

				}
				String str1="insert into Bill values('"+BillID+"','"+date+"','"+cname+"','"+phno+"','"+tot+"','"+EID+"')";

				int a=st.executeUpdate(str1);
				if(a>0)
				{
					JOptionPane.showMessageDialog( this,"Record Successfully inserted in Bill Master" ,"Save",JOptionPane.INFORMATION_MESSAGE);
					//clear text & generate new id
					cleartext();
					id();
					for(int rd=0;rd<r;rd++)
						for(int c=0;c<5;c++)
							jt.setValueAt("",rd,c);
					r=0;

				}
			}catch(Exception se){System.out.println(se);} 




		}
		/*public void itemStateChanged(ItemEvent ie)
		{
			try
			{
				Statement s =c.createStatement();
				ResultSet rs=s.executeQuery("select UnitPrice from FurnitureStock where FurnitureID='"+itemno.getItem().toString()+"'");
				while(rs.next())
				{
					inputText[6].setText(rs.getString(1));
				}
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}*/
		
	
}



	public static void main(String args[])throws Exception
	{
		new Bill();
	}
}

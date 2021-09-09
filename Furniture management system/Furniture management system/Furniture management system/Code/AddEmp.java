import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class AddEmp extends Furniture  implements ActionListener
{
	public CheckboxGroup cbg;
		Choice dept;
		public AddEmp()
		{ 
			//Title		
			title=new JLabel("Employee Details",JLabel.CENTER);
				title.setFont(new Font("Cambria", Font.BOLD, 14));  
				//Exit
				lbl=new Label(); 	lbl1=new Label(); 
				lbl2=new Label();    lblexit=new Label();
				
				infoLabel[1] = new Label("Employee ID",Label.LEFT);
				infoLabel[2] = new Label("Name",Label.LEFT);
				infoLabel[3] = new Label("Address",Label.LEFT);
				infoLabel[4] = new Label("Phone no",Label.LEFT);
				infoLabel[5] = new Label("Designation",Label.LEFT);
				cbg=new CheckboxGroup();
				Panel pc=new Panel();pc.setLayout(new GridLayout(1,3));
				
				Checkbox cash=new Checkbox("Cashier",cbg,false);  	
				Checkbox work=new Checkbox("Worker",cbg,true);  	
				Checkbox mang=new Checkbox("Manager",cbg,false);  	
				pc.add(work);
				pc.add(cash);
				pc.add(mang);		
				
				infoLabel[6] = new Label("Password",Label.LEFT);
				infoLabel[7] = new Label("MDate ",Label.LEFT);
				infoLabel[8] = new Label("Salary",Label.LEFT);
				infoLabel[9] = new Label("Department ID",Label.LEFT);
				
				inputText[1] = new TextField(20);
				inputText[2] = new TextField(20);
				inputText[3] = new TextField(20);
				inputText[4] = new TextField(20);
				
				inputText[6] = new TextField(20); inputText[6].setEchoChar('#');
				inputText[7] = new TextField(20);
				inputText[8] = new TextField(20);
				dept=new Choice();
						try
						{
						Statement s=c.createStatement();
						ResultSet rs=s.executeQuery("select DeptID from Department"); 
						while(rs.next())
						dept.add(rs.getString(1));
						}catch(Exception e){System.out.print(e);}
				
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
				p2.setLayout(new GridLayout(11, 2,0,3));
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
				p2.add(infoLabel[9]);
				p2.add(dept);
				
				
				
				p2.add(lbl);
				p2.add(lbl1);
				
				
				p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),"Personal Details"));
				
				//Panel Arrangment
				p3.setLayout(new BorderLayout());
				p3.add(p1,BorderLayout.NORTH);
				p3.add(p2 ,BorderLayout.CENTER);
				p3.add(p4,BorderLayout.SOUTH );
				add(p3);
				
				//Auto Genrating Book ID
				id();
				//date/time*********************
				Dt e= new Dt();
				String s= e.Get();
				inputText[7].setText(s);
				//************************
				
				//Read Only**********************
				inputText[1].setEnabled(false);
				inputText[7].setEnabled(true);
				//**************************	
				
				addWindowListener(new WindowAdapter()
						{
						public void windowClosing(WindowEvent e)
						{
						dispose();
						}
						});
			
				//Window Arrangment
				setTitle("Add New Employee");
				setSize(350,350);
				setLocation(150,150);
				setVisible(true);
				
				setResizable(false);
				
				
		}
	
		public void id()
		{
			
				//Auto Genrating Book ID
				try
				  {	
				  str="select * from EmployeeDelete";
				  rs=st.executeQuery(str);
				  
				  int cnt=0;
				  while(rs.next())
				  {
				  cnt++;
				  }
				  if(cnt>0)
				  {
				  rs.first();
				  inputText[1].setText(rs.getString("EID"));
				  
				  }
				  
				  else
				  {
				  str="select * from Employee";
				  rs=st.executeQuery(str);
				  
				  int rcount=0;
				  while(rs.next())
				  {
				  rcount++;
				  }
				  
				  if(rcount==0)
				  inputText[1].setText("EMP00001");
				  else
				  {
				  rcount=rcount+1;
				  if(rcount>0)
				  inputText[1].setText("EMP0000"+rcount);
				  if(rcount>9)
				  inputText[1].setText("EMP000"+rcount);
				  if(rcount>99)
				  inputText[1].setText("EMP00"+rcount);
				  if(rcount>999)
				  inputText[1].setText("EMP0"+rcount);
				  }
				  }
				  }catch(Exception adde){System.out.println("AUTO NUMBERING"+adde);}
				
		}
	
		public void cleartext()
		{	
			for(int i=2;i<=8;i++)
			{
				if(i==5||i==7)
					continue;	
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
						String str1="insert into Employee values('"+inputText[1].getText()+"','"+inputText[2].getText()+"','"+inputText[3].getText()+"',"+inputText[4].getText()+",'"+cbg.getSelectedCheckbox().getLabel()+"','"+dept.getSelectedItem()+"',"+inputText[8].getText()+",'"+inputText[6].getText()+"','"+inputText[7].getText()+"')";
							
							int a=st.executeUpdate(str1);
							if(a>0)
							{
								JOptionPane.showMessageDialog( this,"Record Successfully Added","Save",JOptionPane.INFORMATION_MESSAGE);
									st.executeUpdate("delete from EmployeeDelete where EID='"+inputText[1].getText()+"'");
									//clear text & generate new id
									cleartext();
									id();
									Dt e= new Dt();
									String s= e.Get();
									inputText[7].setText(s);
							}
					}catch(Exception se){System.out.println(se);}
			}
		}
	public static void main(String args[])
	{
		new AddEmp();
	}
}

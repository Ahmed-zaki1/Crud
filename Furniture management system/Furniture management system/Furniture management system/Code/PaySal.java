import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class PaySal extends Furniture implements ActionListener, ItemListener
 {
 	Choice emp;
	public PaySal()
	{ 
		//Title	
		title=new JLabel("Payment Details",JLabel.CENTER);
		title.setFont(new Font("Cambria", Font.BOLD, 14));  
		//Exit
		lbl=new Label(); 	lbl1=new Label(); 
 		lbl2=new Label();    lblexit=new Label();
 
   	infoLabel[1] = new Label("EID",Label.LEFT);
       	infoLabel[2] = new Label("Name",Label.LEFT);
       	infoLabel[3] = new Label("Basic",Label.LEFT);
       	infoLabel[4] = new Label("Incentive",Label.LEFT);
       	infoLabel[5] = new Label("Toatl Salary",Label.LEFT);
        infoLabel[6] = new Label("MDate",Label.LEFT);
    infoLabel[7] = new Label("Payment ID",Label.LEFT);
    
 	emp=new Choice();	
	    inputText[2] = new TextField(20);
	    inputText[3] = new TextField(20);
	    inputText[4] = new TextField(20);
	    inputText[6] = new TextField(20);  inputText[6].setEditable(true);
   	inputText[7] = new TextField(20);  inputText[7].setEditable(false);
	    id();
	    
		try
		{
			String str1="Select EID from Employee";
       		rs=st.executeQuery(str1);
			while(rs.next())
			{
				emp.add(rs.getString(1));
	        }
		}catch(Exception se){System.out.println(se);}
	  	emp.addItemListener(this);
		p1.setLayout(new GridLayout(1, 1, 1, 1));
		p1.add(title);
	
		//ExitButton
		p4.setLayout(new GridLayout(1, 3,5, 1));
		save.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		save.addActionListener(this);
		p4.add(save);save.setLabel("Update");
		reset.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		reset.addActionListener(this);
		p4.add(reset);reset.setLabel("Cal");
		OKButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		OKButton.addActionListener(this);
		p4.add(OKButton);
	 
		 //P2 Center
	 	p2.setLayout(new GridLayout(7,2,0,3));
	 	
	    p2.add(infoLabel[7]);
        p2.add(inputText[7]);
	    p2.add(infoLabel[1]);
        p2.add(emp);
	    p2.add(infoLabel[2]);
        p2.add(inputText[2]);
	    p2.add(infoLabel[3]);
        p2.add(inputText[3]);
	    p2.add(infoLabel[4]);
        p2.add(inputText[4]);
	    p2.add(infoLabel[5]);
        p2.add(inputText[5]);
	    p2.add(infoLabel[6]);
	    p2.add(inputText[6]);
    
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
                setTitle("Pay Salary");
                setSize(400,360);
                setLocation(320,200);
                setVisible(true);
	setResizable(false);
//auto generating id
id();
Dt e= new Dt();
String s= e.Get();

inputText[6].setText(s);inputText[6].setEditable(true);
	}
	public void id()
	{
	//Auto Genrating Book ID
		try
		{	
		str="select * from Payment";
			rs=st.executeQuery(str);
		 	int rcount=0;
			while(rs.next())
			{
		 		rcount++;
			}
				
			if(rcount==0)
				inputText[7].setText("PAY00001");
			else
			{
				rcount=rcount+1;
				if(rcount>0)
		  			inputText[7].setText("PAY0000"+rcount);
				if(rcount>9)
					inputText[7].setText("PAY000"+rcount);
				if(rcount>99)
					inputText[7].setText("PAY00"+rcount);
				if(rcount>999)
					inputText[7].setText("PAY0"+rcount);
			}
		}
		catch(Exception adde){System.out.println("AUTO NUMBERING"+adde);}
	}

	public void cleartext()
	{	
		for(int i=2;i<=5;i++)
		{
			inputText[i].setText("");
		}
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		try{
			Statement s=c.createStatement();
ResultSet rs=s.executeQuery("select EName,salary,Designation from Employee where EID='"+ie.getItem()+"'");
			if(rs.next())
			{
			 inputText[2].setText(rs.getString("EName"));
			 inputText[3].setText(rs.getString("salary"));
			 if(rs.getString("Designation").equals("Worker"));
JOptionPane.showMessageDialog(this,"To Calculate Incentive Press Cal Button");
			   
		  	 inputText[4].setText("0.0"); 
			 inputText[5].setText(inputText[3].getText());
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
				 try{
				 	
rs=st.executeQuery("select TotalAmount from Bill where EID='"+emp.getSelectedItem()+"'");
					if(rs.next())
					{
float inc=Float.parseFloat(rs.getString(1))*0.02f;
inputText[4].setText(String.valueOf(inc));
float basic=Float.parseFloat(inputText[3].getText());
inputText[5].setText(String.valueOf(basic+inc));
					}
				}catch(Exception ex){ex.printStackTrace();}
				}
				if(ae.getSource()==save)
				{
						
					String EID=emp.getSelectedItem();
					String basic=inputText[3].getText();
float ba=Float.parseFloat(basic);
					String inc=inputText[4].getText();
float i =Float.parseFloat(inc);
					//date date=inputText[6].getText();
					Validate v = new Validate();
						//validation for blank field
					if(v.checkBlank(basic,this,"Basic"))
								return;					
						
					if(v.checkBlank(inc,this,"Incentive"))
						return;
					//validation for Numbers
						if(v.checkOnlyNumber(basic,this,"Basic"))	
							return;
						if(v.checkOnlyNumber(inc,this,"Incentive"))	
							return;	
					
						try
						{
String str1="insert into Payment values('"+inputText[7].getText()+"','"+EID+"','"+ba+"','"+i+"','"+inputText[6].getText()+"')";
 
		             		int a=st.executeUpdate(str1);
							if(a>0)
							{
JOptionPane.showMessageDialog( this,"Record Successfully inserted!","Update",JOptionPane.INFORMATION_MESSAGE);
		   				  	 //clear text & generate new id
							 cleartext();
							}
						}
						catch(Exception se){System.out.println(se);}
				}
			}
			
	public static void main(String args[])
    {
                new PaySal();
    }
}

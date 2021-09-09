import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateAddFurSto extends Furniture implements ActionListener ,ItemListener
 {
  	Choice CNo;
	public UpdateAddFurSto()
	{ 
		CNo = new Choice();
	 
		
		//Title		
		title=new JLabel("Stock Details",JLabel.CENTER);
		title.setFont(new Font("Cambria", Font.BOLD, 14));  
		//Exit
		lbl=new Label(); 	lbl1=new Label(); 
 		lbl2=new Label();    lblexit=new Label();
 
	   	infoLabel[1] = new Label("Furniture Stock ID",Label.LEFT);
       	infoLabel[2] = new Label("Name",Label.LEFT);
       	infoLabel[3] = new Label("Company Name",Label.LEFT);
       	infoLabel[4] = new Label("Description",Label.LEFT);
       	infoLabel[5] = new Label("Type",Label.LEFT);
        infoLabel[6] = new Label("Quantity",Label.LEFT);
	   	infoLabel[7] = new Label("Unit Price",Label.LEFT);
	 

	    
	    inputText[2] = new TextField(20);
	    inputText[3] = new TextField(20);
	    inputText[4] = new TextField(20);
	    inputText[5] = new TextField(20);
	    inputText[6] = new TextField(20);  
	    inputText[7] = new TextField(20);
	 	try
		{
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select FurnitureID from FurnitureStock"); 
			while(rs.next())
				CNo.add(rs.getString(1));
		}catch(Exception e){System.out.print(e);}
	  	CNo.addItemListener(this);
	  	
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
	 	p2.setLayout(new GridLayout(7, 2,0,10));
	    p2.add(infoLabel[1]);
        p2.add(CNo);
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
	    p2.add(infoLabel[7]);
        p2.add(inputText[7]);
        
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
                setTitle("Add New Stock");
                setSize(400,360);
                setLocation(320,200);
                setVisible(true);
             	
				setResizable(false);
	

	}
 	public void itemStateChanged(ItemEvent ie)
	{
		try{
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from FurnitureStock where FurnitureID='"+ie.getItem()+"'");
			if(rs.next())
			{
				for(int c=2;c<=7;c++)
					 inputText[c].setText(rs.getString(c));
			}
			 
			 
		   }catch(Exception e){ e.printStackTrace() ;}
	
	} 
	
	public void cleartext()
	{	
		for(int i=2;i<=7;i++)
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
					String comname=inputText[3].getText();
					String desc=inputText[4].getText();
					String type=inputText[5].getText();
					String qty=inputText[6].getText();
					String up=inputText[7].getText();
						Validate v = new Validate();
						//validation for blank field
					if(v.checkBlank(name,this,infoLabel[2].getText()))
								return;					
						
					if(v.checkBlank(comname,this,infoLabel[3].getText()))
						return;
						
					if(v.checkBlank(desc,this,infoLabel[4].getText()))	
						return;
					if(v.checkBlank(type,this,infoLabel[5].getText()))	
						return;
					if(v.checkBlank(qty,this,infoLabel[6].getText()))	
						return;
					if(v.checkBlank(up,this,infoLabel[7].getText()))	
						return;
				 
					//validation for only text
                                        if(v.checkOnlyText(name,this,infoLabel[2].getText()))
                                                                return;                           

                                        if(v.checkOnlyText(comname,this,infoLabel[3].getText()))
                                                return;

                                        if(v.checkOnlyText(desc,this,infoLabel[4].getText()))
                                                return;
                                        if(v.checkOnlyText(type,this,infoLabel[5].getText()))
                                                return;

				 
					
					
					//validation for Numbers
						if(v.checkOnlyNumber(qty,this,"Quantity"))	
							return;
						if(v.checkOnlyNumber(up,this,"Unit Price"))	
							return;	
					 
					
						try
						{
							
String str1="Update FurnitureStock set FurnitureName='"+inputText[2].getText()+"',CompanyNm='"+inputText[3].getText()+"',Description='"+inputText[4].getText()+"',Type='"+inputText[5].getText()+"',Qty="+inputText[6].getText()+",UnitPrice="+inputText[7].getText()+" where FurnitureID='"+CNo.getSelectedItem()+"'";
		
		             		int a=st.executeUpdate(str1);
							if(a>0)
							{
JOptionPane.showMessageDialog( this,"Record Successfully Updated","Update",JOptionPane.INFORMATION_MESSAGE);
		   				  	 //clear text  
							 cleartext();
						 	  
						}
					}catch(Exception se){System.out.println(se);}
					
					
					
					
				}
			}
			
			

	public static void main(String args[])
    {
                new UpdateAddFurSto();
    }
}

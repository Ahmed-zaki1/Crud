import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class DeleteFurSto extends Furniture implements ActionListener ,ItemListener
 {
  	Choice CNo;
	public DeleteFurSto()
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
		p4.add(save);save.setLabel("Delete");
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
                setTitle("Delete Furniture");
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
					try
					{
String str1="delete from FurnitureStock where FurnitureID='"+CNo.getSelectedItem()+"'";
		           		int a=st.executeUpdate(str1);
						if(a>0)
						{
JOptionPane.showMessageDialog( this,"Record Successfully Deleted","Delete",JOptionPane.INFORMATION_MESSAGE);
		   				 	 //clear text  
							 cleartext();
st.executeUpdate("insert into FurnitureStockDelete values('"+CNo.getSelectedItem()+"')");
							  
						}
					}catch(Exception se){System.out.println(se);}
					
					try
					{
						CNo.removeAll();
						Statement s=c.createStatement();
				ResultSet rs=s.executeQuery("select FurnitureID from FurnitureStock"); 
						while(rs.next())
							CNo.add(rs.getString(1));
					}catch(Exception e){System.out.print(e);}	
					
					
				}
			}
			
			

	public static void main(String args[])
    {
                new DeleteFurSto();
    }
}

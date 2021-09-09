import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class DeleteSup extends Furniture implements ActionListener, ItemListener
 {
  
 	Choice SupID;
	public DeleteSup()
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
		p4.add(save);save.setLabel("Delete");
		reset.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		reset.addActionListener(this);
		p4.add(reset);
		OKButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		OKButton.addActionListener(this);
		p4.add(OKButton);
	 
		 //P2 Center
	 	p2.setLayout(new GridLayout(4, 2,0,35));
	 	
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
                setTitle("Delete Supplier");
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
ResultSet rs=s.executeQuery("select SuppName,Address,PhoneNo from Supplier where SupplierID='"+SupID.getSelectedItem()+"'");
			if(rs.next())
			{
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
String str1="Delete from Supplier where SupplierID='"+SupID.getSelectedItem()+"'";
 
		             		int a=st.executeUpdate(str1);
							if(a>0)
							{
JOptionPane.showMessageDialog( this,"Record Successfully Deleted","Delete",JOptionPane.INFORMATION_MESSAGE);
		   				  	 //clear text & generate new id
							   cleartext();
st.executeUpdate("insert into SupplierDelete values('"+SupID.getSelectedItem()+"')");
						 	 
						}
					}catch(Exception se){System.out.println(se);}
					
					
					try
					{
						SupID.removeAll();		
						Statement s=c.createStatement();
ResultSet rs=s.executeQuery("select SupplierID from Supplier"); 
						while(rs.next())
							SupID.add(rs.getString(1));
					}catch(Exception e){System.out.print(e);}	
					
				}
			}
			
			

	public static void main(String args[])
    {
                new DeleteSup();
    }
}

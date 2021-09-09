import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateDept extends Furniture implements ActionListener ,ItemListener
 {
 	public CheckboxGroup cbg;
 	Choice dept;
	public UpdateDept()
	{ 
		//Title		
		title=new JLabel("Department Details",JLabel.CENTER);
		title.setFont(new Font("Cambria", Font.BOLD, 14));  
		//Exit
		lbl=new Label(); 	lbl1=new Label(); 
 		lbl2=new Label();    lblexit=new Label();
 
	   	infoLabel[1] = new Label("Department ID",Label.LEFT);
       	infoLabel[2] = new Label("Name",Label.LEFT);
       	
	    dept=new Choice();
	    dept.addItemListener(this);
	   	try
		{
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select DeptID from Department"); 
			while(rs.next())
				dept.add(rs.getString(1));
		}catch(Exception e){System.out.print(e);}
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
	    p2.add(dept);
       
	    p2.add(infoLabel[2]);
        p2.add(inputText[2]);
 
   	 
 
p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),"Details"));
	     
	     
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
                setTitle("Update Depratment");
                setSize(230,260);
                setLocation(320,200);
                setVisible(true);
             	
				setResizable(false);
	

	}
	
 	public void itemStateChanged(ItemEvent ie)
	{
		try{
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select Dname from Department where DeptID='"+ie.getItem()+"'");
			if(rs.next())
			{
		 	 inputText[2].setText(rs.getString(1));
			}
			 
			 
		   }catch(Exception e){ e.printStackTrace() ;}
	
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
			
					//validation for only text
                                        if(v.checkOnlyText(dname,this,infoLabel[2].getText()))
                                                                return;      					
					
						try
						{
String str1="update Department set Dname='"+inputText[2].getText()+"' where  DeptID='"+dept.getSelectedItem()+"'";
		
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
                new UpdateDept();
    }
}

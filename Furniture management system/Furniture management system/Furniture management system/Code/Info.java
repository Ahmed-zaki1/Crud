import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
//import java.applet.Applet;

public class Info extends JFrame implements ActionListener
{
    boolean bflag=false;	
	Connection con;
	Statement stmt;
	int attempt=0;
	ResultSet rs;
	String strname,strpass;
	
	//JLabel JLPic1 = new JLabel(new ImageIcon("chwrde-thumb[1].png"));
	JLabel JLBanner2= new JLabel("Processors Furnitures");
	JLabel JLBanner = new JLabel("Rutuja Malusare");
	JLabel JLBanner1 = new JLabel("Shweta Mohite");
	//JLabel JLBanner3 = new JLabel(new ImageIcon("conroomtab-thumb[1].gif"));
	JButton close=new JButton("CLOSE",new ImageIcon("cancel.png"));	
       //String ch = "*";
	//JTFPassword.setEchoChar("*");
	JPanel JPDialogContainer = new JPanel();

	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

	public Info()
	{
		setTitle("Developed by...");
		JPDialogContainer.setLayout(null);
	 	setBackground(Color.pink);

		//-- Add the JLPic1
//		JLPic1.setBounds(45,45,42,42);
//		JPDialogContainer.add(JLPic1);

		//-- Add the JLBanner
		JLBanner2.setBounds(70,1,350,100);
		JLBanner2.setFont(new Font("Old English text MT",Font.BOLD,24));
		JPDialogContainer.add(JLBanner2);
		JLBanner.setBounds(150,80,350,100);
		JLBanner.setFont(new Font("Palatino Linotype",Font.BOLD,12));
		JPDialogContainer.add(JLBanner);
		 //JLBanner3.setBounds(25,70,100,100);
        //JPDialogContainer.add(JLBanner3);
		//-- Add the JLBanner1
		JLBanner1.setBounds(150,100,350,100);
		JLBanner1.setFont(new Font("Palatino Linotype",Font.BOLD,12));
		JPDialogContainer.add(JLBanner1);
		JPDialogContainer.setBackground(Color.lightGray);
	        close=new JButton("Close",new ImageIcon("Images/cancel.png"));
		close.setBounds(300,200,120,30);
		JPDialogContainer.add(close);
                close.setToolTipText("Click here to close window");

 		 close.addActionListener(this);

		//End initialize variables



		//End initialize variables

		
		//-- Add the JBEnter
		getContentPane().add(JPDialogContainer);
		setSize(450,265);
		setResizable(false);
		setLocation((screen.width - 450)/2,((screen.height-265)/2));
		setVisible(true);

}
  public void actionPerformed(ActionEvent ae)

  { 
   
   if(ae.getSource()==close)

     {
      dispose();

      }

	}
	public static void main(String s[])
	{
		new Info();
	}
}


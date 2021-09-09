import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import java.awt.geom.*;

class MyTime2 extends Thread
{
        JLabel l;

        MyTime2(JLabel l)
        {
                this.l = l;
        }
        public void run()
        {
                try
                {

                        while(true)
                        {
                                Date d = new Date();

                                int h = d.getHours();
                                int m = d.getMinutes();
                                int s = d.getSeconds();

                                Font f = new Font("Serif",Font.BOLD,40);
                                l.setFont(f);
                                l.setText(h+ ":" +m+ ":"+s);

                                sleep(1500);
                         }

                }
                catch(InterruptedException e)
                {
                        e.printStackTrace();
                }
        }
}

public class Welcome extends JFrame implements ActionListener
{

	JLabel l=new JLabel("Processors Furniture");
	JLabel l1=new JLabel();
	MyTime t;

	JLabel l2;

	JButton LOGIN,CREDIT;

	JPanel p1=new JPanel();

	JPanel p2=new JPanel();

	JPanel p3=new JPanel();



	private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	Welcome()

	{
		t=new MyTime(l1);
		t.start();
		Font f=new Font("Times new roman",Font.BOLD,35);
		l1.setFont(f);
		l1.setForeground(Color.BLUE);

		setLayout(new BorderLayout());


		p1.add(l);
		
		//p1.add(l1);
		
		

		add(p1,BorderLayout.NORTH);
		p3.setLayout(null);

		l2=new JLabel(new ImageIcon("Images/welc.jpg"));
		l2.setBounds(0,5,800,570);
		l1.setBounds(600,400,200,30);
		p3.add(l1);
		p3.add(l2);
		


		add(p3,BorderLayout.CENTER); 

		p2.add(LOGIN=new JButton("LOGIN",new ImageIcon("Images/enter.png")));

		LOGIN.setToolTipText("Click here to login admin window");

		p2.add(CREDIT=new JButton("AboutUs",new ImageIcon("Images/branch.png")));

		CREDIT.setToolTipText("Click here for credit information");

		add(p2,BorderLayout.SOUTH); LOGIN.addActionListener(this);

		CREDIT.addActionListener(this);

		l.setFont(f);

		p1.setBackground(Color.blue);

		p2.setBackground(Color.white);

		p3.setBackground(Color.yellow);

		LOGIN.setForeground(Color.red);

		l.setForeground(Color.white);

		CREDIT.setForeground(Color.red);


		setSize(800,570);

		setLocation(0,0);

		setTitle("Processors Furnitures");

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);






	}

	public void actionPerformed(ActionEvent a)

	{
		if(a.getSource()==LOGIN)

		{

			new Login();

			//dispose();

		}


		if(a.getSource()==CREDIT)
		{
			new Info();
		}
	}


	public static void main(String a[])

	{

		new Welcome();

	}

}




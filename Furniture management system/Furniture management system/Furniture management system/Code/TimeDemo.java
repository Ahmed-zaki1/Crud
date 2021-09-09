import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;

public class TimeDemo extends JFrame implements ActionListener
{
	JLabel l;
	JButton b1,b2;

	MyTime t;	

	TimeDemo()
	{
		setLayout(null);

		setTitle("TimeDemo");
		setSize(500,500);
		
		l = new JLabel();
		l.setBounds(100,100,200,200); 
		
		b1 = new JButton("Start");
		b1.setBounds(50,400,100,30);
		
		

		b2 = new JButton("Stop");
		b2.setBounds(300,400,100,30);
			
		add(l);
		add(b1);	
		add(b2);
		

		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new TimeDemo();
	}
	public void actionPerformed(ActionEvent ae)
	{
		JButton b = (JButton)ae.getSource();

		if(b == b1)
		{
			t = new MyTime(l);
			t.start();
		}
		if(b == b2)
		{
			t.stop();
		}
	}
}

class MyTime1 extends Thread
{
	JLabel l;

	MyTime1(JLabel l)
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





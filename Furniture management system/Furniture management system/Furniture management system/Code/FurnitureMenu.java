import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.awt.geom.*;
import java.util.*;


class MyTime extends Thread
{
        JLabel l;

        MyTime(JLabel l)
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

public class FurnitureMenu extends Furniture implements ActionListener
{
	JMenuBar mb;
	public JMenu AddMenu,TransactionMenu,MaintenanceMenu,UpdateMenu,DeleteMenu,ReportMenu,LogOff ;
	public JMenuItem Department,Employee,FurnitureStock,Suppiler;
	public JMenuItem GenerateBill,PaySalary;
	public JMenuItem UpdateEmployee,UpdateFurnitureStock,UpdateDepartment,DeleteEmployee,DeleteFurnitureStock,DeleteDepartment,DeleteSupplier,MonthlyPay;
	public JMenuItem ReportTotalSupplier,ReportTotalStock,ReportTransByCustomer,UpdateSupplier,ReportTotalDepartment;	
	public JMenuItem Exit;	
	JButton GenBill;
	MyTime t;
	JLabel l2=new JLabel("");
	public FurnitureMenu()
	{
		setLayout(null);
		t=new MyTime(l2);
		t.start();
		l2.setForeground(Color.BLUE);
		l2.setBounds(600,400,200,30);
                add(l2);
		JLabel ll=new JLabel("",new ImageIcon("Images/pink.jpg"),JLabel.CENTER);
		ll.setBounds(0,0,800,490);
		add(ll);

		//setLayout(null);

		GenBill=new JButton("GenerateBill");

		//ADD :MenuBar
		mb = new JMenuBar();
		setJMenuBar(mb);
		//Create : AddMenu
		AddMenu=new JMenu("Add");
		Department=new JMenuItem("Department");
		Employee=new JMenuItem("Employee");
		FurnitureStock=new JMenuItem("Furniture Stock");
		Suppiler=new JMenuItem("Suppiler");
		//ADD: AddMenu & its Items
		mb.add(AddMenu);
		AddMenu.add(Department);
		Department.addActionListener(this);
		AddMenu.addSeparator();
		AddMenu.add(Employee);
		Employee.addActionListener(this);
		AddMenu.addSeparator();   	 
		AddMenu.add(FurnitureStock);
		FurnitureStock.addActionListener(this);
		AddMenu.addSeparator();   	 
		AddMenu.add(Suppiler);
		Suppiler.addActionListener(this);

		//Create :	TransactionMenu 
		TransactionMenu =new JMenu("Transaction");
		GenerateBill=new JMenuItem("Generate Bill");
		PaySalary=new JMenuItem("Pay Salary");
		//ADD:	TransactionMenu  & its Items
		mb.add(TransactionMenu);
		TransactionMenu.add(GenerateBill);
		GenerateBill.addActionListener(this);	
		TransactionMenu.addSeparator();
		TransactionMenu.add(PaySalary);
		PaySalary.addActionListener(this);	

		//Create :  MaintenanceMenu 
		MaintenanceMenu =new JMenu("Maintaince");
		UpdateMenu=new JMenu("Update");
		DeleteMenu=new JMenu("Delete");
		UpdateEmployee=new JMenuItem("Update Employee");
		UpdateFurnitureStock=new JMenuItem("Update FurnitureStock");
		UpdateDepartment=new JMenuItem("Update Department");
		UpdateSupplier=new JMenuItem("Update Supplier");

		DeleteEmployee=new JMenuItem("Delete Employee");
		DeleteFurnitureStock=new JMenuItem("Delete FurnitureStock");
		DeleteDepartment=new JMenuItem("Delete Department");
		DeleteSupplier=new JMenuItem("Delete Supplier");

		//ADD:	MiantenanceMenu & its Items
		mb.add(MaintenanceMenu);
		MaintenanceMenu.add(UpdateMenu);
		MaintenanceMenu.addSeparator();
		MaintenanceMenu.add(DeleteMenu);
		UpdateMenu.add(UpdateEmployee);
		UpdateEmployee.addActionListener(this);
		UpdateMenu.addSeparator();
		UpdateMenu.add(UpdateFurnitureStock);
		UpdateFurnitureStock.addActionListener(this);
		UpdateMenu.addSeparator();
		UpdateMenu.add(UpdateDepartment);
		UpdateDepartment.addActionListener(this);
		UpdateMenu.addSeparator();
		UpdateMenu.add(UpdateSupplier);
		UpdateSupplier.addActionListener(this);
		DeleteMenu.add(DeleteEmployee);
		DeleteEmployee.addActionListener(this);
		DeleteMenu.addSeparator();
		DeleteMenu.add(DeleteFurnitureStock);
		DeleteFurnitureStock.addActionListener(this);	
		DeleteMenu.addSeparator();	
		DeleteMenu.add(DeleteDepartment);
		DeleteDepartment.addActionListener(this);
		DeleteMenu.addSeparator();
		DeleteMenu.add(DeleteSupplier);
		DeleteSupplier.addActionListener(this);	


		//Create :  Reports  
		ReportMenu=new JMenu("Reports");
		ReportTotalSupplier=new JMenuItem("Supplier List");
		ReportTotalStock=new JMenuItem("Stock List");
		ReportTransByCustomer=new JMenuItem("Bill List");
		MonthlyPay=new JMenuItem("Monthly Payments");
		ReportTotalDepartment=new JMenuItem("Department List");
		//ADD: ReportMenu & its Items
		mb.add(ReportMenu);
		ReportMenu.add(ReportTotalSupplier);
		ReportTotalSupplier.addActionListener(this);
		ReportMenu.addSeparator();
		ReportMenu.add(ReportTotalDepartment);
		ReportTotalDepartment.addActionListener(this);
		ReportMenu.addSeparator();
		ReportMenu.add(ReportTotalStock);
		ReportTotalStock.addActionListener(this);
		ReportMenu.addSeparator();
		ReportMenu.add(ReportTransByCustomer);
		ReportTransByCustomer.addActionListener(this);
		ReportMenu.addSeparator();
		ReportMenu.add(MonthlyPay);
		MonthlyPay.addActionListener(this);
		LogOff=new JMenu("LogOff");
		Exit = new JMenuItem("Exit");
		mb.add(LogOff);
		LogOff.add(Exit);
		Exit.addActionListener(this);	                     
		setTitle("Furniture Shop Management System");
		setSize(1078,762);
		setVisible(true);
		addWindowListener(new WindowAdapter()
				{
				public void windowClosing(WindowEvent e)
				{
				System.exit(0);
				}
				});

	}//END:constructor

	public void actionPerformed (ActionEvent ae) 
	{
		try{
			//Add
			if(ae.getSource()==Department)
			{
				new AddDept().show();
			}
			if(ae.getSource()==Employee)
			{
				new AddEmp().show();

			}

			if(ae.getSource()==FurnitureStock)
			{
				new AddFurSto().show();

			}
			if(ae.getSource()==Suppiler)
			{
				new AddSup().show();
			}
			
			//Transaction   
			if(ae.getSource()==GenerateBill||ae.getSource()==GenBill)
			{	
				new  Bill().show();
			}
			if(ae.getSource()==PaySalary)
			{	
				new  PaySal().show();
			}
			
			//Maintenance
			if(ae.getSource()==UpdateEmployee)
			{	
				new UpdateEmp().show();
			}
			if(ae.getSource()==UpdateFurnitureStock)
			{	
				new UpdateAddFurSto().show();
			}
			if(ae.getSource()==UpdateDepartment)
			{	
				new UpdateDept().show();
			}
			if(ae.getSource()==UpdateSupplier)
			{	
				new UpdateSup().show();
			}
			if(ae.getSource()==DeleteEmployee)
			{	
				new DeleteEmp().show();
			}
			if(ae.getSource()==DeleteFurnitureStock)
			{	
				new DeleteFurSto().show();
			}
			if(ae.getSource()==DeleteDepartment)
			{	
				new DeleteDept().show();
			}
			if(ae.getSource()==DeleteSupplier)
			{	
				new DeleteSup().show();
			}

			//report
			if(ae.getSource()==ReportTotalSupplier)
			{	
				new ReportTotalSupplier().show();
			}
			if(ae.getSource()==ReportTotalStock)
			{	
				new ReportTotalStock().show();
			}
			if(ae.getSource()==ReportTransByCustomer)
			{	
				new ReportTotalTrans().show();
			}
			if(ae.getSource()==MonthlyPay)
			{	
				new ReportMonthlyPayment().show();
			}
			if(ae.getSource()==ReportTotalDepartment)
			{
				new ReportTotalDepartment().show();
			}
			if(ae.getSource()==Exit)
			{
				System.exit(0);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		new FurnitureMenu().show();
	}
}

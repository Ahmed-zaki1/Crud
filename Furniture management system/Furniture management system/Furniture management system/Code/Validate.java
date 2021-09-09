import javax.swing.*;
import java.awt.*;
//Validat class has only methods to validate given input-inp String
public class Validate
{

	boolean  checkOnlyNumber(String inp,Frame p,String f)
	{
		Frame frm=null;
		String fld;
		boolean flag=false;
		frm=p;
		fld=f;
		for(int i=0;i<inp.length();i++)
		{
		 	if(!Character.isDigit(inp.charAt(i)))//Not a digit		
		 	{
		 		if(inp.charAt(i)=='.')
		 			continue;
				dispMsgBox(frm,fld);
		 		flag=true;
				return flag;
		 	}
		}
		return flag;
	}
	boolean checkOnlyText(String inp,Frame p,String f)
	{
	
		Frame frm=null;
		String fld;
		boolean flag=false;
		frm=p;
		fld=f;
		for(int i=0;i<inp.length();i++)
		{
if(!(Character.isLetter(inp.charAt(i))))//inp contains special character
	if(!Character.isSpaceChar(inp.charAt(i))&&i>0)//checking for space
{
	dispMsgBox(frm,fld);
	flag=true;
	return flag;
}
		}
return flag;
	}
	boolean checkBlank(String inp,Frame p,String f)
	{
		Frame frm=null;
		String fld;
		boolean flag=false;
	 	frm=p;
	 	fld=f;
	 	if(inp.length()==0)//inp contains blank character
		{
					dispMsgBox(frm,fld );
					flag=true;
					return flag;
		}
	 	return flag;
		
	}
	void dispMsgBox(Frame frm,	String fld)
	{
		
JOptionPane.showMessageDialog(frm,"Invalid Input Field:"+fld,"Error",JOptionPane.ERROR_MESSAGE);
return;
	}
	
}


 

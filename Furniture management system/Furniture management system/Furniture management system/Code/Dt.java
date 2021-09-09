import java.util.*;
import java.text.*;//for date
public class Dt extends Furniture
{
	GregorianCalendar m_calendar;
	SimpleDateFormat d_m_yFormat;//dayFormat1,t;
	public Dt()
	{
		try
		{	
			d_m_yFormat = new SimpleDateFormat("yyyy/MM/d");
			m_calendar = new GregorianCalendar();

			Date date = m_calendar.getTime();
			d=d_m_yFormat.format(date);
		
		}
		catch(Exception dte){System.out.println(dte);}	
	}
	public String Get()
	{
		return d;
	}	
	public static void main(String args[])
	{	
		new Dt();

	}
}

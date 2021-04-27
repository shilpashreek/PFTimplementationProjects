package com.pft.qa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class getSysemDateAndTime {

	public static void main(String[] args) throws Exception 
	{
		
		
		
		Calendar calendar2 = Calendar.getInstance();
		Date curTime = calendar2.getTime();
		String CuurentTime = String.valueOf(curTime);
		System.out.println(CuurentTime);
		int CuurentTimeInt = Integer.parseInt(CuurentTime);
		
		calendar2.add(calendar2.MINUTE, 5);
		Date updatedTime = calendar2.getTime();
		String Added5Time = String.valueOf(updatedTime);
		System.out.println(Added5Time);
		int Added5TimeInt = Integer.parseInt(Added5Time);
		
		Calendar calendar1 = Calendar.getInstance();
		Date sysTime = calendar1.getTime();
		String systemTime = String.valueOf(sysTime);
		System.out.println(systemTime);
		int systemTimeInt = Integer.parseInt(systemTime);
		
		
		for(int i=CuurentTimeInt ; i<=Added5TimeInt ; i++)
		{
			Thread.sleep(5000);
			if(!Added5Time.equals(CuurentTime))
			{
				System.out.println("try");
			}
			
			
			
			
		}
		
		
		 
		
	}

}

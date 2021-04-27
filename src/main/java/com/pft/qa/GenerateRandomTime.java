package com.pft.qa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class GenerateRandomTime 
{

	public static void main(String[] args) 
	{
		Random random = new Random();
		
		LocalDateTime time = LocalDateTime.of(LocalDate.now(), 
	            LocalTime.of(random.nextInt(24), random.nextInt(60),
	            random.nextInt(60)));
	    System.out.println(time);
	    
	    
		
		/*
		 * for (int i = 0; i < 10; i++) { LocalDateTime time =
		 * LocalDateTime.of(LocalDate.now(), LocalTime.of(random.nextInt(24),
		 * random.nextInt(60), random.nextInt(60), random.nextInt(999999999 + 1)));
		 * System.out.println(time); }
		 */

	}

}

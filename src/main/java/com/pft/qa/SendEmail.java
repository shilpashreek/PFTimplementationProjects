package com.pft.qa;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;


public class SendEmail 
{
@Test
public void mail() throws EmailException
{
	Email email = new SimpleEmail();
	email.setHostName("mail.primefocus.com");
	email.setSmtpPort(465); //465
	email.setAuthenticator(new DefaultAuthenticator("shilpashree.k@primefocus.com", "SAURXCUSYTYDJIZQ"));  //SAURXCUSYTYDJIZQ
	email.setSSLOnConnect(true);
	email.setFrom("shilpashree.k@primefocus.com");
	email.setSubject("TestCaseExecutionMail");
	email.setMsg("Hi guys...:)");
	email.addTo("shilpashree.k@primefocus.com"); //nayana.dj@primefocus.com
	email.addCc("shilpashree.k@primefocus.com");
	email.send();
	
	
}
}

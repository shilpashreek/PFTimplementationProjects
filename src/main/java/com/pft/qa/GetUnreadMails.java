package com.pft.qa;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class GetUnreadMails
{
static String host= "mail.primefocus.com";
static String Username="shilpashree.k@primefocus.com";
static String password="SAURXCUSYTYDJIZQ";

	public static void main(String[] args)
	{
		Properties sysProps = System.getProperties(); 
		 
		sysProps.setProperty("mail.store.protocol", "pop3");
		 
		try 
		{
		 
		Session session = Session.getInstance(sysProps, null);
		 
		Store store = session.getStore();
		 
		store.connect(host, Username, password);
		 
		Folder emailInbox = store.getFolder("Inbox");
		 
		emailInbox.open(Folder.READ_ONLY);
		
		 
		int messageCount = emailInbox.getMessageCount();
		 
		System.out.println("Total Message Count: " + messageCount);
		 
		int unreadMsgCount = emailInbox.getUnreadMessageCount();
		
		System.out.println("total unread messages are" + unreadMsgCount);
		
		for(int i=0; i<=unreadMsgCount; i++)
		{
		Message emailMessage = emailInbox.getMessage(i);
		
		 
		System.out.println("Email Subject: " + emailMessage.getSubject());
		 
		emailMessage.setFlag(Flags.Flag.SEEN, true);
		}
		 
		emailInbox.close(true);
		 
		store.close();
		} 
		catch (Exception mex) 
		{
			 
			mex.printStackTrace();
			 
		}

	}

}

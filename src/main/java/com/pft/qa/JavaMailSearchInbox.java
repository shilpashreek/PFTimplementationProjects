package com.pft.qa;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import com.google.inject.spi.Message;

public class JavaMailSearchInbox 
		{

			  public static void main(String args[]) throws Exception 
			  {

			    // mail server info
			    String host = "mail.primefocus.com";
			    String user = "shilpashree.k@primefocus.com";
			    String password = "SAURXCUSYTYDJIZQ";

			    // connect to my pop3 inbox in read-only mode
			    Properties properties = System.getProperties();
			    Session session = Session.getDefaultInstance(properties);
			    Store store = session.getStore("pop3");
			    store.connect(host, user, password);
			    Folder inbox = store.getFolder("INBOX");  //inbox
			    inbox.open(Folder.READ_ONLY);

			    // search for all "unseen" messages
			    Flags seen = new Flags(Flags.Flag.SEEN);  //seen
			    System.out.println("see" +seen);
			    //System.out.println(Flags.Flag.RECENT);
			    FlagTerm unseenFlagTerm = new FlagTerm(seen, false);  //false was there
			    
			    System.out.println("unseen-->" +unseenFlagTerm);
			    javax.mail.Message[] messages = inbox.search(unseenFlagTerm);
			    
			    System.out.println("total messgaes" +messages.length);
			    if (messages.length == 0) System.out.println("No messages found.");

			    for (int i = messages.length-1,j=1; j<=10; i--,j++)
			    {
			      // stop after listing ten messages
			/*
			 * if (i >10) //i>10 {
			 * 
			 * System.exit(0); inbox.close(true); store.close(); }
			 */
			      System.out.println("Message " + (i+1));  //i+1
			      System.out.println(messages[i].getFrom().length);
			      
			      System.out.println("From : " + messages[i].getFrom()[0]); //0
			      
			      System.out.println("Subject : " + messages[i].getSubject());
			      System.out.println("Sent Date : " + messages[i].getSentDate());
			     // System.out.println("Received Date : " + messages[i].getReceivedDate());
			      
			      System.out.println();
			    }

			    inbox.close(true);
			    store.close();
			  }
			

	}



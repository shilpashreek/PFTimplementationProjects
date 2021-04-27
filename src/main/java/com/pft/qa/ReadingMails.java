package com.pft.qa;

import java.util.Arrays;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class ReadingMails 
{

    public static void main( String[] args ) throws Exception
    {

      Session session = Session.getDefaultInstance(new Properties( ));
      Store store = session.getStore("pop3");
      store.connect("mail.primefocus.com", 465, "shilpashree.k@primefocus.com", "SAURXCUSYTYDJIZQ");
      Folder inbox = store.getFolder( "INBOX" );
      inbox.open( Folder.READ_WRITE );
      
     int unreadmsgs = inbox.getUnreadMessageCount();
      System.out.println(unreadmsgs);

      // Fetch unseen messages from inbox folder
      Message[] messages = inbox.search(
          new FlagTerm(new Flags(Flags.Flag.SEEN), false));

      // Sort messages from recent to oldest
      Arrays.sort( messages, ( m1, m2 ) -> {
        try {
          return m2.getSentDate().compareTo( m1.getSentDate() );
        } catch ( MessagingException e ) {
          throw new RuntimeException( e );
        }
      } );

      for ( Message message : messages ) {
        System.out.println( 
            "sendDate: " + message.getSentDate()
            + " subject:" + message.getSubject() );
            message.setFlag(Flags.Flag.SEEN, true);
      }
    }
  }


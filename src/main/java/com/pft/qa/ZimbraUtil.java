package com.pft.qa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import org.jsoup.Jsoup;

public class ZimbraUtil {
	
	static ZimbraUtil zimbraUtil;
	static String Filepath="D:\\PFTprojects\\MavenDemoProject\\src\\main\\java\\writeData\\mailBody";
	static String ContentOfmail= null;
	
	public static void main(String[] args) throws MessagingException, IOException {
	
	
	
	zimbraUtil=new ZimbraUtil();
	ContentOfmail=zimbraUtil.readTheLatestMail("mail.primefocus.com", "shilpashree.k@primefocus.com", "SAURXCUSYTYDJIZQ", "noreply@clearnotifications.com","Security Access Code", Filepath);
	System.out.println("contents of the mail body from the expected sender is as follows-->" +ContentOfmail);
	System.out.println(ContentOfmail);
	// !ContentOfmail.isEmpty()  ContentOfmail!=null && 
	
	//splitting string to get 6 digit code
	  if(ContentOfmail!=null && !ContentOfmail.isEmpty()) { 
		  String SplittedContent[]=ContentOfmail.split(":");
		  System.out.println("*******splitted strings***");
		  System.out.println(SplittedContent[0]);
		  System.out.println(SplittedContent[1]);
		  
		  String a[]=SplittedContent[1].split("\\."); 
		  String otpString = a[0].trim();
		  int otp = Integer.parseInt(otpString);
		  
		  System.out.println("OTP is found as following from the mail body -->" +otp);
		  }else if(ContentOfmail==null) {
		  System.out.println("OTP is not found"); }
		 
	}
	
	//port-465  host-mail.primefocus.com
	public String readTheLatestMail(final String host ,String username, String password ,String Expected_Sender ,String Expected_subject,String Filepath ) throws MessagingException, IOException
	{
		String mailBody=null;
		
		Properties properties = new Properties();
		properties.put("mail.pop3.host",host );
		properties.put("mail.pop3.host", "993");  //993
		properties.put("mail.pop3.starttls.enable", "true");
		properties.put("mail.pop3.starttls.required", "true");
		properties.put("mail.pop3.disabletop", "true");
		final Session emailSession = Session.getDefaultInstance(properties);
		final Store store = emailSession.getStore("pop3s");
		store.connect(host, username, password);
		Folder emailFolder = store.getFolder("INBOX");
		emailFolder.open(Folder.READ_ONLY);
		//emailFolder.open(1);
		final Message[] messages = emailFolder.getMessages();
		//Message[] messages = emailFolder.getMessages();
		
		//unseen messages
		//messages=emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
		
	    //System.out.println("new messagges count " +emailFolder.getNewMessageCount());
	
		int messageLength = messages.length;
		
		for (int i = messages.length-1,j=1; j<=10; i--,j++)
		//for(int i=messageLength-1; i>0 ;--i)
		//for(int i=messageLength-1; i<=10 ;--i)		
		{
			final Message message = messages[i];
			//messages.getFrom()[i];
			String SubjectOfMail=message.getSubject();
			String sender=message.getFrom()[0].toString();
			/*
			 * if(message.getFrom()[0].toString().equalsIgnoreCase(Expected_Sender) &&
			 * SubjectOfMail.equalsIgnoreCase(Expected_subject) )
			 */
				if(sender.equalsIgnoreCase(Expected_Sender)
						&& SubjectOfMail.equalsIgnoreCase(Expected_subject)	)
				
			{
				FileWriter fWriter = new FileWriter(Filepath);
				final BufferedWriter writer = new BufferedWriter(fWriter);
				
				System.out.println("********starting of mail body******");
				mailBody = getTextFromMessage(message).toString();
				System.out.println(mailBody);
				System.out.println("********end of mail body******");
				
				writer.write(getTextFromMessage(message).toString());    //writes the contents of msg to file specified in the path
				writer.newLine();
				writer.close();
				System.out.println("The email found with given sender and a html file is created with name :: " + Filepath);
				//return true;
				return mailBody;
			}
			
		}
		System.out.println("Unable to find any mail with given sender");
		//return false;
		return mailBody;
		
	}
	
	
	private static String getTextFromMessage(final Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        }
        else if(message.isMimeType("text/html")){
        	String html = (String)message.getContent();
        	result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
        }
        else if (message.isMimeType("multipart/*")) {
            final MimeMultipart mimeMultipart = (MimeMultipart)message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }
	
	
	private static String getTextFromMimeMultipart(final MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        for (int count = mimeMultipart.getCount(), i = 0; i < count; ++i) {
            final BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = String.valueOf(result) + "\n" + bodyPart.getContent();
                break;
            }
            if (bodyPart.isMimeType("text/html")) {
                final String html = (String)bodyPart.getContent();
                result = String.valueOf(result) + "\n" + Jsoup.parse(html).text();
            }
            else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = String.valueOf(result) + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }
	
	public void getCurrentDateAndTime()
	{
		Calendar curDT = Calendar.getInstance();
		Date curTime = curDT.getTime();
		String dateInString = String.valueOf(curTime);
		
	}
	
	/*
	 * public Date getUpdatedDateAndTime(Calendar curDT) { curDT.add(curDT.MINUTE,
	 * 5); return curDT.getTime();
	 * 
	 * }
	 */
	public void returnOTP()
	{
		
	}
	
	

}

package com.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.lang.String;


public class SendSmtpMail
  {
       
	public static String SMTP_HOST_NAME = "smtp.gmail.com";
    public static String SMTP_PORT = "465";
	public static  String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    
    public static void sendMessage(String recipients[], String subject,String message1,String from) throws MessagingException
            {
                    
    	boolean debug = true;
        String sendStatus=null;
        
        Properties props = new Properties();
    	props.put("mail.smtp.host", "smtp.gmail.com");
    	props.put("mail.smtp.socketFactory.port", "465");
    	props.put("mail.smtp.socketFactory.class",
    			"javax.net.ssl.SSLSocketFactory");
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.port", "465");

    	try {
    		
    		Session session = Session.getDefaultInstance(props,
    		new javax.mail.Authenticator() {
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication("support@myaadhaarshila.com","AES@1234567890");
    			}
    		});
    	
    		session.setDebug(debug);
    	
    	

    		Message message = new MimeMessage(session);
    		message.setFrom(new InternetAddress("support@myaadhaarshila.com"));
    		
    		
    		InternetAddress addressTo[] = new InternetAddress[recipients.length];
    	    for(int i = 0; i < recipients.length; i++)
    	    addressTo[i] = new InternetAddress(recipients[i]);


    	    message.setRecipients(javax.mail.Message.RecipientType.TO, addressTo);

            message.setRecipients(Message.RecipientType.TO, addressTo);
    		
    		message.setSubject(subject);
    		message.setContent(message1,"text/html");

    		Transport.send(message);

    		System.out.println("Self Service Mail Done.......................");

    	} catch (MessagingException e) {
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}

       
    }
    
 
    
    public static void sendMessage2(String recipients[], String subject,String message1,String from) throws MessagingException
    {
            
		boolean debug = true;
		String sendStatus=null;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		try {
	
			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("aadharrshilaenrollsystems@gmail.com","Aes@12345");
				}
			});

	session.setDebug(debug);



	Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress("aadharrshilaenrollsystems@gmail.com"));
	
	
	InternetAddress addressTo[] = new InternetAddress[recipients.length];
    for(int i = 0; i < recipients.length; i++)
    addressTo[i] = new InternetAddress(recipients[i]);


    message.setRecipients(javax.mail.Message.RecipientType.TO, addressTo);

    message.setRecipients(Message.RecipientType.TO, addressTo);
	
	message.setSubject(subject);
	message.setContent(message1,"text/html");

	Transport.send(message);

	System.out.println("Self Service Mail Done.......................");

} catch (MessagingException e) {
	e.printStackTrace();
	throw new RuntimeException(e);
}


}


 }
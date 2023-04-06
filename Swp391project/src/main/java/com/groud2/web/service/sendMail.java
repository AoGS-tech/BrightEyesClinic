/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.service;

import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author anhha
 */
public class sendMail {
//    public static void main(String args[]) throws AddressException, jakarta.mail.MessagingException {

//		sendHTML();
////		sendFile();
//		System.out.println("done");
//	}

	

	public static void MailResetPassword(String mail,String text) throws AddressException, jakarta.mail.MessagingException {
		Properties mailServerProperties;
		Session getMailSession;
		MimeMessage mailMessage;

		// Step1: setup Mail Server
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		// Step2: get Mail Session
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		mailMessage = new MimeMessage(getMailSession);

		// mail khach
		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail)); 

		mailMessage.setSubject("Thank you");
		String emailBody = text;
		mailMessage.setContent(emailBody, "text/html");
		// Step3: Send mail
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "anhhq02@gmail.com", "commwhfhhhyzwkbg");
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transport.close();
	}
        
}

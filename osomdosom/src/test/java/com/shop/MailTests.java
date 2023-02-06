package com.shop;

import java.util.Properties;

import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


@SpringBootTest
class MailTests{
	@Test
	public void Mailtest() throws MessagingException {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("qkrgkektha.gmail.com");
		sender.setPort(587);
		sender.setUsername("firstboos");
		sender.setPassword("qkrgkektha1!");
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.starttls.enable", "true");
		sender.setJavaMailProperties(prop);
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo("qkrgkektha@google.com");
		helper.setText("Thank you for ordering!");
		sender.send(message);
	}
}
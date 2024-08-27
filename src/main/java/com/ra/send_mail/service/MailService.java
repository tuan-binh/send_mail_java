package com.ra.send_mail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailService
{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendTextMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("binh189200@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);
	}
	
	public void sendHTMLMessage(String to, String subject, String html)
	{
		try
		{
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(message, true);
			helper.setFrom("binh1892001@gmail.com");
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(html, true);
			javaMailSender.send(message);
		}
		catch (MessagingException e)
		{
			log.error("Error sending email {}", e.getMessage());
		}
	}
	
}

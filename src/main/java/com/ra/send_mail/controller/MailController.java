package com.ra.send_mail.controller;

import com.ra.send_mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mail")
public class MailController
{
	
	@Autowired
	private MailService mailService;
	
	@PostMapping
	public ResponseEntity<?> sendMail(@RequestParam String email)
	{
		mailService.sendHTMLMessage(email,"Send Email","<h1>Xin chào cả lớp HN_JV240408</h1>");
		return ResponseEntity.ok().body("Send mail successfully");
	}
	
}

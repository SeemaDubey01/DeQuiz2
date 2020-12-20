package com.dequiz.DeQuiz.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/*
 * @Service("emailService") public class EmailServiceImpl implements
 * EmailService {
 * 
 * @Autowired private EmailConfig emailConfig;
 * 
 * @Autowired private JavaMailSenderImpl mailSender;
 * 
 * @Async
 * 
 * @Override public void sendEmail(MimeMessage email) {
 * 
 * getmailSender().send(email); }
 * 
 * public MimeMessage createMimemessage() { MimeMessage message =
 * getmailSender().createMimeMessage(); return message; }
 * 
 * private JavaMailSenderImpl getmailSender() {
 * 
 * mailSender.setHost(emailConfig.getHost());
 * mailSender.setPort(emailConfig.getPort());
 * mailSender.setUsername(emailConfig.getUserName());
 * mailSender.setPassword(emailConfig.getPassword());
 * 
 * return mailSender; }
 * 
 * 
 * 
 * }
 */
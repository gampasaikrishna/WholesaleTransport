package com.sai.WholesaleTransport.util;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class Utils {

	@Value("${mail_username}")
	private String MAIL_USERNAME;
	
	@Value("${mail_subject}")
	private String MAIL_SUBJECT;
	
	@Value("${sms_host}")
	private String SMS_HOST;
	
	@Value("${sms_username}")
	private String SMS_USERNAME;
	
	@Value("${sms_password}")
	private String SMS_PASSWORD;
	
	@Value("${sms_sendername}")
	private String SMS_SENDERNAME;
	
	@Autowired
	private MailSender mailSender;
	
	public void sendMail(String email, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(MAIL_USERNAME);
		mailMessage.setTo(email);
		mailMessage.setSubject(MAIL_SUBJECT);
		mailMessage.setText(message);
		try	{
			mailSender.send(mailMessage);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void sendSMS(String mobileNumber, String message) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(SMS_HOST + "?username=" + SMS_USERNAME + "&password=" + SMS_PASSWORD 
				+ "&sendername=" + SMS_SENDERNAME + "&mobileno=" + mobileNumber + "&message=" + message);
		try	{
			httpclient.execute(httpGet);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}

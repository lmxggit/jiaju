package com.myspring.mail.service;

public interface IMailService {

	void sendMail(String to, String subject, String content);

	void sendHtmlMail(String to, String subject, String content);

	void sendAttachmentsMail(String to, String subject, String content, String filePath);

	void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

}

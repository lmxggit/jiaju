package com.myspring.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.myspring.mail.service.IMailService;
import com.myspring.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

	@Autowired
	private IUserService mvc;
	
	@Autowired
	private IMailService mailService;
	
	@Autowired
	private TemplateEngine templateEngine;

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void getHello() throws Exception {
		System.out.println(mvc.findByName(""));
		Assert.assertEquals(new Integer(16), new Integer(5));
	}
	
	@Test
	public void sendMail() throws Exception {
		mailService.sendMail("821416795@qq.com", "学习计划", "按时完成");
	}
	
	@Test
	public void testHtmlMail() throws Exception {
	    String content="<html>\n" +
	            "<body>\n" +
	            "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
	            "</body>\n" +
	            "</html>";
	    mailService.sendHtmlMail("821416795@qq.com","test simple mail",content);
	}
	
	@Test
	public void sendTemplateMail() {
	    //创建邮件正文
	    Context context = new Context();
	    context.setVariable("id", "006");
	    String emailContent = templateEngine.process("emailTemplate", context);

	    mailService.sendHtmlMail("821416795@qq.com","主题：这是模板邮件",emailContent);
	}
	
	@Test
	public void sendAttachmentsMail() {
	    String filePath="e:\\tmp\\application.log";
	    mailService.sendAttachmentsMail("821416795@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}
	
	@Test
	public void sendInlineResourceMail() {
	    String rscId = "neo006";
	    String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
	    String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";

	    mailService.sendInlineResourceMail("821416795@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	}

}

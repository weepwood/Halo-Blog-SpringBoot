package com.halo.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author Halo
 * @create 2021/09/27 下午 07:37
 * @description
 */
@RestController
public class Mail {
    @Autowired
    JavaMailSender mailSender;

    @GetMapping("/mail/{email}")
    public void SimpleMailMessageTest(@PathVariable(name = "email") String email) {
        Random random = new Random();
        String code = String.valueOf(random.nextInt(99999));
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Halo 验证码测试邮件");
        message.setText("验证码是：" + code);
        message.setTo(email);
        message.setFrom("1379978893@qq.com");
        mailSender.send(message);
        System.out.println("邮件发送成功");
    }
}

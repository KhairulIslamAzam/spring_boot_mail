package com.example.email.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author Khairul Islam Azam
 * @created 10/04/2021 - 11:55 AM
 * @project IntelliJ IDEA
 */
@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;
    private final Logger logger =  LoggerFactory.getLogger(EmailSenderService.class);

    public void sendSimpleMail(String fromEmail, String toEmail,
                               String subject, String body){

        SimpleMailMessage message = new SimpleMailMessage();
         message.setFrom(fromEmail);
         message.setTo(toEmail);
         message.setSubject(subject);
         message.setText(body);

         mailSender.send(message);
         logger.info("mail send successfully");
    }

    public void sendMailWithAttachment(String fromEmail, String toEmail,
                               String subject, String body, String attachment){

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = null;
        try {
            message = new MimeMessageHelper(mimeMessage, true);
            message.setFrom(fromEmail);
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);

            FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
            message.addAttachment(fileSystem.getFilename(), fileSystem);
            mailSender.send(mimeMessage);
            logger.info("mail send with attachment successfully");

        } catch (MessagingException e) {
            logger.info("mail send fail "+e.getMessage());
        }


    }
}

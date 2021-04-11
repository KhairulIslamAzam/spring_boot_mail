package com.example.email.service;

import com.example.email.configuration.EmailConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Date;

/**
 * @author Khairul Islam Azam
 * @created 10/04/2021 - 11:55 AM
 * @project email send with spring boot
 */
@Service
public class EmailSenderService {
    //    @Autowired
//    private JavaMailSender mailSender;
    private final EmailConfig emailConfig;
    private final Logger logger = LoggerFactory.getLogger(EmailSenderService.class);

    public EmailSenderService(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

//    public EmailSenderService()` {
//        this.mailSender = mailSender;
//    }

    public boolean sendSimpleMail(String to,
                                  String subject, String body) {

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//
//        mailSender.send(message);

        try {

            Message message = new MimeMessage(emailConfig.getSession());
//            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            logger.info("mail send successfully");
            return true;

        } catch (MessagingException e) {
            logger.error("mail send faild " + e.getMessage());
        }

        return false;
    }

    public boolean sendMailWithAttachment(String to, String subject,
                                          String body, String attachment) {


        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(emailConfig.getSession());

            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText(body);

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment

            File file = new File(attachment);
            if (file.isFile()) {
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(attachment);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(file.getName());
                multipart.addBodyPart(messageBodyPart);
                // Send the complete message parts
                message.setContent(multipart);
            }
            else if (file.isDirectory()) {
                File[] attachments = file.listFiles();
                for (int i = 0; i < attachments.length; i++) {
                    if (attachments[i].isFile()) {
                        messageBodyPart = new MimeBodyPart();
                        FileDataSource fileDataSource = new FileDataSource(attachments[i]);
                        messageBodyPart.setDataHandler(new DataHandler(fileDataSource));
                        messageBodyPart.setFileName(attachments[i].getName());
//                        messageBodyPart.setContentID("<ARTHOS>");
//                        messageBodyPart.setDisposition(MimeBodyPart.INLINE);
                        multipart.addBodyPart(messageBodyPart);
                    }
                }
            }

            message.setContent(multipart);
            // Send message
            Transport.send(message);
            logger.info("mail send successfully");
            return true;

        } catch (MessagingException e) {
            logger.error("attachment send failed " + e.getMessage());
        }
        return false;
    }

    public boolean htmlMail(String to, String subject,
                            String body){

        try{
            // creates a new e-mail message
            Message message = new MimeMessage(emailConfig.getSession());

//        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setSentDate(new Date());
            // set plain text message
            message.setContent(body, "text/html");

            // sends the e-mail
            Transport.send(message);

            logger.info("mail send successfully");
            return true;
        }catch (MessagingException e) {
            logger.error("attachment send failed " + e.getMessage());
        }
        return false;
    }

}

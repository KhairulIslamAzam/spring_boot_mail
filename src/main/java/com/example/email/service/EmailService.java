package com.example.email.service;

import com.example.email.entity.MailResponse;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Khairul Islam Azam
 * @since 1.0.0
 */

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration config;
    private final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public MailResponse sendMailMultipart(String toEmail, String  fromAddress,
                                          String subject, Map<String,String> model)  {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        MailResponse response = new MailResponse();

        try {

            helper = new MimeMessageHelper(mimeMessage, true);
            Template t = config.getTemplate("email-template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

            helper.setFrom(fromAddress);
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(html,true);


//            for(MultipartFile file : files){
//                File convFile = convertMultiPartToFile(file);
//                if(convFile != null){
//                    helper.addAttachment(convFile.getName(), convFile);
//                }
//            }
            logger.info("Email send successfully");
            response.setMessage("mail send to : " + toEmail);
            response.setStatus(Boolean.TRUE);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException  e) {
            logger.error("Message exception "+e.getMessage());
            response.setMessage("Mail Sending failure : "+e.getMessage());
            response.setStatus(Boolean.FALSE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        return response;
    }

    public MailResponse sendMail(String toEmail,String from, String subject, Map<String,String> model){
        return sendMailMultipart(toEmail, from, subject, model);
    }

//    public MailResponse sendMail(String toEmail, String subject, String message, MultipartFile [] files){
//         return sendMailMultipart(toEmail, subject, message, files);
//    }

//    private File convertMultiPartToFile(MultipartFile file) throws IOException {
//        File convFile = new File(file.getOriginalFilename());
//        FileOutputStream fos = new FileOutputStream(convFile);
//        fos.write(file.getBytes());
//        fos.close();
//        return convFile;
//    }
}

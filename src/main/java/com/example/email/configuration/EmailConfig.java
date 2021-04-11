package com.example.email.configuration;

import org.springframework.context.annotation.Configuration;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * @author Khairul Islam Azam
 * @created 11/04/2021 - 8:53 AM
 * @project email send with spring boot
 */
@Configuration
public class EmailConfig {
    private final String username = "azamblackps606862@gmail.com";
    private final String password = "pjgfsbppnjzavoiq";

    public Session getSession(){
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("spring.mail.properties.mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        return  session;
    }
}

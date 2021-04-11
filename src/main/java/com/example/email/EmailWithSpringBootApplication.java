package com.example.email;

import com.example.email.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailWithSpringBootApplication {

    @Autowired
    private EmailSenderService emailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(EmailWithSpringBootApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail(){
//        emailSenderService.sendSimpleMail("azamblackps606862@gmail.com",
//                "mkhairul.bs23@gmail.com",
//                "Testing smtp mail",
//                "the whole mail is the test purpose of smtp mail sender");

        emailSenderService.sendMailWithAttachment("azamblackps6862@gmail.com",
                "mkhairul.bs23@gmail.com",
                "Testing smtp mail",
                "the whole mail is the test purpose of smtp mail sender",
                "C:\\Users\\BS585\\Desktop\\tkgit.txt");
    }
}

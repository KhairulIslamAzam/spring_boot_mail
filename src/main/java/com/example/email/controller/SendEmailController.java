package com.example.email.controller;

import com.example.email.entity.EmailRequest;
import com.example.email.entity.MailResponse;
import com.example.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Khairul Islam Azam
 * @since 1.0.0
 */
@RestController
public class SendEmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/sendMail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MailResponse sendEmail(@RequestBody EmailRequest emailRequest){
           return emailService.sendMail(emailRequest.getToMail(), emailRequest.getFromMail(),
                   emailRequest.getSubject(),emailRequest.getBody());
    }

}
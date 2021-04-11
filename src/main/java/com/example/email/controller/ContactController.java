package com.example.email.controller;

import com.example.email.entity.EmailRequest;
import com.example.email.service.EmailSenderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Khairul Islam Azam
 * @created 08/04/2021 - 5:11 PM
 * @project email send with spring boot
 */
@RestController
public class ContactController {

    private final EmailSenderService emailSenderService;

    public ContactController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/mailSend")
    public boolean sendMail(@RequestBody EmailRequest emailRequest)
    {
        return emailSenderService.sendSimpleMail(emailRequest.getTo(),emailRequest.getSubject(),
                emailRequest.getBody());
    }

    @PostMapping("/mailSendWithAttachment")
    public boolean sendMailWithAttachment(@RequestBody EmailRequest emailRequest)
    {
        return emailSenderService.sendMailWithAttachment(emailRequest.getTo(),emailRequest.getSubject(),
                emailRequest.getBody(),emailRequest.getAttachment());
    }
}

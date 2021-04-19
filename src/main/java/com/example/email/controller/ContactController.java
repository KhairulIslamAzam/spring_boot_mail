//package com.example.email.controller;
//
//import com.example.email.entity.EmailRequest;
////import com.example.email.service.EmailSenderService;
//import com.example.email.service.EmailSenderService;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Khairul Islam Azam
// * @created 08/04/2021 - 5:11 PM
// * @project email send with spring boot
// */
//@RestController
//public class ContactController {
//
//    private final EmailSenderService emailSenderService;
//
//    public ContactController(EmailSenderService emailSenderService) {
//        this.emailSenderService = emailSenderService;
//    }
////    private final EmailService service;
//
//
//    @PostMapping("/mailSend")
//    public boolean sendMail(@RequestBody EmailRequest emailRequest)
//    {
//        return emailSenderService.sendSimpleMail(emailRequest.getTo(),emailRequest.getSubject(),
//                emailRequest.getBody());
//    }
////
////    @PostMapping("/mailSendWithAttachment")
////    public boolean sendMailWithAttachment(@RequestBody EmailRequest emailRequest) throws IOException, InterruptedException {
////
////        return emailSenderService.sendMailWithAttachment(emailRequest.getTo(),emailRequest.getSubject(),
////                emailRequest.getBody(),emailRequest.getAttachment());
////
////    }
//
//
////    @PostMapping("/sendingEmail")
////    public MailResponse sendEmail(@RequestBody MailRequest request) {
////        Map<String, Object> model = new HashMap<>();
////        model.put("Name", request.getName());
////        model.put("location", "Bangalore,India");
////        return service.sendEmail(request, model);
////
////    }
//}

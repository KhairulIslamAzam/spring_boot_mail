package com.example.email.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Khairul Islam Azam
 * @created 08/04/2021 - 5:11 PM
 * @project IntelliJ IDEA
 */
@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showContactForm(){
        return "contact_form";
    }
}

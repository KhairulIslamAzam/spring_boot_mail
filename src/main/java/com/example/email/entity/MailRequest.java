package com.example.email.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author Khairul Islam Azam
 * @created 11/04/2021 - 6:03 PM
 * @project email send with spring boot
 */

@Setter
@Getter
public class MailRequest {

    private String subject;
    private String to;
    private String from;
    private Map<String, String> body;


}
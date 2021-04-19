package com.example.email.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Khairul Islam Azam
 * @created 11/04/2021 - 6:03 PM
 * @project email send with spring boot
 */

@Setter
@Getter
public class MailRequest {

    private String name;
    private String to;
    private String from;
    private String subject;

}
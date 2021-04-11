package com.example.email.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Khairul Islam Azam
 * @created 10/04/2021 - 4:56 PM
 * @project IntelliJ IDEA
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {
    private String to;
    private String from;
    private String subject;
    private String body;
    private String attachment;
}

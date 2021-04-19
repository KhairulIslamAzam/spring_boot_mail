package com.example.email.entity;

import lombok.*;

/**
 * @author Khairul Islam Azam
 * @since 1.0.0
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MailResponse {

    private String message;
    private boolean status;

}
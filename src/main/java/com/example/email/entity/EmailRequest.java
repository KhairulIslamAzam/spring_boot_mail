package com.example.email.entity;

import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author Khairul Islam Azam
 * @created 10/04/2021 - 4:56 PM
 * @project email send with spring boot
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest implements Serializable {
    private String toMail;
    private String fromMail;
    private String subject;
    private String body;
//    private String path;
    //  private List<Byte[]> attachment;
//    private MultipartFile [] files;
}

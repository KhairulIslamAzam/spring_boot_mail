//package com.example.email.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
//
///**
// * @author Khairul Islam Azam
// * @created 11/04/2021 - 5:56 PM
// * @project email send with spring boot
// */
//
//@Configuration
//public class ApiConfig {
//
//    @Primary
//    @Bean
//    public FreeMarkerConfigurationFactoryBean factoryBean() {
//        FreeMarkerConfigurationFactoryBean bean=new FreeMarkerConfigurationFactoryBean();
//        bean.setTemplateLoaderPath("classpath:/templates");
//        return bean;
//    }
//
//}
package com.example.jpapractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링부트의 자동 설정, 스프링 bean 읽기, 생성을 모두 자동으로 설정 - 해당 어노테이션부터 설정 읽음
public class JpaPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaPracticeApplication.class, args);
    }

}

package com.hjh.test.protocolbuffer.demo;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }


    @RequestMapping(value = { "/login" })
    public ResponseEntity<UserRes> login(HttpServletRequest httpServletRequest) {

        UserRes response = new UserRes();
        response.setStat(1000);
        response.setMess("111111");
        return ResponseEntity.ok(response);
    }

    @Data
    public static class RegShopReq{
        private int stat;

        private String data;
    }

    @Data
    public static class UserRes{
        private int stat;

        private String mess;
    }
}

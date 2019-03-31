package com.hjh.test.protocolbuffer.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.JsonContentAssert;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//    @Bean
//    RestTemplate restTemplate() {
//        RestTemplate rt = new RestTemplate();
//        rt.getMessageConverters().add(new ProtobufHttpMessageConverter());
//        return rt;
//    }

    @Test
    public void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new ProtobufHttpMessageConverter());

        DemoApplication.UserRes forObject = restTemplate.getForObject("http://127.0.0.1:8080/login",
                DemoApplication.UserRes.class);

        System.out.println(forObject.getMess());

    }

}

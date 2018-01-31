package com.shaoye.cloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @param
 * @Author: ShaoYe
 * @Description:
 * @Date:
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer(){
        return restTemplate.getForEntity("http://hello-server/test/hello",String.class).getBody();
    }
}

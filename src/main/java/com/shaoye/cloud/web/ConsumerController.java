package com.shaoye.cloud.web;

import com.shaoye.cloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @Author: ShaoYe
 * @Description:
 * @Date:
 */
@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer(){
        return helloService.helloService();
    }
}

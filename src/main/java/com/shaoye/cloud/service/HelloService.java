package com.shaoye.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * @param
 * @Author: ShaoYe
 * @Description:
 * @Date:
 */
@Service
public class HelloService {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback",commandKey = "helloKey")
    public String helloService(){
        long start =System.currentTimeMillis();

        //消费服务逻辑
        String result = restTemplate.getForEntity("http://hello-server/test/hello",String.class).getBody();

        long end = System.currentTimeMillis();
        logger.info("Spend time："+(end-start));
        return result.toString();

    }

    public String helloFallback(){
        return "error";
    }
}

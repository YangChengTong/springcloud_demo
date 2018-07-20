package com.forezp.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    //通过调用restTemplate.getForObject 访问服务注册中心注册了的服务时已经做了负载均衡，可以访问不同端口的服务。
    @Autowired
    RestTemplate restTemplate;

    //HystrixCommand 对当前方法创建了熔断器功能，当这个方法请求其它服务响应超时时自动执行快速失败，直接返回指定的hiError方法，而不是等待响应超时，造成线程阻塞
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi,"+ name +",sorry error!";
    }
}

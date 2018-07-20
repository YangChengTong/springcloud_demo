package com.forezp.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient  指定调用哪个服务,fallback 当服务调用超时时回滚到指定的位置进行响应
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    //FeignClient服务的hi接口
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClienOne(@RequestParam(value = "name") String name);
}

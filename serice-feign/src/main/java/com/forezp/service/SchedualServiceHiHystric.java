package com.forezp.service;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClienOne(String name) {
        return "Sorry," + name;
    }
}

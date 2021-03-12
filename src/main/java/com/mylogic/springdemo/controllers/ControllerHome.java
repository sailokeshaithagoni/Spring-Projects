package com.mylogic.springdemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHome {

    private static final Logger log = LoggerFactory.getLogger(ControllerHome.class);

    @RequestMapping(path = "api/",method = RequestMethod.GET)
    public String Welcome()
    {
        return "<center><b>Welcome to the springdemo!!!</b></center>";
    }
}

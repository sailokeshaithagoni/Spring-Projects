package com.example.mongodb.controllers;

import com.example.mongodb.dataaccess.MongoDBClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(path = "api/HomeController/test", method = RequestMethod.GET)
    public String testService()
    {
        String writeResult= MongoDBClient.getDbConnection();
           return writeResult;
    }
}

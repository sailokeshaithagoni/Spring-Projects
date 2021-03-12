package com.mylogic.springdemo.controllers;

import com.mylogic.springdemo.dataaccess.ClientMongoDB;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerMongoDb {

    @RequestMapping(path = "api/Mongodbclient/connection", method = RequestMethod.GET)
    public String mongoDbConnection()
    {
        String writeResult= ClientMongoDB.getDbConnection();
        return writeResult;
    }
}

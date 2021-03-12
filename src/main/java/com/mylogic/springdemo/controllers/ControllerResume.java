package com.mylogic.springdemo.controllers;

import com.mylogic.springdemo.business.ServiceInterfaceGitUserData;
import com.mylogic.springdemo.models.GitResumeDtoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class ControllerResume {

    private static final Logger log = LoggerFactory.getLogger(ControllerResume.class);

    @Autowired
    private ServiceInterfaceGitUserData serviceInterfaceGitUserData;

    @RequestMapping(path = "api/ControllerResume/GetResume/{gitHubID}", method = RequestMethod.GET)
    public GitResumeDtoResponse GetGitResume(@PathVariable String gitHubID) throws IOException {
        return serviceInterfaceGitUserData.getResume(gitHubID);
    }
}

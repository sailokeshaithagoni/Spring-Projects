package com.mylogic.springdemo.business;

import com.mylogic.springdemo.models.GitResumeDtoResponse;

import java.io.IOException;

public interface ServiceInterfaceGitUserData {
    public GitResumeDtoResponse getResume(String GitHubID) throws IOException;
}

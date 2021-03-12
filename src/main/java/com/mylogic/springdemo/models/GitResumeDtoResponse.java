package com.mylogic.springdemo.models;


public class GitResumeDtoResponse extends BaseResponse {
    private GitResumeDto gitResumeDto;

    public GitResumeDto getGitResumeDto() {
        return gitResumeDto;
    }

    public void setGitResumeDto(GitResumeDto gitResumeDto) {
        this.gitResumeDto = gitResumeDto;
    }
}

package com.mylogic.springdemo.models;

import java.util.List;

public class GitResumeDto {
    private String username;
    private String link_of_website;
    private String link_of_profile_picture;

    public String getLink_of_profile_picture() {
        return link_of_profile_picture;
    }

    public void setLink_of_profile_picture(String link_of_profile_picture) {
        this.link_of_profile_picture = link_of_profile_picture;
    }

    public String getLink_of_website() {
        return link_of_website;
    }

    public void setLink_of_website(String link_of_website) {
        this.link_of_website = link_of_website;
    }

    private Integer number_of_repos;
    private List<RepositoriesDto> listRepositories;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getNumber_of_repos() {
        return number_of_repos;
    }

    public void setNumber_of_repos(Integer number_of_repos) {
        this.number_of_repos = number_of_repos;
    }

    public List<RepositoriesDto> getListRepositories() {
        return listRepositories;
    }

    public void setListRepositories(List<RepositoriesDto> listRepositories) {
        this.listRepositories = listRepositories;
    }
}

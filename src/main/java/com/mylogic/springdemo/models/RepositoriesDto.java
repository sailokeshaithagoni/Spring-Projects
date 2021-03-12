package com.mylogic.springdemo.models;

public class RepositoriesDto {
    private String repository_name;
    private String repository_link;
    private String repository_description;

    public String getRepository_name() {
        return repository_name;
    }

    public void setRepository_name(String repository_name) {
        this.repository_name = repository_name;
    }

    public String getRepository_link() {
        return repository_link;
    }

    public void setRepository_link(String repository_link) {
        this.repository_link = repository_link;
    }

    public String getRepository_description() {
        return repository_description;
    }

    public void setRepository_description(String repository_description) {
        this.repository_description = repository_description;
    }
}

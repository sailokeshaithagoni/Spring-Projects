package com.mylogic.springdemo.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mylogic.springdemo.models.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClassGitUserData implements ServiceInterfaceGitUserData {
    ObjectMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(ServiceClassGitUserData.class);
    @Override
    public GitResumeDtoResponse getResume(String gitHubID) throws IOException {
        GitResumeDtoResponse gitResumeDtoResponse=new GitResumeDtoResponse();
        try {
            GitResumeDto gitResumeDto = new GitResumeDto();
            mapper = new ObjectMapper();
            GitUserInfoDto gitUserInfoDto = mapper.readValue(EntityUtils.toString(getHttpResponse("https://api.github.com/users/" + gitHubID).getEntity()), GitUserInfoDto.class);

            if (gitUserInfoDto.name != null) {
                gitResumeDto.setUsername(gitUserInfoDto.getName());
                gitResumeDto.setLink_of_website(gitUserInfoDto.getBlog());
                gitResumeDto.setNumber_of_repos(gitUserInfoDto.getPublic_repos());
                gitResumeDto.setLink_of_profile_picture(gitUserInfoDto.getAvatar_url());
                gitResumeDto.setListRepositories(getReposlist(gitHubID));
                gitResumeDtoResponse.setGitResumeDto(gitResumeDto);
            } else {
                gitResumeDtoResponse.setErrorDescription("Probably User Not Found");
            }
            return gitResumeDtoResponse;
        }
        catch (Exception ex)
        {
            gitResumeDtoResponse.setErrorDescription(ex.getMessage());
            return gitResumeDtoResponse;
        }
    }

    private List<RepositoriesDto> getReposlist(String gitHubID)
    {
        try {
            GitRepositoriesInfoDto[] gitRepositoriesInfoDtosArray =mapper.readValue(EntityUtils.toString(getHttpResponse("https://api.github.com/users/" + gitHubID + "/repos").getEntity()),GitRepositoriesInfoDto[].class);
            List<RepositoriesDto> repositoriesDtos=new ArrayList<>();

            for (GitRepositoriesInfoDto gitRepositoriesInfoDto : gitRepositoriesInfoDtosArray) {
                RepositoriesDto repositoriesDto=new RepositoriesDto();
                repositoriesDto.setRepository_name(gitRepositoriesInfoDto.getName());
                repositoriesDto.setRepository_description(String.valueOf(gitRepositoriesInfoDto.getDescription()));
                repositoriesDto.setRepository_link(gitRepositoriesInfoDto.getClone_url());
                repositoriesDtos.add(repositoriesDto);
            }

            return repositoriesDtos;
       }
        catch (Exception ex)
        {
            return null;
        }
    }

    private HttpResponse getHttpResponse(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        return httpclient.execute(httpget);
    }
}

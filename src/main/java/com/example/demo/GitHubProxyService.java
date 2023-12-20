package com.example.demo;

import com.example.demo.dto.GitBranch;
import com.example.demo.dto.GitRepository;
import com.example.demo.dto.GitRepositoryRules;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class GitHubProxyService {
    public static final String USER_REPOS = "/users/{username}/repos";
    public static final String GET_ALL_BRANCHES_FOR_REPO = "/repos/{owner}/{repo}/branches";
    public static final String GET_BRANCH_PROTECTION = "/repos/{owner}/{repo}/branches/{branch}/protection";
    public static final String X_GIT_HUB_API_VERSION = "X-GitHub-Api-Version";
    public static final String X_GIT_HUB_API_VERSION_VALUE = "2022-11-28";
    private final String GITHUB_API_URL = "https://api.github.com";
    private final WebClient webClient = WebClient.builder().baseUrl(GITHUB_API_URL).build();

    public List<GitRepository> getAllReposForUser(String username, String githubAPIToken) {
        return webClient.get().uri(USER_REPOS, username)
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(Collections.singletonList(APPLICATION_JSON));
                    httpHeaders.add(X_GIT_HUB_API_VERSION, X_GIT_HUB_API_VERSION_VALUE);
                    httpHeaders.setBearerAuth(githubAPIToken);
                })
                .retrieve().bodyToFlux(GitRepository.class)
                .collect(Collectors.toList())
                .share().block();
    }

    public List<GitBranch> getGetAllBranchesForRepo(String username, String repositoryName, String githubAPIToken) {
        return webClient.get().uri(GET_ALL_BRANCHES_FOR_REPO, username, repositoryName)
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(Collections.singletonList(APPLICATION_JSON));
                    httpHeaders.add(X_GIT_HUB_API_VERSION, X_GIT_HUB_API_VERSION_VALUE);
                    httpHeaders.setBearerAuth(githubAPIToken);
                })
                .retrieve().bodyToFlux(GitBranch.class)
                .collect(Collectors.toList())
                .share().block();
    }

    public GitRepositoryRules getBranchProtectionRules(String username, String repositoryName, String branchName, String githubAPIToken) {
        return webClient.get().uri(GET_BRANCH_PROTECTION, username, repositoryName, branchName)
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(Collections.singletonList(APPLICATION_JSON));
                    httpHeaders.add(X_GIT_HUB_API_VERSION, X_GIT_HUB_API_VERSION_VALUE);
                    httpHeaders.setBearerAuth(githubAPIToken);
                })
                .retrieve().bodyToMono(GitRepositoryRules.class).block();
    }

}

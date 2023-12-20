package com.example.demo;

import com.example.demo.dto.Branch;
import com.example.demo.dto.GitBranch;
import com.example.demo.dto.GitRepository;
import com.example.demo.dto.GitRepositoryRules;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@AllArgsConstructor
public class GitHubController {
    private final RulesConfig rulesConfig;
    private final GitHubProxyService gitHubProxyService;

    @GetMapping("/nonCompliance/{username}/repos")
    public Map<String, List<String>> validateGitHubRepos(@PathVariable String username,
                                                         @RequestHeader(value = "github_api_token") String githubAPIToken) {
        Map<String, List<String>> nonComplianceBranches = new HashMap<>();
        // Fetch All repos for the user and loop over them
        for (GitRepository gitRepository : gitHubProxyService.getAllReposForUser(username, githubAPIToken)) {
            // For every repo check if rules have been configured for that repo in the rules configuration
            if (rulesConfig.getBranches().containsKey(gitRepository.getName())) {
                System.out.println("Validating repo: " + gitRepository.getName());

                // Fetch all the branches for the repo
                for (GitBranch gitBranch : gitHubProxyService.getGetAllBranchesForRepo(username, gitRepository.getName(), githubAPIToken)) {
                    // check if the rules have been configured for the branch in yml file
                    List<String> patterns = rulesConfig.getBranches().get(gitRepository.getName()).getPatterns();
                    for (String patternStr : patterns) {
                        Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
                        Matcher matcher = pattern.matcher(gitBranch.getName());
                        if (matcher.find()) {
                            // rules are configured for this branch
                            System.out.println("Rules configuration found for branch: " + gitBranch.getName());

                            // Fetch the branch protection rules
                            GitRepositoryRules repositoryRules = gitHubProxyService.getBranchProtectionRules(username, gitRepository.getName(), gitBranch.getName(), githubAPIToken);

                            // Validate branch rules against yml rules
                            Branch branchRules = rulesConfig.getBranches().get(gitRepository.getName());
                            if (branchRules.getRequireReviewCount() != repositoryRules.getRequiredPullRequestReviews().getRequiredApprovingReviewCount()
                            || branchRules.isDismissStaleReviews() != repositoryRules.getRequiredPullRequestReviews().getDismissStaleReviews()
                            || branchRules.isRequireCodeOwnerReview() != repositoryRules.getRequiredPullRequestReviews().getRequireCodeOwnerReviews()
                            || branchRules.isRequireBranchUpToDate() != repositoryRules.getLockBranch().getEnabled()
                            || branchRules.isIncludeAdmin() != repositoryRules.getEnforceAdmins().getEnabled()
                            || branchRules.isRequireLinearHistory() != repositoryRules.getRequiredLinearHistory().getEnabled()
                            || branchRules.isAllowProtectedBranchDelete() != repositoryRules.getAllowDeletions().getEnabled()
                            || gitBranch.getProtection().getRequiredStatusChecks().getContexts().containsAll(branchRules.getRequiredStatusChecks())
                            ) {
                                //System.out.println("Review Count miss match");
                                nonComplianceBranches.computeIfAbsent(gitRepository.getName(),
                                        gitRepo -> new ArrayList<>()).add(gitBranch.getName());
                            }
                        }
                    }
                }
            }
        }
        return nonComplianceBranches;
    }
}

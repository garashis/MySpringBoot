
package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "required_pull_request_reviews",
    "required_signatures",
    "enforce_admins",
    "required_linear_history",
    "allow_force_pushes",
    "allow_deletions",
    "block_creations",
    "required_conversation_resolution",
    "lock_branch",
    "allow_fork_syncing"
})
public class GitRepositoryRules {

    @JsonProperty("url")
    private String url;
    @JsonProperty("required_pull_request_reviews")
    private RequiredPullRequestReviews requiredPullRequestReviews;
    @JsonProperty("required_signatures")
    private RequiredSignatures requiredSignatures;
    @JsonProperty("enforce_admins")
    private EnforceAdmins enforceAdmins;
    @JsonProperty("required_linear_history")
    private RequiredLinearHistory requiredLinearHistory;
    @JsonProperty("allow_force_pushes")
    private AllowForcePushes allowForcePushes;
    @JsonProperty("allow_deletions")
    private AllowDeletions allowDeletions;
    @JsonProperty("block_creations")
    private BlockCreations blockCreations;
    @JsonProperty("required_conversation_resolution")
    private RequiredConversationResolution requiredConversationResolution;
    @JsonProperty("lock_branch")
    private LockBranch lockBranch;
    @JsonProperty("allow_fork_syncing")
    private AllowForkSyncing allowForkSyncing;
    @JsonIgnore
    

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("required_pull_request_reviews")
    public RequiredPullRequestReviews getRequiredPullRequestReviews() {
        return requiredPullRequestReviews;
    }

    @JsonProperty("required_pull_request_reviews")
    public void setRequiredPullRequestReviews(RequiredPullRequestReviews requiredPullRequestReviews) {
        this.requiredPullRequestReviews = requiredPullRequestReviews;
    }

    @JsonProperty("required_signatures")
    public RequiredSignatures getRequiredSignatures() {
        return requiredSignatures;
    }

    @JsonProperty("required_signatures")
    public void setRequiredSignatures(RequiredSignatures requiredSignatures) {
        this.requiredSignatures = requiredSignatures;
    }

    @JsonProperty("enforce_admins")
    public EnforceAdmins getEnforceAdmins() {
        return enforceAdmins;
    }

    @JsonProperty("enforce_admins")
    public void setEnforceAdmins(EnforceAdmins enforceAdmins) {
        this.enforceAdmins = enforceAdmins;
    }

    @JsonProperty("required_linear_history")
    public RequiredLinearHistory getRequiredLinearHistory() {
        return requiredLinearHistory;
    }

    @JsonProperty("required_linear_history")
    public void setRequiredLinearHistory(RequiredLinearHistory requiredLinearHistory) {
        this.requiredLinearHistory = requiredLinearHistory;
    }

    @JsonProperty("allow_force_pushes")
    public AllowForcePushes getAllowForcePushes() {
        return allowForcePushes;
    }

    @JsonProperty("allow_force_pushes")
    public void setAllowForcePushes(AllowForcePushes allowForcePushes) {
        this.allowForcePushes = allowForcePushes;
    }

    @JsonProperty("allow_deletions")
    public AllowDeletions getAllowDeletions() {
        return allowDeletions;
    }

    @JsonProperty("allow_deletions")
    public void setAllowDeletions(AllowDeletions allowDeletions) {
        this.allowDeletions = allowDeletions;
    }

    @JsonProperty("block_creations")
    public BlockCreations getBlockCreations() {
        return blockCreations;
    }

    @JsonProperty("block_creations")
    public void setBlockCreations(BlockCreations blockCreations) {
        this.blockCreations = blockCreations;
    }

    @JsonProperty("required_conversation_resolution")
    public RequiredConversationResolution getRequiredConversationResolution() {
        return requiredConversationResolution;
    }

    @JsonProperty("required_conversation_resolution")
    public void setRequiredConversationResolution(RequiredConversationResolution requiredConversationResolution) {
        this.requiredConversationResolution = requiredConversationResolution;
    }

    @JsonProperty("lock_branch")
    public LockBranch getLockBranch() {
        return lockBranch;
    }

    @JsonProperty("lock_branch")
    public void setLockBranch(LockBranch lockBranch) {
        this.lockBranch = lockBranch;
    }

    @JsonProperty("allow_fork_syncing")
    public AllowForkSyncing getAllowForkSyncing() {
        return allowForkSyncing;
    }

    @JsonProperty("allow_fork_syncing")
    public void setAllowForkSyncing(AllowForkSyncing allowForkSyncing) {
        this.allowForkSyncing = allowForkSyncing;
    }
}

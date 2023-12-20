
package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequiredPullRequestReviews {

    private String url;
    private boolean dismissStaleReviews;
    private boolean requireCodeOwnerReviews;
    private boolean requireLastPushApproval;
    private Integer requiredApprovingReviewCount;
    @JsonIgnore


    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("dismiss_stale_reviews")
    public boolean getDismissStaleReviews() {
        return dismissStaleReviews;
    }

    @JsonProperty("dismiss_stale_reviews")
    public void setDismissStaleReviews(boolean dismissStaleReviews) {
        this.dismissStaleReviews = dismissStaleReviews;
    }

    @JsonProperty("require_code_owner_reviews")
    public boolean getRequireCodeOwnerReviews() {
        return requireCodeOwnerReviews;
    }

    @JsonProperty("require_code_owner_reviews")
    public void setRequireCodeOwnerReviews(boolean requireCodeOwnerReviews) {
        this.requireCodeOwnerReviews = requireCodeOwnerReviews;
    }

    @JsonProperty("require_last_push_approval")
    public boolean getRequireLastPushApproval() {
        return requireLastPushApproval;
    }

    @JsonProperty("require_last_push_approval")
    public void setRequireLastPushApproval(boolean requireLastPushApproval) {
        this.requireLastPushApproval = requireLastPushApproval;
    }

    @JsonProperty("required_approving_review_count")
    public Integer getRequiredApprovingReviewCount() {
        return requiredApprovingReviewCount;
    }

    @JsonProperty("required_approving_review_count")
    public void setRequiredApprovingReviewCount(Integer requiredApprovingReviewCount) {
        this.requiredApprovingReviewCount = requiredApprovingReviewCount;
    }
}

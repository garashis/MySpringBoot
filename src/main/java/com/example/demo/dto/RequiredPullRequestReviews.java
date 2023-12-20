
package com.example;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "dismiss_stale_reviews",
    "require_code_owner_reviews",
    "require_last_push_approval",
    "required_approving_review_count"
})
@Generated("jsonschema2pojo")
public class RequiredPullRequestReviews {

    @JsonProperty("url")
    private String url;
    @JsonProperty("dismiss_stale_reviews")
    private Boolean dismissStaleReviews;
    @JsonProperty("require_code_owner_reviews")
    private Boolean requireCodeOwnerReviews;
    @JsonProperty("require_last_push_approval")
    private Boolean requireLastPushApproval;
    @JsonProperty("required_approving_review_count")
    private Integer requiredApprovingReviewCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("dismiss_stale_reviews")
    public Boolean getDismissStaleReviews() {
        return dismissStaleReviews;
    }

    @JsonProperty("dismiss_stale_reviews")
    public void setDismissStaleReviews(Boolean dismissStaleReviews) {
        this.dismissStaleReviews = dismissStaleReviews;
    }

    @JsonProperty("require_code_owner_reviews")
    public Boolean getRequireCodeOwnerReviews() {
        return requireCodeOwnerReviews;
    }

    @JsonProperty("require_code_owner_reviews")
    public void setRequireCodeOwnerReviews(Boolean requireCodeOwnerReviews) {
        this.requireCodeOwnerReviews = requireCodeOwnerReviews;
    }

    @JsonProperty("require_last_push_approval")
    public Boolean getRequireLastPushApproval() {
        return requireLastPushApproval;
    }

    @JsonProperty("require_last_push_approval")
    public void setRequireLastPushApproval(Boolean requireLastPushApproval) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

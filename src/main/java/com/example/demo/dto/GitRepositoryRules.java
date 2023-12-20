
package com.example;

import java.util.LinkedHashMap;
import java.util.List;
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
    "total_count",
    "custom_deployment_protection_rules"
})
@Generated("jsonschema2pojo")
public class GitRepositoryRules {

    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("custom_deployment_protection_rules")
    private List<CustomDeploymentProtectionRule> customDeploymentProtectionRules;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("total_count")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("total_count")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("custom_deployment_protection_rules")
    public List<CustomDeploymentProtectionRule> getCustomDeploymentProtectionRules() {
        return customDeploymentProtectionRules;
    }

    @JsonProperty("custom_deployment_protection_rules")
    public void setCustomDeploymentProtectionRules(List<CustomDeploymentProtectionRule> customDeploymentProtectionRules) {
        this.customDeploymentProtectionRules = customDeploymentProtectionRules;
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

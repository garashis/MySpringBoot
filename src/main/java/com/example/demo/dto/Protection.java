
package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "required_status_checks"
})

public class Protection {

    @JsonProperty("required_status_checks")
    private RequiredStatusChecks requiredStatusChecks;

    @JsonIgnore


    @JsonProperty("required_status_checks")
    public RequiredStatusChecks getRequiredStatusChecks() {
        return requiredStatusChecks;
    }

    @JsonProperty("required_status_checks")
    public void setRequiredStatusChecks(RequiredStatusChecks requiredStatusChecks) {
        this.requiredStatusChecks = requiredStatusChecks;
    }
}
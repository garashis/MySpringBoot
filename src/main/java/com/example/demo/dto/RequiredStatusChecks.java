
package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enforcement_level",
    "contexts"
})

public class RequiredStatusChecks {

    @JsonProperty("enforcement_level")
    private String enforcementLevel;
    @JsonProperty("contexts")
    private List<String> contexts;
    @JsonIgnore
    

    @JsonProperty("enforcement_level")
    public String getEnforcementLevel() {
        return enforcementLevel;
    }

    @JsonProperty("enforcement_level")
    public void setEnforcementLevel(String enforcementLevel) {
        this.enforcementLevel = enforcementLevel;
    }

    @JsonProperty("contexts")
    public List<String> getContexts() {
        return contexts;
    }

    @JsonProperty("contexts")
    public void setContexts(List<String> contexts) {
        this.contexts = contexts;
    }

}

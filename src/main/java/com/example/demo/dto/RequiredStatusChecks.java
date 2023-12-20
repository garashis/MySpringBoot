
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
    "enforcement_level",
    "contexts"
})
@Generated("jsonschema2pojo")
public class RequiredStatusChecks {

    @JsonProperty("enforcement_level")
    private String enforcementLevel;
    @JsonProperty("contexts")
    private List<String> contexts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

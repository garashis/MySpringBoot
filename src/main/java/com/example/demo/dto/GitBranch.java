
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
    "name",
    "commit",
    "protected",
    "protection",
    "protection_url"
})
@Generated("jsonschema2pojo")
public class GitBranch {

    @JsonProperty("name")
    private String name;
    @JsonProperty("commit")
    private Commit commit;
    @JsonProperty("protected")
    private Boolean _protected;
    @JsonProperty("protection")
    private Protection protection;
    @JsonProperty("protection_url")
    private String protectionUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("commit")
    public Commit getCommit() {
        return commit;
    }

    @JsonProperty("commit")
    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    @JsonProperty("protected")
    public Boolean getProtected() {
        return _protected;
    }

    @JsonProperty("protected")
    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

    @JsonProperty("protection")
    public Protection getProtection() {
        return protection;
    }

    @JsonProperty("protection")
    public void setProtection(Protection protection) {
        this.protection = protection;
    }

    @JsonProperty("protection_url")
    public String getProtectionUrl() {
        return protectionUrl;
    }

    @JsonProperty("protection_url")
    public void setProtectionUrl(String protectionUrl) {
        this.protectionUrl = protectionUrl;
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


package com.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Enable or disable Dependabot security updates for the repository.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status"
})
@Generated("jsonschema2pojo")
public class DependabotSecurityUpdates {

    /**
     * The enablement status of Dependabot security updates for the repository.
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("The enablement status of Dependabot security updates for the repository.")
    private DependabotSecurityUpdates.Status status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * The enablement status of Dependabot security updates for the repository.
     * 
     */
    @JsonProperty("status")
    public DependabotSecurityUpdates.Status getStatus() {
        return status;
    }

    /**
     * The enablement status of Dependabot security updates for the repository.
     * 
     */
    @JsonProperty("status")
    public void setStatus(DependabotSecurityUpdates.Status status) {
        this.status = status;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    /**
     * The enablement status of Dependabot security updates for the repository.
     * 
     */
    @Generated("jsonschema2pojo")
    public enum Status {

        ENABLED("enabled"),
        DISABLED("disabled");
        private final String value;
        private final static Map<String, DependabotSecurityUpdates.Status> CONSTANTS = new HashMap<String, DependabotSecurityUpdates.Status>();

        static {
            for (DependabotSecurityUpdates.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static DependabotSecurityUpdates.Status fromValue(String value) {
            DependabotSecurityUpdates.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}

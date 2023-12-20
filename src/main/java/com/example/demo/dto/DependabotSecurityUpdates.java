
package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;


/**
 * Enable or disable Dependabot security updates for the repository.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status"
})
public class DependabotSecurityUpdates {

    /**
     * The enablement status of Dependabot security updates for the repository.
     *
     */
    @JsonProperty("status")
    @JsonPropertyDescription("The enablement status of Dependabot security updates for the repository.")
    private Status status;
    @JsonIgnore


    /**
     * The enablement status of Dependabot security updates for the repository.
     *
     */
    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    /**
     * The enablement status of Dependabot security updates for the repository.
     *
     */
    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }






    /**
     * The enablement status of Dependabot security updates for the repository.
     *
     */
    public enum Status {

        ENABLED("enabled"),
        DISABLED("disabled");
        private final String value;
        private final static Map<String, Status> CONSTANTS = new HashMap<String, Status>();

        static {
            for (Status c: values()) {
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
        public static Status fromValue(String value) {
            Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}

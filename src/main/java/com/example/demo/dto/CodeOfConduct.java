
package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.net.URI;


/**
 * Code Of Conduct
 * <p>
 * Code Of Conduct
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "name",
    "url",
    "body",
    "html_url"
})
public class CodeOfConduct {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("key")
    private String key;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("name")
    private String name;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("url")
    private URI url;
    @JsonProperty("body")
    private String body;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("html_url")
    private URI htmlUrl;
    @JsonIgnore


    /**
     *
     * (Required)
     *
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("html_url")
    public URI getHtmlUrl() {
        return htmlUrl;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("html_url")
    public void setHtmlUrl(URI htmlUrl) {
        this.htmlUrl = htmlUrl;
    }





}

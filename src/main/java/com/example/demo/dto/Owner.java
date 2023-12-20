
package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.net.URI;


/**
 * Simple User
 * <p>
 * A GitHub user.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "email",
    "login",
    "id",
    "node_id",
    "avatar_url",
    "gravatar_id",
    "url",
    "html_url",
    "followers_url",
    "following_url",
    "gists_url",
    "starred_url",
    "subscriptions_url",
    "organizations_url",
    "repos_url",
    "events_url",
    "received_events_url",
    "type",
    "site_admin",
    "starred_at"
})
public class Owner {

    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("login")
    private String login;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("node_id")
    private String nodeId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("avatar_url")
    private URI avatarUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("gravatar_id")
    private String gravatarId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("url")
    private URI url;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("html_url")
    private URI htmlUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("followers_url")
    private URI followersUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("following_url")
    private String followingUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("gists_url")
    private String gistsUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("starred_url")
    private String starredUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("subscriptions_url")
    private URI subscriptionsUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("organizations_url")
    private URI organizationsUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("repos_url")
    private URI reposUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("events_url")
    private String eventsUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("received_events_url")
    private URI receivedEventsUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("site_admin")
    private Boolean siteAdmin;
    @JsonProperty("starred_at")
    private String starredAt;
    @JsonIgnore
    

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("node_id")
    public String getNodeId() {
        return nodeId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("node_id")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("avatar_url")
    public URI getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("avatar_url")
    public void setAvatarUrl(URI avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("gravatar_id")
    public String getGravatarId() {
        return gravatarId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("gravatar_id")
    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
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

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("followers_url")
    public URI getFollowersUrl() {
        return followersUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("followers_url")
    public void setFollowersUrl(URI followersUrl) {
        this.followersUrl = followersUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("following_url")
    public String getFollowingUrl() {
        return followingUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("following_url")
    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("gists_url")
    public String getGistsUrl() {
        return gistsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("gists_url")
    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("starred_url")
    public String getStarredUrl() {
        return starredUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("starred_url")
    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("subscriptions_url")
    public URI getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("subscriptions_url")
    public void setSubscriptionsUrl(URI subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("organizations_url")
    public URI getOrganizationsUrl() {
        return organizationsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("organizations_url")
    public void setOrganizationsUrl(URI organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("repos_url")
    public URI getReposUrl() {
        return reposUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("repos_url")
    public void setReposUrl(URI reposUrl) {
        this.reposUrl = reposUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("events_url")
    public String getEventsUrl() {
        return eventsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("events_url")
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("received_events_url")
    public URI getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("received_events_url")
    public void setReceivedEventsUrl(URI receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("site_admin")
    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("site_admin")
    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    @JsonProperty("starred_at")
    public String getStarredAt() {
        return starredAt;
    }

    @JsonProperty("starred_at")
    public void setStarredAt(String starredAt) {
        this.starredAt = starredAt;
    }

    

    

}

package com.malouane.data.remote.model.venue;

import com.squareup.moshi.Json;
import java.util.List;

public class HereNowRemote {
    @Json(name = "count")
    private Integer count;
    @Json(name = "summary")
    private String summary;
    @Json(name = "groups")
    private List<Object> groups = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

}

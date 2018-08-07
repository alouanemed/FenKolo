package com.malouane.data.remote.model.venue;

import com.squareup.moshi.*;

public class BeenHere {

    @Json(name = "count")
    private Integer count;
    @Json(name = "lastCheckinExpiredAt")
    private Integer lastCheckinExpiredAt;
    @Json(name = "marked")
    private Boolean marked;
    @Json(name = "unconfirmedCount")
    private Integer unconfirmedCount;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLastCheckinExpiredAt() {
        return lastCheckinExpiredAt;
    }

    public void setLastCheckinExpiredAt(Integer lastCheckinExpiredAt) {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    public Integer getUnconfirmedCount() {
        return unconfirmedCount;
    }

    public void setUnconfirmedCount(Integer unconfirmedCount) {
        this.unconfirmedCount = unconfirmedCount;
    }

}

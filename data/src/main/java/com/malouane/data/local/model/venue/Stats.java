package com.malouane.data.local.model.venue;

import com.squareup.moshi.Json;

public class Stats {

    @Json(name = "tipCount")
    private Integer tipCount;
    @Json(name = "usersCount")
    private Integer usersCount;
    @Json(name = "checkinsCount")
    private Integer checkinsCount;
    @Json(name = "visitsCount")
    private Integer visitsCount;

    public Integer getTipCount() {
        return tipCount;
    }

    public void setTipCount(Integer tipCount) {
        this.tipCount = tipCount;
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public Integer getCheckinsCount() {
        return checkinsCount;
    }

    public void setCheckinsCount(Integer checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    public Integer getVisitsCount() {
        return visitsCount;
    }

    public void setVisitsCount(Integer visitsCount) {
        this.visitsCount = visitsCount;
    }

}

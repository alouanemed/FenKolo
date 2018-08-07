package com.malouane.data.remote.api.util;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;     ;
import java.text.SimpleDateFormat;
import org.jetbrains.annotations.*;

import java.text.*;
import java.util.*;

public class MoshiConverters {
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());

    @FromJson
    @Nullable
    public final Date timestampToDate(@Nullable String value) throws ParseException {
        return value == null ? null : this.format.parse(value);
    }

    @ToJson
    @Nullable
    public final String dateToTimestamp(@Nullable Date date) {
        return date != null ? this.format.format(date) : null;
    }
}

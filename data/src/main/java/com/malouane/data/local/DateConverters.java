package com.malouane.data.local;

import android.arch.persistence.room.TypeConverter;
import java.util.Date;
import org.jetbrains.annotations.Nullable;

public class DateConverters {
  @TypeConverter
  @Nullable
  public final Date timestampToDate(@Nullable Long value) {
    return value == null ? null : new Date(value);
  }

  @TypeConverter
  @Nullable
  public final Long dateToTimestamp(@Nullable Date date) {
    return date != null ? date.getTime() : null;
  }
}

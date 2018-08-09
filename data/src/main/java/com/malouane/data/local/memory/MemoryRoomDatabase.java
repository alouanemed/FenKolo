package com.malouane.data.local.memory;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import com.malouane.data.local.DateConverters;
import com.malouane.data.local.dao.VenueDao;
import com.malouane.data.local.model.VenueLocalModel;
import org.jetbrains.annotations.NotNull;

/*Todo add reviews models
@Database(entities = VenueLocalModel.class, version = 1, exportSchema = false)
@TypeConverters(DateConverters.class)*/
public abstract class MemoryRoomDatabase extends RoomDatabase {

  ///@NotNull public abstract VenueDao venuesDao();

  //@NotNull public abstract RatingDao ratingDao();

  /*public static MemoryRoomDatabase newInstance(@NotNull Context context) {
    return Room.inMemoryDatabaseBuilder(context, MemoryRoomDatabase.class).build();
  }*/
}

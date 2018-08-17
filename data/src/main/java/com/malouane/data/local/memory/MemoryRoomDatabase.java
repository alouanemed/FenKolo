package com.malouane.data.local.memory;

import android.arch.persistence.room.RoomDatabase;

/*Todo add reviews models
@Database(entities = VenueLocalModel.class, version = 1, exportSchema = false)
@TypeConverters(DateConverters.class)*/
public abstract class MemoryRoomDatabase extends RoomDatabase {

  ///@NotNull public abstract VenueDao venueDao();

  //@NotNull public abstract RatingDao ratingDao();

  /*public static MemoryRoomDatabase newInstance(@NotNull Context context) {
    return Room.inMemoryDatabaseBuilder(context, MemoryRoomDatabase.class).build();
  }*/
}

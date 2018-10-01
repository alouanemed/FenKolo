package com.malouane.data.local.disk;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import com.malouane.data.local.DateConverters;
import com.malouane.data.local.dao.VenueDao;
import com.malouane.data.local.dao.VenueTypeDao;
import com.malouane.data.local.model.VenueDetailsLocalModel;
import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.local.model.VenuesTypeLocalModel;
import org.jetbrains.annotations.NotNull;

@Database(entities = {
    VenueLocalModel.class, VenuesTypeLocalModel.class, VenueDetailsLocalModel.class
}, version = 1, exportSchema = false) @TypeConverters(DateConverters.class)
public abstract class DiskRoomDatabase extends RoomDatabase {

  @NotNull public abstract VenueDao venueDao();

  @NotNull public abstract VenueTypeDao venueTypeDao();

  public static DiskRoomDatabase newInstance(@NotNull Context context) {
    return Room.inMemoryDatabaseBuilder(context, DiskRoomDatabase.class).build();
  }
}

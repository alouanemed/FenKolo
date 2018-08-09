package com.malouane.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.malouane.data.local.model.VenueLocalModel;
import io.reactivex.Maybe;
import java.util.List;

@Dao public interface VenueDao {

  //TODO query list
  @Query("SELECT * FROM Venue WHERE categories = :type") Maybe<List<VenueLocalModel>> findByType(
      int type);

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insertAll(List<VenueLocalModel> list);

  //TODO query list
  @Query("DELETE FROM Venue WHERE categories = :type") void deleteByType(int type);

  @Query("SELECT * FROM Venue WHERE id = :id") Maybe<VenueLocalModel> getById(int id);

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insert(VenueLocalModel venue);
}

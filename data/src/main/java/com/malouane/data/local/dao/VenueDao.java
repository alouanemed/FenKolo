package com.malouane.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.malouane.data.local.model.VenueLocalModel;
import io.reactivex.Maybe;
import java.util.List;

@Dao public interface VenueDao {

  //TODO query list int locationLatLong, String catId, String query, String radius

  @Query("SELECT * FROM Venue WHERE location_address = :location_address ")
  Maybe<List<VenueLocalModel>> findByType(String location_address);

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insertAll(List<VenueLocalModel> list);

  //TODO query list
  @Query("DELETE FROM Venue WHERE categories = :catId") void deleteByType(String catId);

  @Query("SELECT * FROM Venue WHERE id = :id") Maybe<VenueLocalModel> getById(int id);

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insert(VenueLocalModel venue);
}

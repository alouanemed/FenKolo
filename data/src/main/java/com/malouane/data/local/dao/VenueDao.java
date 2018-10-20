package com.malouane.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.malouane.data.local.model.VenueDetailsLocalModel;
import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.local.model.VenueTipsLocalModel;
import io.reactivex.Maybe;
import java.util.List;

@Dao public interface VenueDao {

  //TODO query list int locationLatLong, String catId, String query, String radius

  @Query("SELECT * FROM Venue WHERE location_address = :location_address ")
  Maybe<List<VenueLocalModel>> findByType(String location_address);

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insertAll(List<VenueLocalModel> list);

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insertAllTips(
      List<VenueTipsLocalModel> list);

  //TODO query list
  @Query("DELETE FROM Venue WHERE categories = :catId") void deleteByType(String catId);

  @Query("DELETE FROM VenueTips WHERE id = :id") void deleteTipById(String id);

  @Query("SELECT * FROM VenueDetails WHERE id = :id") Maybe<VenueDetailsLocalModel> getById(
      String id);

  @Query("SELECT * FROM VenueTips WHERE id = :id") Maybe<List<VenueTipsLocalModel>> getTipById(
      String id);

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insert(VenueLocalModel venue);

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insertVenueDetails(
      VenueDetailsLocalModel venue);

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insertVenueTips(
      VenueTipsLocalModel venue);
}

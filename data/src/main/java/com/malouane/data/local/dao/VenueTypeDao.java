package com.malouane.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.malouane.data.local.model.VenuesTypeLocalModel;
import com.malouane.data.local.model.VenuesTypeLocalModel;
import io.reactivex.Maybe;
import java.util.List;

@Dao public interface VenueTypeDao {

  @Query("SELECT * FROM VenueType WHERE id = :id") Maybe<VenuesTypeLocalModel> getById(int id);

  @Query("SELECT * FROM VenueType") Maybe<VenuesTypeLocalModel> getAll();

  @Insert(onConflict = OnConflictStrategy.REPLACE) void insertAll(List<VenuesTypeLocalModel> list);
}

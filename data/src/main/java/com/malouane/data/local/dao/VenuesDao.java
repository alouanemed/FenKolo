package com.malouane.data.local.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.malouane.data.local.model.VenueLocalModel;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface VenuesDao {
    @Query("SELECT * FROM Venue WHERE type = :type")
    Maybe<List<VenueLocalModel>> findByType(int type);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<VenueLocalModel> list);

    @Query("DELETE FROM Venue WHERE categories = :type")
     void deleteByType(int type);

    @Query("SELECT * FROM Venue WHERE id = :id")
    Maybe<VenueLocalModel> getById(int type);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insert(VenueLocalModel venue);
}

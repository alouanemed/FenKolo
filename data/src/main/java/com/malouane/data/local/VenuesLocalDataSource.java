package com.malouane.data.local;

import com.malouane.data.local.dao.VenueDao;
import com.malouane.data.local.model.VenueDetailsLocalModel;
import com.malouane.data.local.model.VenueLocalModel;
import io.reactivex.Observable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class VenuesLocalDataSource {
  private VenueDao venueDao;

  public void insertAll(List<VenueLocalModel> list) {
    venueDao.insertAll(list);
  }

  public Observable<List<VenueLocalModel>> findByType(String locationLatLong, String catId) {
    return venueDao.findByType(locationLatLong).toObservable();
    //return venueDao.findByType(locationLatLong, catId).toObservable();
  }

  public void deleteByType(String type) {
    venueDao.deleteByType(type);
  }

  public Observable<VenueDetailsLocalModel> getById(String id) {
    return venueDao.getById(id).toObservable();
  }

  public void insert(VenueLocalModel venue) {
    venueDao.insert(venue);
  }

  public void insertDetails(VenueDetailsLocalModel venue) {
    venueDao.insertVenueDetails(venue);
  }

  public VenuesLocalDataSource(@NotNull VenueDao venueDao) {
    this.venueDao = venueDao;
  }
}

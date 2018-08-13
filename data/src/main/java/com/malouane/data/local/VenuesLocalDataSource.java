package com.malouane.data.local;

import com.malouane.data.local.dao.VenueDao;
import com.malouane.data.local.model.VenueLocalModel;
import io.reactivex.Observable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class VenuesLocalDataSource {
  private VenueDao venueDao;

  public void insertAll(List<VenueLocalModel> list) {
    venueDao.insertAll(list);
  }

  public Observable<List<VenueLocalModel>> findByType(int locationLatLong, String catId) {
    return venueDao.findByType(locationLatLong, catId).toObservable();
  }

  public void deleteByType(String type) {
    venueDao.deleteByType(type);
  }

  public Observable<VenueLocalModel> getById(int id) {
    return venueDao.getById(id).toObservable();
  }

  public void insert(VenueLocalModel venue) {
    venueDao.insert(venue);
  }

  public VenuesLocalDataSource(@NotNull VenueDao venueDao) {
    this.venueDao = venueDao;
  }
}

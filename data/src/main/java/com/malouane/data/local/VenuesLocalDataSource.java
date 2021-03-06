package com.malouane.data.local;

import com.malouane.data.local.dao.VenueDao;
import com.malouane.data.local.model.VenueDetailsLocalModel;
import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.local.model.VenueTipsLocalModel;
import io.reactivex.Observable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class VenuesLocalDataSource {
  private VenueDao venueDao;

  public void insertAll(List<VenueLocalModel> list) {
    venueDao.insertAll(list);
  }

  public void insertAllTips(List<VenueTipsLocalModel> list) {
    venueDao.insertAllTips(list);
  }

  public Observable<List<VenueLocalModel>> findByType(String locationLatLong, String catId) {
    return venueDao.findByType(locationLatLong).toObservable();
    //return venueDao.findByType(locationLatLong, catId).toObservable();
  }

  public void deleteByType(String type) {
    venueDao.deleteByType(type);
  }

  public void deleteTipById(String id) {
    venueDao.deleteTipById(id);
  }

  public Observable<VenueDetailsLocalModel> getById(String id) {
    return venueDao.getById(id).toObservable();
  }

  public Observable<List<VenueTipsLocalModel>> getTipsById(String id) {
    return venueDao.getTipById(id).toObservable();
  }

  public void insert(VenueLocalModel venue) {
    venueDao.insert(venue);
  }

  public void insertDetails(VenueDetailsLocalModel venue) {
    venueDao.insertVenueDetails(venue);
  }

  public void insertTips(VenueTipsLocalModel tip) {
    venueDao.insertVenueTips(tip);
  }

  public VenuesLocalDataSource(@NotNull VenueDao venueDao) {
    this.venueDao = venueDao;
  }
}
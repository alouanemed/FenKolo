package com.malouane.data.local;

import com.malouane.data.local.dao.VenueTypeDao;
import com.malouane.data.local.model.VenuesTypeLocalModel;
import io.reactivex.Observable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class VenueTypesLocalDataSource {
  private VenueTypeDao venueTypeDao;

  public void insertAll(List<VenuesTypeLocalModel> list) {
    venueTypeDao.insertAll(list);
  }

  public Observable<VenuesTypeLocalModel> getById(int id) {
    return venueTypeDao.getById(id).toObservable();
  }

  public Observable<List<VenuesTypeLocalModel>> getAll() {
    return venueTypeDao.getAll().toObservable();
  }

  public VenueTypesLocalDataSource(@NotNull VenueTypeDao venueTypeDao) {
    this.venueTypeDao = venueTypeDao;
  }
}

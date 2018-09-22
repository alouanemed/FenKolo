package com.malouane.data.repository;

import com.malouane.data.local.VenueTypesLocalDataSource;
import com.malouane.data.local.model.VenuesTypeLocalModel;
import com.malouane.data.remote.VenueTypeRemoteDataSource;
import com.malouane.data.repository.mapper.VenueTypeMapper;
import io.reactivex.Observable;
import java.util.List;

public class VenueTypeRepository {
  private VenueTypesLocalDataSource localDataSource;
  private VenueTypeRemoteDataSource remoteDataSource;
  private VenueTypeMapper mapper;

  public VenueTypeRepository(VenueTypesLocalDataSource localDataSource,
      VenueTypeRemoteDataSource remoteDataSource, VenueTypeMapper mapper) {
    this.localDataSource = localDataSource;
    this.remoteDataSource = remoteDataSource;
    this.mapper = mapper;
  }

  public Observable<List<VenuesTypeLocalModel>> getAllCategories() {
    Observable<List<VenuesTypeLocalModel>> localList =
        localDataSource.getAll().filter(it -> !it.isEmpty());

    Observable<List<VenuesTypeLocalModel>> remoteList = remoteDataSource.getAll()
        .map(it -> mapper.toLocal(it.getCategories()))
        .doOnNext(localDataSource::insertAll);

    return Observable.concat(localList, remoteList).firstElement().toObservable();
  }

  public Observable<VenuesTypeLocalModel> getById(int id) {
    Observable<VenuesTypeLocalModel> local = localDataSource.getById(id);
    return null;
  }
}

package com.malouane.data.repository.mapper;

import com.malouane.data.local.VenuesLocalDataSource;
import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.remote.VenuesRemoteDataSource;
import io.reactivex.Observable;
import java.util.List;

public class VenueRepository {
  private VenuesLocalDataSource localDataSource;
  private VenuesRemoteDataSource remoteDataSource;
  private VenueMapper mapper;

  public VenueRepository(VenuesLocalDataSource localDataSource,
      VenuesRemoteDataSource remoteDataSource, VenueMapper mapper) {
    this.localDataSource = localDataSource;
    this.remoteDataSource = remoteDataSource;
    this.mapper = mapper;
  }

  public Observable<List<VenueLocalModel>> findByType(int locationLatLong, String catId,
      String query, String radius, Boolean refresh) {
    Observable<List<VenueLocalModel>> localList =
        localDataSource.findByType(locationLatLong, catId).filter(it -> !it.isEmpty());

    Observable<List<VenueLocalModel>> remoteList = remoteDataSource.
        getVenues(locationLatLong, catId, query, radius)
        .map(mapper::toLocal)
        .doOnNext(localDataSource::insertAll);

    return Observable.just(refresh)
        .doOnNext(it -> localDataSource.deleteByType(catId))
        .flatMap(it -> Observable.concat(localList, remoteList).firstElement().toObservable());
  }

  public Observable<VenueLocalModel> getById(int id) {
    Observable<VenueLocalModel> local = localDataSource.getById(id);
    return null;
  }
}

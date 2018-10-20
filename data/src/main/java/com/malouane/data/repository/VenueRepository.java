package com.malouane.data.repository;

import com.malouane.data.local.VenuesLocalDataSource;
import com.malouane.data.local.model.VenueDetailsLocalModel;
import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.local.model.VenueTipsLocalModel;
import com.malouane.data.remote.VenuesRemoteDataSource;
import com.malouane.data.repository.mapper.VenueMapper;
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

  public Observable<List<VenueLocalModel>> findByType(String locationLatLong, String catId,
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

  public Observable<VenueDetailsLocalModel> getVenueDetailsOf(String id, Boolean refresh) {
    Observable<VenueDetailsLocalModel> localList =
        localDataSource.getById(id).filter(it -> !(it == null));

    Observable<VenueDetailsLocalModel> remoteList = remoteDataSource.
        getVenueDetailsOf(id).map(mapper::toLocal).doOnNext(localDataSource::insertDetails);

    return Observable.just(refresh)
        .flatMap(it -> Observable.concat(localList, remoteList).firstElement().toObservable());
  }

  public Observable<List<VenueTipsLocalModel>> getVenueTipsOf(String id, Boolean refresh) {
    Observable<List<VenueTipsLocalModel>> localList =
        localDataSource.getTipsById(id).filter(it -> !(it == null));

    Observable<List<VenueTipsLocalModel>> remoteList = remoteDataSource.
        getVenueTipsOf(id)
        .map(mapper::tipsToLocal)
        .doOnNext(localDataSource::insertAllTips);

    return Observable.just(refresh)
        .doOnNext(it -> localDataSource.deleteTipById(id))
        .flatMap(it -> Observable.concat(localList, remoteList).firstElement().toObservable());
  }
}

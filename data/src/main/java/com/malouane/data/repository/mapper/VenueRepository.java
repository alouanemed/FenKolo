package com.malouane.data.repository.mapper;

import com.malouane.data.local.VenuesLocalDataSource;
import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.remote.VenuesRemoteDataSource;
import com.malouane.data.remote.model.VenueRemoteModel;
import io.reactivex.Observable;
import java.util.List;

public class VenueRepository {
  private VenuesLocalDataSource localDataSource;
  private VenuesRemoteDataSource remoteDataSource;
  private VenueMapper mapper;

  {

    val local = eventLocalDataSource.getById(id)

    val remote = eventRemoteDataSource.getById(id).map {
    eventMapper.toLocal(it)
  }
                .doOnNext {
    eventLocalDataSource.insert(it)
  }

    return Observable.concat(local, remote).firstElement().toObservable();
  }

  public VenueRepository(VenuesLocalDataSource localDataSource,
      VenuesRemoteDataSource remoteDataSource, VenueMapper mapper) {
    this.localDataSource = localDataSource;
    this.remoteDataSource = remoteDataSource;
    this.mapper = mapper;
  }:Observable<EventLocalModel>

  public Observable<List<VenueLocalModel>> findByType(int locationLatLong, String catId,
      String query, String radius, Boolean refresh) {
    Observable<List<VenueLocalModel>> localList =
        localDataSource.findByType(locationLatLong, catId).filter(it -> !it.isEmpty());

    Observable<List<VenueRemoteModel>> remoteList = remoteDataSource.
        getVenues(locationLatLong, catId, query, radius).map({
        list -> {
          return mapper.toLocal(list);
        }
    }).doOnNext({ it -> localDataSource.insertAll(it) });

    return Observable.just(refresh).doOnNext({
        it -> {
          if (it) localDataSource.deleteByType(catId);
        }
    }).flatMap({
        Observable.concat(localList, remoteList).firstElement().toObservable()
    });
  }

  fun getById(id:Int)
}

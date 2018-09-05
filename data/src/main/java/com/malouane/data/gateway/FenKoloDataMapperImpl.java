package com.malouane.data.gateway;

import com.malouane.data.gateway.mapper.FenKoloDataMapper;
import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.local.model.VenuesTypeLocalModel;
import com.malouane.data.repository.VenueRepository;
import com.malouane.data.repository.VenueTypeRepository;
import com.malouane.fenkolo.domain.entity.Venue;
import com.malouane.fenkolo.domain.entity.VenueType;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public class FenKoloDataMapperImpl implements FenKoloDataGateway {

  private VenueRepository venueRepository;
  private VenueTypeRepository venueTypeRepository;

  private FenKoloDataMapper mapper;

  public FenKoloDataMapperImpl(VenueRepository venueRepository,
      VenueTypeRepository venueTypeRepository) {
    this.venueRepository = venueRepository;
    this.venueTypeRepository = venueTypeRepository;
    mapper = new FenKoloDataMapper();
  }

  @Override
  public Observable<List<Venue>> getVenues(String locationLatLong, String catId, String query,
      String radius, boolean refresh) {
    List<Venue> list = new ArrayList<Venue>();
    return venueRepository.findByType(locationLatLong, catId, query, radius, refresh)
        .doOnError(it -> Timber.d("getVenues Error" + catId))
        .map(it -> {
          for (VenueLocalModel item : it) {
            list.add(mapper.toEntity(item));
          }
          return list;
        });
  }

  @Override public Observable<List<VenueType>> getVenueTypes() {
    List<VenueType> list = new ArrayList<VenueType>();
    return venueTypeRepository.getAllCategories()
        .doOnError(it -> Timber.d("getVenueTypes Error" + it))
        .map(it -> {
          for (VenuesTypeLocalModel item : it) {
            list.add(mapper.toEntity(item));
          }
          return list;
        });
  }
}

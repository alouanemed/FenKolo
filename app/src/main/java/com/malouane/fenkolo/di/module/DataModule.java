package com.malouane.fenkolo.di.module;

import android.content.Context;
import com.malouane.data.gateway.FenKoloDataMapperImpl;
import com.malouane.data.local.VenueTypesLocalDataSource;
import com.malouane.data.local.VenuesLocalDataSource;
import com.malouane.data.local.dao.VenueDao;
import com.malouane.data.local.dao.VenueTypeDao;
import com.malouane.data.local.disk.DiskRoomDatabase;
import com.malouane.data.remote.VenueTypeRemoteDataSource;
import com.malouane.data.remote.VenuesRemoteDataSource;
import com.malouane.data.remote.api.FenKoloApi;
import com.malouane.data.repository.VenueRepository;
import com.malouane.data.repository.VenueTypeRepository;
import com.malouane.data.repository.mapper.VenueMapper;
import com.malouane.data.repository.mapper.VenueTypeMapper;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class DataModule {

  @Provides @Singleton FenKoloApi provideFenKoloApi() {
    return new FenKoloApi();
  }

  @Provides @Singleton VenueTypeRemoteDataSource provideVenueTypeRemoteDataSource(FenKoloApi api) {
    return new VenueTypeRemoteDataSource(api);
  }

  @Provides @Singleton VenuesRemoteDataSource provideVenueRemoteDataSource(FenKoloApi api) {
    return new VenuesRemoteDataSource(api);
  }

  @Provides @Singleton DiskRoomDatabase provideDiskRoomDatabase(Context context) {
    return DiskRoomDatabase.newInstance(context);
  }

  @Provides @Singleton VenueTypeDao provideVenueTypeDao(DiskRoomDatabase disk) {
    return disk.venueTypeDao();
  }

  @Provides @Singleton VenueDao provideVenueDao(DiskRoomDatabase disk) {
    return disk.venueDao();
  }

  @Provides @Singleton VenueTypesLocalDataSource provideVenueTypesLocalDataSource(
      VenueTypeDao venueTypeDao) {
    return new VenueTypesLocalDataSource(venueTypeDao);
  }

  @Provides @Singleton VenuesLocalDataSource provideVenueLocalDataSource(VenueDao venueDao) {
    return new VenuesLocalDataSource(venueDao);
  }

  @Provides @Singleton VenueTypeRepository provideVenueTypeRepository(
      VenueTypesLocalDataSource localDataSource, VenueTypeRemoteDataSource remoteDataSource) {
    return new VenueTypeRepository(localDataSource, remoteDataSource, new VenueTypeMapper());
  }

  @Provides @Singleton VenueRepository provideVenueRepository(VenuesLocalDataSource localDataSource,
      VenuesRemoteDataSource remoteDataSource) {
    return new VenueRepository(localDataSource, remoteDataSource, new VenueMapper());
  }

  @Provides @Singleton FenKoloDataGateway provideFenKoloDataGateway(
      VenueRepository venueRepository, VenueTypeRepository venueTypeRepository) {
    return new FenKoloDataMapperImpl(venueRepository, venueTypeRepository);
  }
}
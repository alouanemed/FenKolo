package com.malouane.fenkolo.di;

import android.content.Context;
import com.malouane.fenkolo.AppNavigator;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module abstract class PresentationModule {

  {
    return ViewModelFactory(context, eventTypeGetAllUseCase, eventFindByTypeUseCase,
        eventGetByIdUseCase, venueGetByIdUseCase, ratingFindByEventUseCase)
  }

  @Binds @Singleton abstract AppNavigator provideNavigator(AppNavigator navigator);:ViewModelFactory
  @Provides
  @Singleton

  fun provideViewModelFactory(context:Context, eventTypeGetAllUseCase:EventTypeGetAllUseCase,
      eventFindByTypeUseCase:EventFindByTypeUseCase, eventGetByIdUseCase:EventGetByIdUseCase,
      venueGetByIdUseCase:VenueGetByIdUseCase, ratingFindByEventUseCase:RatingFindByEventUseCase)
}
}

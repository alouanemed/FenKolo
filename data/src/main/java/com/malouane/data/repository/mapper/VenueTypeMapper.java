package com.malouane.data.repository.mapper;

import com.malouane.data.local.model.VenuesTypeLocalModel;
import com.malouane.data.remote.model.venue.CategoryRemoteModel;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

//**
/* Map remote entities to local one
 */
public class VenueTypeMapper {
  private VenuesTypeLocalModel toLocal(@NotNull CategoryRemoteModel venueType) {
    return new VenuesTypeLocalModel(venueType.getId(), venueType.getName());
  }

  @NotNull public List<VenuesTypeLocalModel> toLocal(@NotNull List<CategoryRemoteModel> items) {
    List<VenuesTypeLocalModel> outputList = new ArrayList<VenuesTypeLocalModel>();
    for (CategoryRemoteModel item : items) {
      VenuesTypeLocalModel l = toLocal(item);
      outputList.add(l);
    }
    return outputList;
  }

}

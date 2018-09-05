package com.malouane.data.repository.mapper;

import com.malouane.data.local.model.VenuesTypeLocalModel;
import com.malouane.data.remote.model.VenueTypeRemoteModel;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

//**
/* Map remote entities to local one
 */
public class VenueTypeMapper {
  public final VenuesTypeLocalModel toLocal(@NotNull VenueTypeRemoteModel venueType) {
    return new VenuesTypeLocalModel(venueType.getId(), venueType.getName());
  }

  @NotNull public List<VenuesTypeLocalModel> toLocal(@NotNull List<VenueTypeRemoteModel> items) {
    List<VenuesTypeLocalModel> outputList = new ArrayList<VenuesTypeLocalModel>();

    for (VenueTypeRemoteModel item : items) {
      VenuesTypeLocalModel l = toLocal(item);
      outputList.add(l);
    }
    return outputList;
  }

}

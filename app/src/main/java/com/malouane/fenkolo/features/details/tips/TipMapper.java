package com.malouane.fenkolo.features.details.tips;

import com.malouane.fenkolo.domain.entity.VenueTip;
import org.jetbrains.annotations.NotNull;

/**
 * Map Data entities to RV binding data
 */
class TipMapper {
  TipModel toLocal(@NotNull VenueTip tip) {
    return new TipModel(tip.getId(), tip.getText(),
        tip.getAgreeCount(), tip.getDisagreeCount(), tip.getCreatedAt(), tip.getUserName(),
        tip.getPhoto(), "");
  }
}
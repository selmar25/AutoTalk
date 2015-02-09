package com.sohum.autotalk.traffic.internal;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sohum.autotalk.common.GeoLocation;
import com.sohum.autotalk.traffic.config.NeighbourConfiguration;
import lombok.Data;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Data
public class CurrentUserLocationMap {

  private NeighbourConfiguration neighbourConfiguration;
  private Map<Integer, GeoLocation> mapUsers = Maps.newHashMap();

  @Inject
  public CurrentUserLocationMap(NeighbourConfiguration neighbourConfiguration) {
    this.neighbourConfiguration = neighbourConfiguration;
  }

  public void addLocation(Integer id, GeoLocation location) {
    mapUsers.put(id, location);
  }

  public Map<Integer, GeoLocation> getPositionsAround(Integer id) {

    Map<Integer, GeoLocation> mapResponse = Maps.newHashMap();

    GeoLocation location = mapUsers.get(id);
    if (location == null) {
      return mapResponse;
    }

    for (Map.Entry<Integer, GeoLocation> entry : mapUsers.entrySet()) {

      if (isInGrid(location, entry.getValue())) {
        mapResponse.put(entry.getKey(), entry.getValue());
      }
    }
    return mapResponse;
  }

  public boolean isInGrid(GeoLocation firstPoint, GeoLocation secondPoint) {
    double gridSize = neighbourConfiguration.getGridSize();

    if ((secondPoint.getLatitude() - firstPoint.getLatitude() > gridSize) ||
      (firstPoint.getLatitude() - secondPoint.getLatitude() > gridSize) ||
      (secondPoint.getLongitude() - firstPoint.getLongitude() > gridSize) ||
      (firstPoint.getLongitude() - secondPoint.getLongitude() > gridSize)) {

      return false;
    }
    return true;
  }
}

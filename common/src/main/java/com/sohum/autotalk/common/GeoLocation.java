package com.sohum.autotalk.common;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;

@Data
@JsonSnakeCase
public class GeoLocation {
  private double latitude;
  private double longitude;

  public GeoLocation(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public GeoLocation() {

  }

  public double getDistance(GeoLocation secondPoint) {
    double val = (secondPoint.latitude - latitude) * (secondPoint.getLatitude() - latitude);
    val += (secondPoint.getLongitude() - longitude) * (secondPoint.getLongitude() - longitude);
    return val;
  }
}

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
}

package com.sohum.autotalk.traffic.request;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class VehicleRequest {

  private double speed;
  private String id;
  private Location location;
  private Long epochTime;

  public static class Location {
    private double latitude;
    private double longitude;
  }
}

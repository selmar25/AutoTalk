package com.sohum.autotalk.traffic.request;

import com.sohum.autotalk.common.GeoLocation;
import lombok.Data;
import org.joda.time.DateTime;

@Data
public class VehicleRequest {

  private String id;
  private double speed;
  private GeoLocation location;
  private Long epochTime;
}

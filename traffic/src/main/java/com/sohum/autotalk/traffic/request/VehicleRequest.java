package com.sohum.autotalk.traffic.request;

import com.sohum.autotalk.common.GeoLocation;
import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@JsonSnakeCase
public class VehicleRequest {

  private Integer userId;
  private double speed;
  private GeoLocation location;
  private Long epochTime;
}

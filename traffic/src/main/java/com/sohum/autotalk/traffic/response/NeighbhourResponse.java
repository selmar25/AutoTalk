package com.sohum.autotalk.traffic.response;

import com.sohum.autotalk.common.GeoLocation;
import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;

import java.util.List;

@Data
@JsonSnakeCase
public class NeighbhourResponse {
  public List<Neighbour> userList;

  public static class Neighbour {
    private String userId;
    private GeoLocation location;
  }
}

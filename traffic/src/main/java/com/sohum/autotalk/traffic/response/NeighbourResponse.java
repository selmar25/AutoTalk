package com.sohum.autotalk.traffic.response;

import com.google.common.collect.Lists;
import com.sohum.autotalk.common.GeoLocation;
import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;

import java.util.List;

@Data
@JsonSnakeCase
public class NeighbourResponse {
  public List<Neighbour> userList = Lists.newArrayList();

  @Data
  @JsonSnakeCase
  public static class Neighbour {
    private Integer userId;
    private GeoLocation location;
  }
}

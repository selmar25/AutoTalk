package com.sohum.autotalk.traffic.internal;

import com.sohum.autotalk.traffic.INeighbourResource;
import com.sohum.autotalk.traffic.response.NeighbhourResponse;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/neighbours")
@Slf4j
public class NeighboursResource implements INeighbourResource {

  @Override
  public NeighbhourResponse getNeighbours(@QueryParam("user_id") String userId) {
    return null;
  }
}

package com.sohum.autotalk.traffic.internal;

import com.sohum.autotalk.common.GeoLocation;
import com.sohum.autotalk.traffic.INeighbourResource;
import com.sohum.autotalk.traffic.internal.model.UserLocation;
import com.sohum.autotalk.traffic.response.NeighbourResponse;
import io.dropwizard.hibernate.UnitOfWork;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/neighbours")
@Slf4j
public class NeighboursResource implements INeighbourResource {

  private UserLocationDAO userLocationDAO;
  private CurrentUserLocationMap mapUserLocations;

  @Inject
  public NeighboursResource(UserLocationDAO userLocationDAO, CurrentUserLocationMap mapUserLocations) {
    this.userLocationDAO = userLocationDAO;
    this.mapUserLocations = mapUserLocations;
  }

  @GET
  @Override
  @UnitOfWork
  @Produces(MediaType.APPLICATION_JSON)
  public NeighbourResponse getNeighbours(@QueryParam("user_id") Integer userId) {

    if (userId == null) {
      throw new RuntimeException("userId is null");
    }

    NeighbourResponse response = new NeighbourResponse();


    Map<Integer, GeoLocation> map = mapUserLocations.getPositionsAround(userId);

    for (Map.Entry<Integer, GeoLocation> entry : map.entrySet()) {
      NeighbourResponse.Neighbour neighbour = new NeighbourResponse.Neighbour();
      neighbour.setUserId(entry.getKey());
      neighbour.setLocation(entry.getValue());

      response.getUserList().add(neighbour);
    }
    return response;
  }
}

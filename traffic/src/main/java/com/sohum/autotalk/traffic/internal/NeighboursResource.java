package com.sohum.autotalk.traffic.internal;

import com.sohum.autotalk.traffic.INeighbourResource;
import com.sohum.autotalk.traffic.internal.model.UserLocation;
import com.sohum.autotalk.traffic.response.NeighbhourResponse;
import io.dropwizard.hibernate.UnitOfWork;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/neighbours")
@Slf4j
public class NeighboursResource implements INeighbourResource {

  private UserLocationDAO userLocationDAO;

  @Inject
  public NeighboursResource(UserLocationDAO userLocationDAO) {
    this.userLocationDAO = userLocationDAO;
  }

  @GET
  @Override
  @UnitOfWork
  @Produces(MediaType.APPLICATION_JSON)
  public NeighbhourResponse getNeighbours(@QueryParam("user_id") String userId) {
    List<UserLocation> userLocationList = userLocationDAO.findAll();

    for (UserLocation userLocation : userLocationList) {
      //
    }
    return null;
  }
}

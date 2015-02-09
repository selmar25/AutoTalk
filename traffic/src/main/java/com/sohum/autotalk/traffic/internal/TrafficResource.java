package com.sohum.autotalk.traffic.internal;

import com.sohum.autotalk.common.GeoLocation;
import com.sohum.autotalk.traffic.ITrafficResouce;
import com.sohum.autotalk.traffic.internal.model.UserLocation;
import com.sohum.autotalk.traffic.request.VehicleRequest;
import io.dropwizard.hibernate.UnitOfWork;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/locations")
@Slf4j
public class TrafficResource implements ITrafficResouce {

  private UserLocationDAO userLocationDAO;
  private CurrentUserLocationMap mapUserLocations;

  @Inject
  public TrafficResource(UserLocationDAO userLocationDAO, CurrentUserLocationMap mapUserLocations) {
    this.userLocationDAO = userLocationDAO;
    this.mapUserLocations = mapUserLocations;
  }

  @GET
  @Override
  @UnitOfWork
  @Path("/debug/load")
  public void loadPositions() {
    List<UserLocation> list = userLocationDAO.findAll();

    for (UserLocation userLocation : list) {
      mapUserLocations.addLocation(userLocation.getUserId(),
        new GeoLocation(userLocation.getLatitude(), userLocation.getLongitude()));
    }
  }

  @POST
  @Override
  @UnitOfWork
  @Produces(MediaType.APPLICATION_JSON)
  public Boolean updatePosition(VehicleRequest request) {
    log.info("update " + request);
    userLocationDAO.storeDetails(request.getUserId(), request.getLocation(), request.getEpochTime());

    mapUserLocations.addLocation(request.getUserId(), request.getLocation());
    return true;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @UnitOfWork
  public String getSomething() {
    return "Hai";
  }
}

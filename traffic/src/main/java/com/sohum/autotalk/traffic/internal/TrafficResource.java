package com.sohum.autotalk.traffic.internal;

import com.sohum.autotalk.traffic.ITrafficResouce;
import com.sohum.autotalk.traffic.request.VehicleRequest;
import io.dropwizard.hibernate.UnitOfWork;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/locations")
@Slf4j
public class TrafficResource implements ITrafficResouce {

  private UserLocationDAO userLocationDAO;

  @Inject
  public TrafficResource(UserLocationDAO userLocationDAO) {
    this.userLocationDAO = userLocationDAO;
  }

  @POST
  @Override
  @UnitOfWork
  @Produces(MediaType.APPLICATION_JSON)
  public Boolean updatePosition(VehicleRequest request) {
    log.info("update " + request);
    userLocationDAO.storeDetails(request.getUserId(), request.getLocation(), request.getEpochTime());
    return true;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @UnitOfWork
  public String getSomething() {
    return "Hai";
  }
}

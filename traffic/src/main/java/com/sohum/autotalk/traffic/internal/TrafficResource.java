package com.sohum.autotalk.traffic.internal;

import com.sohum.autotalk.traffic.ITrafficResouce;
import com.sohum.autotalk.traffic.request.VehicleRequest;
import com.sohum.autotalk.user.internal.repo.UserDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/locations")
public class TrafficResource implements ITrafficResouce {

  private UserDAO userDao;

  @Inject
  public TrafficResource(UserDAO userDao) {
    this.userDao = userDao;
  }

  @POST
  @Override
  @Produces(MediaType.APPLICATION_JSON)
  public Boolean updatePosition(VehicleRequest request) {
    return true;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @UnitOfWork
  public String getSomething() {
    return userDao.findAll().toString();
  }
}

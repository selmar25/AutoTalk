package com.sohum.autotalk.traffic.internal;

import com.sohum.autotalk.traffic.ITrafficResouce;
import com.sohum.autotalk.traffic.request.VehicleRequest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/locations")
public class TrafficResource implements ITrafficResouce {

  @POST
  @Override
  @Produces(MediaType.APPLICATION_JSON)
  public Boolean updatePosition(VehicleRequest request) {
    return true;
  }
}

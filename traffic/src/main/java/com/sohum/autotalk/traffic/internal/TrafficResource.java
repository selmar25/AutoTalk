package com.sohum.autotalk.traffic.internal;

import com.sohum.autotalk.traffic.ITrafficResouce;
import com.sohum.autotalk.traffic.request.VehicleRequest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/locations")
public class TrafficResource implements ITrafficResouce {

  @POST
  @Override
  public void updatePosition(VehicleRequest request) {

  }
}

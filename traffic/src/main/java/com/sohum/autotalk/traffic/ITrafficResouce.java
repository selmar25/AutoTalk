package com.sohum.autotalk.traffic;

import com.sohum.autotalk.traffic.request.VehicleRequest;

public interface ITrafficResouce {
  Boolean updatePosition(VehicleRequest request);
}

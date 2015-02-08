package com.sohum.autotalk.traffic;

import com.sohum.autotalk.traffic.response.NeighbhourResponse;

public interface INeighbourResource {
  NeighbhourResponse getNeighbours(String userId);
}

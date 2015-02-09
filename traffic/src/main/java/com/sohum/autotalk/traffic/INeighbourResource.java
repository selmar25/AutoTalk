package com.sohum.autotalk.traffic;

import com.sohum.autotalk.traffic.response.NeighbourResponse;

public interface INeighbourResource {
  NeighbourResponse getNeighbours(Integer userId);
}

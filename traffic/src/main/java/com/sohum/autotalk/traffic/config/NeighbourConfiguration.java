package com.sohum.autotalk.traffic.config;

import io.dropwizard.Configuration;
import lombok.Data;

@Data
public class NeighbourConfiguration extends Configuration {
  private double gridSize;
}

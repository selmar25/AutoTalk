package com.sohum.autotalk.config;

import io.dropwizard.Configuration;
import lombok.Data;

@Data
public class HelloWorldConfiguration extends Configuration {

  private DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
}

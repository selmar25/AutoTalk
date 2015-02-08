package com.sohum.autotalk.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.DatabaseConfiguration;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class HelloWorldConfiguration extends Configuration {
  //private DatabaseConfiguration databaseConfiguration;

  @Valid
  @NotNull
  @JsonProperty("database")
  private DataSourceFactory database = new DataSourceFactory();

  public DataSourceFactory getDataSourceFactory() {
    return database;
  }
}

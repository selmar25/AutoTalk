package com.sohum.autotalk;

import com.sohum.autotalk.config.HelloWorldConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

  public static void main(String[] args) throws Exception {
    new HelloWorldApplication().run(args);
  }

  @Override
  public void initialize(Bootstrap<HelloWorldConfiguration> helloWorldConfigurationBootstrap) {
  }

  @Override
  public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {

  }
}

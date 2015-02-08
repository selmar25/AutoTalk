package com.sohum.autotalk;

import com.sohum.autotalk.config.HelloWorldConfiguration;
import com.sohum.autotalk.traffic.internal.TrafficResource;
import com.sohum.autotalk.user.internal.UserResource;
import com.sohum.autotalk.user.internal.model.User;
import com.sohum.autotalk.user.internal.repo.UserDAO;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

  public static void main(String[] args) throws Exception {
    new HelloWorldApplication().run(args);
  }

  private final HibernateBundle<HelloWorldConfiguration> hibernate = new HibernateBundle<HelloWorldConfiguration>(User.class) {
    @Override
    public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
      return configuration.getDataSourceFactory();
    }
  };

  @Override
  public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
    bootstrap.addBundle(hibernate);

    bootstrap.addBundle(new MigrationsBundle<HelloWorldConfiguration>() {
      @Override
      public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
        return configuration.getDataSourceFactory();
      }
    });
  }

  @Override
  public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {


    final UserDAO dao = new UserDAO(hibernate.getSessionFactory());

    final TrafficResource resource = new TrafficResource(dao);
    environment.jersey().register(resource);

    final UserResource userResource = new UserResource(dao);
    environment.jersey().register(userResource);
  }
}

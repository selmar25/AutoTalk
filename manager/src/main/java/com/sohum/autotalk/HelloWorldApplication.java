package com.sohum.autotalk;

import com.sohum.autotalk.communication.ICommunicationResource;
import com.sohum.autotalk.communication.internal.CommunicationResource;
import com.sohum.autotalk.config.HelloWorldConfiguration;
import com.sohum.autotalk.messages.internal.MessageResource;
import com.sohum.autotalk.traffic.internal.CurrentUserLocationMap;
import com.sohum.autotalk.traffic.internal.NeighboursResource;
import com.sohum.autotalk.traffic.internal.TrafficResource;
import com.sohum.autotalk.traffic.internal.UserLocationDAO;
import com.sohum.autotalk.traffic.internal.model.UserLocation;
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

  private final HibernateBundle<HelloWorldConfiguration> hibernate = new HibernateBundle<HelloWorldConfiguration>(User.class,
    UserLocation.class
  ) {
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
    final UserLocationDAO locationDAO = new UserLocationDAO(hibernate.getSessionFactory());
    final CurrentUserLocationMap map = new CurrentUserLocationMap(helloWorldConfiguration.getNeighbourConfiguration());

    final TrafficResource resource = new TrafficResource(locationDAO, map);
    environment.jersey().register(resource);

    final UserResource userResource = new UserResource(dao);
    environment.jersey().register(userResource);

    final NeighboursResource neighboursResource = new NeighboursResource(locationDAO, map);
    environment.jersey().register(neighboursResource);

    final ICommunicationResource communicationResource = new CommunicationResource();

    final MessageResource messageResource = new MessageResource(neighboursResource, communicationResource);
    environment.jersey().register(messageResource);
  }
}

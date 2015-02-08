package com.sohum.autotalk.traffic.internal;

import com.sohum.autotalk.common.GeoLocation;
import com.sohum.autotalk.traffic.internal.model.UserLocation;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class UserLocationDAO extends AbstractDAO<UserLocation> {

  public UserLocationDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public void storeDetails(Integer id, GeoLocation geoLocation) {
    UserLocation location = new UserLocation();
    location.setUserId(id);
    location.setLatitude(geoLocation.getLatitude());
    location.setLongitude(geoLocation.getLongitude());

    persist(location);
  }
}

package com.sohum.autotalk.traffic.internal;

import com.google.common.base.Optional;
import com.sohum.autotalk.common.GeoLocation;
import com.sohum.autotalk.traffic.internal.model.UserLocation;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;

public class UserLocationDAO extends AbstractDAO<UserLocation> {

  @PersistenceContext
  protected EntityManager em;

  public UserLocationDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public void storeDetails(Integer id, GeoLocation geoLocation, Long epochTime) {
    UserLocation location = new UserLocation();
    location.setUserId(id);
    location.setLatitude(geoLocation.getLatitude());
    location.setLongitude(geoLocation.getLongitude());
    location.setTimestamp(new Timestamp(epochTime));

    persist(location);
  }

  public Optional<UserLocation> getLocation(Integer userId) {

    UserLocation userLocation = (UserLocation)em.createNamedQuery("userLocation.getLocationForUser")
      .setParameter("userId", userId)
      .getSingleResult();

    return Optional.of(userLocation);
  }

  public List<UserLocation> findAll() {
    return list(namedQuery("userLocation.findAll"));
  }
}

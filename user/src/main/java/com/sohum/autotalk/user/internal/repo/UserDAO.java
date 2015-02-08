package com.sohum.autotalk.user.internal.repo;

import com.sohum.autotalk.user.internal.model.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;


import java.util.List;

public class UserDAO extends AbstractDAO<User> {
  public UserDAO(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public User createUser(User user) {
    return persist(user);
  }

  public List<User> findAll() {
    return list(namedQuery("user.findAll"));
  }
}

package com.sohum.autotalk.user.internal.repo;

import com.google.common.collect.Lists;
import com.sohum.autotalk.user.internal.model.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionBuilderImplementor;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.internal.QueryImpl;

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

package com.sohum.autotalk.common;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class DatabaseRepository<T, ID extends Serializable> {
  private final Provider<EntityManager> entityManagerProvider;

  @Inject
  public DatabaseRepository(Provider<EntityManager> entityManagerProvider) {
    this.entityManagerProvider = entityManagerProvider;
  }

  public void persist(T t) {
    this.entityManagerProvider.get().persist(t);
  }
}

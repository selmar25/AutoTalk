package com.sohum.autotalk.user.internal;

import com.sohum.autotalk.user.IUserResource;
import com.sohum.autotalk.user.internal.model.User;
import com.sohum.autotalk.user.internal.repo.UserDAO;
import com.sohum.autotalk.user.response.UserList;
import com.sohum.autotalk.user.response.UserResponse;
import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserResource implements IUserResource {

  private UserDAO userDao;

  @Inject
  public UserResource(UserDAO userDAO) {
    this.userDao = userDAO;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @UnitOfWork
  @Override
  public UserList getAllUsers() {

    UserList userList = new UserList();

    List<User> list = userDao.findAll();

    for (User user : list) {
      UserResponse item = new UserResponse();
      item.setId(user.getId());
      item.setFirstName(user.getFirstName());
      item.setLastName(user.getLastName());

      userList.getList().add(item);
    }

    return userList;
  }
}

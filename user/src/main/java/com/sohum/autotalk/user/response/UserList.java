package com.sohum.autotalk.user.response;

import com.google.common.collect.Lists;
import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;

import java.util.List;

@Data
@JsonSnakeCase
public class UserList {
  private Long count;
  private List<UserResponse> list = Lists.newArrayList();
}

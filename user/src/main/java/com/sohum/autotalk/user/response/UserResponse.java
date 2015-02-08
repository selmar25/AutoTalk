package com.sohum.autotalk.user.response;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;

@Data
@JsonSnakeCase
public class UserResponse {

  private Integer id;
  private String firstName;
  private String lastName;
}

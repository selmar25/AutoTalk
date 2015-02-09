package com.sohum.autotalk.messages.request;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;

@Data
@JsonSnakeCase
public class MessageRequest {
  private Integer userId;
  private String message;
}

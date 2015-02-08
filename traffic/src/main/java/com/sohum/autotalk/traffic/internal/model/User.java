package com.sohum.autotalk.traffic.internal.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class User {
  private Long id;
  private String firstName;
  private String lastName;
}

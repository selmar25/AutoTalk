package com.sohum.autotalk.user.internal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
@NamedQuery(name="user.findAll", query="from User p")
public class User {
  @Id
  private Integer id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
}

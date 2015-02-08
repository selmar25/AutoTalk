package com.sohum.autotalk.traffic.internal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_location")
public class UserLocation {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "latitude")
  private double latitude;

  @Column(name = "longitude")
  private double longitude;
}

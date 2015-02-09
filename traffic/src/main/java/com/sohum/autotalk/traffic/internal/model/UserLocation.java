package com.sohum.autotalk.traffic.internal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user_location")
@NamedQueries({
  @NamedQuery(name="userLocation.findAll", query="from UserLocation p"),
  @NamedQuery(name="userLocation.getLocationForUser", query="FROM UserLocation p WHERE p.userId = :userId")
}
)
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

  @Column(name = "timestamp")
  private Timestamp timestamp;
}

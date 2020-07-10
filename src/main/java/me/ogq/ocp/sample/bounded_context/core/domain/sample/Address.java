package me.ogq.ocp.sample.bounded_context.core.domain.sample;

import javax.persistence.Embeddable;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/07/10 Time: 11:43 오전
 */
@Embeddable
public class Address {
  private String city;
  private String country;
  private String fullAddress;

  public Address(String city, String country, String fullAddress){
    this.city = city;
    this.country = country;
    this.fullAddress = fullAddress;
  }

  public String city(){
    return this.city;
  }

  public String country(){
    return this.country;
  }

  public String fullAddress(){
    return this.fullAddress;
  }
}

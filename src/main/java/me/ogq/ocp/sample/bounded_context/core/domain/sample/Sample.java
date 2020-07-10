package me.ogq.ocp.sample.bounded_context.core.domain.sample;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import me.ogq.ocp.sample.bounded_context.adapter.outbound.persistance.jpa.converter.AddressConverter;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/07/07 Time: 2:19 오후
 */
@Entity
public class Sample {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long no;

  @Column(length = 20)
  private String name;

  private int age;

  @Embedded
  @Convert(converter = AddressConverter.class)
  private Address address;

  public Sample(String name, int age){
    this.name = name;
    this.age = age;
  }

  public String name(){
    return this.name;
  }

  public int age(){
    return this.age;
  }
}

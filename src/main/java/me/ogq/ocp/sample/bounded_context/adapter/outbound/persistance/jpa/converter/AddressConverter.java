package me.ogq.ocp.sample.bounded_context.adapter.outbound.persistance.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import me.ogq.ocp.sample.bounded_context.core.domain.sample.Address;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/07/09 Time: 3:10 오후
 */
@Converter
public class AddressConverter implements AttributeConverter<Address, String> {

  @Override
  public String convertToDatabaseColumn(Address attribute) {
    return attribute.city() + "|" + attribute.country() + "|" + attribute.fullAddress();
  }

  @Override
  public Address convertToEntityAttribute(String dbData) {
    String[] splitArr = dbData.split("\\|");
    return new Address(splitArr[0], splitArr[1], splitArr[2]);
  }
}

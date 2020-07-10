package me.ogq.ocp.sample.bounded_context.adapter.inbound.event.message;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/07/07 Time: 2:30 오후
 */
@Data
@NoArgsConstructor
public class SampleKafkaMessage<T> {
  private T data;
}

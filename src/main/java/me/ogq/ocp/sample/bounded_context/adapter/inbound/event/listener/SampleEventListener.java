package me.ogq.ocp.sample.bounded_context.adapter.inbound.event.listener;

import lombok.extern.slf4j.Slf4j;
import me.ogq.ocp.sample.bounded_context.adapter.inbound.event.message.SampleKafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleEventListener {


  @KafkaListener(topics = "${kafka.topic.sampleTopic}", containerFactory = "sampleListenerContainerFactory")
  public void subscribe(SampleKafkaMessage dto) {

  }

}

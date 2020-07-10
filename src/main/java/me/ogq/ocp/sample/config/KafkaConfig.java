package me.ogq.ocp.sample.config;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Map;
import me.ogq.ocp.sample.bounded_context.adapter.inbound.event.message.SampleKafkaMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties.AckMode;
import org.springframework.kafka.support.serializer.JsonDeserializer;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/07/07 Time: 2:30 오후
 */
@EnableKafka
public class KafkaConfig {

  @Value("${kafka.bootstrap-servers}")
  private String bootstrapServers;

  @Value("${kafka.consumer.groupId}")
  private String groupId;
  @Value("${kafka.consumer.autoOffsetReset}")
  private String autoOffsetReset;

  @Bean(value = "consumerConfigs")
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();

    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);

    return props;
  }

  @Bean("sampleListenerContainerFactory")
  public ConcurrentKafkaListenerContainerFactory<String, SampleKafkaMessage> creatorListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, SampleKafkaMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConcurrency(1);
    factory.getContainerProperties().setAckMode(AckMode.MANUAL);
    factory.setConsumerFactory(
        new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
            new JsonDeserializer<>(new TypeReference<>() {
            }, false)));
    return factory;
  }
}

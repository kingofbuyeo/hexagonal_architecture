package me.ogq.ocp.sample.bounded_context.adapter.inbound.rest.external;

import me.ogq.ocp.sample.bounded_context.core.usecase.sample.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/07/07 Time: 2:25 오후
 */
@RestController
@RequestMapping("ext/sample")
public class SampleExternalResource {
  private final SampleService sampleService;

  @Autowired
  public SampleExternalResource(
      SampleService sampleService) {
    this.sampleService = sampleService;
  }

  @GetMapping
  public Mono<ResponseEntity> findAllSample(){
    return Mono.just(ResponseEntity.ok().build());
  }
}

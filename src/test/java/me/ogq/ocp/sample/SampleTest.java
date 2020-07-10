package me.ogq.ocp.sample;

import me.ogq.ocp.sample.bounded_context.core.usecase.sample.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/07/07 Time: 2:41 오후
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class SampleTest {
  private final SampleService sampleService;

  @Autowired
  public SampleTest(
      SampleService sampleService) {
    this.sampleService = sampleService;
  }

}

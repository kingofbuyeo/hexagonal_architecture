package me.ogq.ocp.sample.bounded_context.core.usecase.sample;

import me.ogq.ocp.sample.bounded_context.core.domain.sample.Sample;
import me.ogq.ocp.sample.bounded_context.core.domain.sample.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/07/07 Time: 2:21 오후
 */
@Service
public class SampleService {
  private final SampleRepository sampleRepository;

  @Autowired
  public SampleService(
      SampleRepository sampleRepository) {
    this.sampleRepository = sampleRepository;
  }

  @Transactional
  public void save(Sample sample){
    sampleRepository.save(sample);
  }
}
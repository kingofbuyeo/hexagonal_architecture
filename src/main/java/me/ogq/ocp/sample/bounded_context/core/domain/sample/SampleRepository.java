package me.ogq.ocp.sample.bounded_context.core.domain.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/07/07 Time: 2:20 오후
 */
@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

}

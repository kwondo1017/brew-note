package org.travelslog.brewnote.bean.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.bean.entity.BeanTastingLog;

public interface BeanTastingLogRepository extends JpaRepository<BeanTastingLog, Long> {
    List<BeanTastingLog> findByBeanIdOrderByTastingDateDesc(Long beanId);
}
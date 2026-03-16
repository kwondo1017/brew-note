package org.travelslog.brewnote.bean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.bean.entity.BeanTastingLog;

public interface BeanTastingLogRepository extends JpaRepository<BeanTastingLog, Long> {
}
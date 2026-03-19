package org.travelslog.brewnote.bean.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.bean.entity.relation.BeanTastingLogCupNoteRelation;

public interface BeanTastingLogCupNoteRelationRepository extends JpaRepository<BeanTastingLogCupNoteRelation, Long> {
    List<BeanTastingLogCupNoteRelation> findByBeanTastingLogId(Long beanTastingLogId);
}
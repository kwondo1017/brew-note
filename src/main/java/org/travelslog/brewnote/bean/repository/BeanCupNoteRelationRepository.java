package org.travelslog.brewnote.bean.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.bean.entity.relation.BeanCupNoteRelation;

public interface BeanCupNoteRelationRepository extends JpaRepository<BeanCupNoteRelation, Long> {
    List<BeanCupNoteRelation> findByBeanId(Long beanId);
}
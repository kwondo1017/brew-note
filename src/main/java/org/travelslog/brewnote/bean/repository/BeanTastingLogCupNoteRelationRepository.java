package org.travelslog.brewnote.bean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.bean.entity.Bean;

public interface BeanTastingLogCupNoteRelationRepository extends JpaRepository<Bean, Long> {
}
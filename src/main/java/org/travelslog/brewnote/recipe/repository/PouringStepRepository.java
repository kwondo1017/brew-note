package org.travelslog.brewnote.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.bean.entity.Bean;

public interface PouringStepRepository extends JpaRepository<Bean, Long> {
}
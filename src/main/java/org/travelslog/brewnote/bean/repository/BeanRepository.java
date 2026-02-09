package org.travelslog.brewnote.bean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.bean.Entity.Bean;

public interface BeanRepository extends JpaRepository<Bean, Long> {
}

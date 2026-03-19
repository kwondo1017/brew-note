package org.travelslog.brewnote.bean.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.bean.entity.Bean;

public interface BeanRepository extends JpaRepository<Bean, Long> {
    List<Bean> findByBeanNameContainingIgnoreCase(String beanName);
    List<Bean> findByRoasteryContainingIgnoreCase(String roastery);
    List<Bean> findByCountryContainingIgnoreCase(String country);
}

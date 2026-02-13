package org.travelslog.brewnote.bean.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.travelslog.brewnote.bean.entity.Bean;
import org.travelslog.brewnote.bean.repository.BeanRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BeanService {

    private final BeanRepository beanRepository;

    public Long create(String beanName) {
        Bean bean = new Bean(beanName);
        return beanRepository.save(bean).getId();
    }

    @Transactional(readOnly = true)
    public Bean get(Long id) {

        return beanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bean not found"));
    }

    public void update(Long id, String beanName, String roastery, Integer price, String purchaseUrl) {
        Bean bean = get(id);
        bean.update(beanName, roastery, price, purchaseUrl);
    }

    public void delete(Long id) {
        beanRepository.deleteById(id);
    }
}   
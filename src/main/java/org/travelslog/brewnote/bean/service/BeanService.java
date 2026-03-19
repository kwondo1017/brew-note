package org.travelslog.brewnote.bean.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.travelslog.brewnote.bean.entity.Bean;
import org.travelslog.brewnote.bean.entity.command.BeanUpdateCommand;
import org.travelslog.brewnote.bean.repository.BeanRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BeanService {

    private final BeanRepository beanRepository;

    @Transactional
    public Long createBean(BeanUpdateCommand command) {
        Bean bean = new Bean(command.beanName());
        return beanRepository.save(bean).getId();
    }

    @Transactional(readOnly = true)
    public Bean getBean(Long id) {
        return beanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bean not found"));
    }

    @Transactional(readOnly = true)
    public Iterable<Bean> getBeans() {
        return beanRepository.findAll();
    }

    @Transactional
    public void updateBean(Long id, BeanUpdateCommand command) {
        Bean bean = getBean(id);
        bean.apply(command);
    }

    @Transactional
    public void deleteBean(Long id) {
        beanRepository.deleteById(id);
    }
}   
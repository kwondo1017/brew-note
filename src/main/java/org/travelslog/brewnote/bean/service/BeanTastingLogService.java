package org.travelslog.brewnote.bean.service;

import org.springframework.stereotype.Service;
import org.travelslog.brewnote.bean.entity.Bean;
import org.travelslog.brewnote.bean.entity.BeanTastingLog;
import org.travelslog.brewnote.bean.entity.command.BeanTastingLogCreateCommand;
import org.travelslog.brewnote.bean.entity.command.BeanTastingLogUpdateCommand;
import org.travelslog.brewnote.bean.repository.BeanTastingLogRepository;
import org.travelslog.brewnote.bean.repository.BeanRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BeanTastingLogService {

    private final BeanTastingLogRepository beanTastingLogRepository;
    private final BeanRepository beanRepository;

    @Transactional
    public Long createBeanTastingLog(BeanTastingLogCreateCommand command) {
        Bean bean = beanRepository.findById(command.beanId())
                .orElseThrow(() -> new IllegalArgumentException("Bean not found"));

        BeanTastingLog beanTastingLog = new BeanTastingLog(bean, command.tastingDate(), command.tastingNotes());
        return beanTastingLogRepository.save(beanTastingLog).getId();
    }

    @Transactional(readOnly = true)
    public BeanTastingLog getBeanTastingLog(Long id) {
        return beanTastingLogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bean Tasting Log not found"));
    }

    @Transactional
    public BeanTastingLog updateBeanTastingLog(Long id, BeanTastingLogUpdateCommand command) {
        BeanTastingLog beanTastingLog = getBeanTastingLog(id);
        beanTastingLog.apply(command);
        return beanTastingLog;
    }

    @Transactional
    public void deleteBeanTastingLog(Long id) {
        beanTastingLogRepository.deleteById(id);
    }
}

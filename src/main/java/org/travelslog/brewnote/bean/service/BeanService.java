package org.travelslog.brewnote.bean.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.travelslog.brewnote.bean.repository.BeanRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BeanService {
    private final BeanRepository beanRepository;
}
package org.travelslog.brewnote.bean.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bean_tasting_logs")
public class BeanTastingLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long beanId; // NOT NULL
    private Date tastingDate; // NOT NULL
    private int beanScore; // 0-100
    private String tastingNote; // NOT NULL
}
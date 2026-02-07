package org.travelslog.brewnote.bean.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bean_tasting_logs")
public class BeanTastingLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long beanId; // NOT NULL
    @Column(nullable = false)
    private Date tastingDate; // NOT NULL
    private int beanScore; // 0-100
    @Column(nullable = false)
    private String tastingNote; // NOT NULL

    @Column(nullable = false)
    @ManyToOne
    private Bean bean; // NOT NULL

    @OneToMany(mappedBy = "beanTastingLogId")
    private java.util.List<BeanTastingLogCupNote> beanTastingLogCupNotes;
}
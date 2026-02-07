package org.travelslog.brewnote.bean.Entity;

import org.travelslog.brewnote.bean.types.CupNoteType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "bean_tasting_log_cup_notes")
public class BeanTastingLogCupNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long beanTastingLogId; // NOT NULL
    @Column(nullable = false)
    private Long cupNoteId; // NOT NULL
    @Column(nullable = false)
    private CupNoteType cupNoteType; // NOT NULL

    @Column(nullable = false)
    @ManyToOne
    private BeanTastingLog beanTastingLog; // NOT NULL

    @Column(nullable = false)
    @ManyToOne
    private CupNote cupNote; // NOT NULL
}
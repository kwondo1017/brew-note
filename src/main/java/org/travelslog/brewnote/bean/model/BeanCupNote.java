package org.travelslog.brewnote.bean.model;

import org.travelslog.brewnote.bean.types.CupNoteType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "bean_cup_notes")
public class BeanCupNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long beanId; // NOT NULL
    private Long cupNoteId; // NOT NULL
    private CupNoteType cupNoteType; // NOT NULL

    @ManyToOne
    private Bean bean; // NOT NULL

    @ManyToOne
    private CupNote cupNote; // NOT NULL
}

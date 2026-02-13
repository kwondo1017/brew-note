package org.travelslog.brewnote.bean.entity.relation;

import org.travelslog.brewnote.bean.entity.BeanTastingLog;
import org.travelslog.brewnote.cupnote.entity.CupNote;
import org.travelslog.brewnote.cupnote.entity.CupNoteType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Table (name = "bean_tasting_log_cup_note_relation")
public class BeanTastingLogCupNoteRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(name = "bean_tasting_log_id", nullable = false)
    private BeanTastingLog beanTastingLog; // NOT NULL

    @ManyToOne
    @Column(name = "cup_note_id", nullable = false)
    private CupNote cupNote; // NOT NULL

    @Column(name = "type", nullable = false)
    private CupNoteType type; // NOT NULL
}
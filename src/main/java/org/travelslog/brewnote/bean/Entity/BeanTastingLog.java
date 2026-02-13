package org.travelslog.brewnote.bean.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import org.travelslog.brewnote.bean.entity.command.BeanTastingLogUpdateCommand;
import org.travelslog.brewnote.bean.entity.relation.BeanTastingLogCupNoteRelation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bean_tasting_log")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class BeanTastingLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bean_id", nullable = false)
    private Bean bean;

    @Column(name = "tasting_date", nullable = false)
    private LocalDate tastingDate; // NOT NULL

    @Column(name = "bean_score")
    private Integer beanScore; // 0-100

    @Column(name = "tasting_note", nullable = false)
    private String tastingNote; // NOT NULL

    @OneToMany(mappedBy = "beanTastingLog")
    private java.util.List<BeanTastingLogCupNoteRelation> beanTastingLogCupNoteRelation = new ArrayList<>();

    public BeanTastingLog(Bean bean, LocalDate tastingDate, String tastingNote) {
        if (bean == null) {
            throw new IllegalArgumentException("bean must not be null");
        }
        if (tastingDate == null) {
            throw new IllegalArgumentException("tastingDate must not be null");
        }
        if (tastingNote == null || tastingNote.isBlank()) {
            throw new IllegalArgumentException("tastingNote must not be blank");
        }
        this.bean = bean;
        this.tastingDate = tastingDate;
        this.tastingNote = tastingNote;
    }

    public void apply(BeanTastingLogUpdateCommand command) {
        if (command.tastingDate() != null) {
            this.tastingDate = command.tastingDate();
        }
        if (command.beanScore() != null) {
            this.beanScore = command.beanScore();
        }
        if (command.tastingNote() != null && !command.tastingNote().isBlank()) {
            this.tastingNote = command.tastingNote();
        }
    }
}
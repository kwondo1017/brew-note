package org.travelslog.brewnote.bean.Entity;

import java.time.LocalDate;
import java.util.ArrayList;

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

@Entity
@Getter
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
    private java.util.List<BeanTastingLogCupNoteRelation> beanTastingLogCupNotes = new ArrayList<>();
}
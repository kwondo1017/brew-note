package org.travelslog.brewnote.cupnote.entity;

import org.travelslog.brewnote.bean.entity.relation.BeanCupNoteRelation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cup_note")
public class CupNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_name", nullable = false)
    private String tagName; // NOT NULL

    @OneToMany(mappedBy = "cupNote")
    private java.util.List<BeanCupNoteRelation> beanCupNoteRelation = new java.util.ArrayList<>();
}
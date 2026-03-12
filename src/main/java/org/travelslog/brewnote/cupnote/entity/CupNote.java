package org.travelslog.brewnote.cupnote.entity;

import org.travelslog.brewnote.bean.entity.relation.BeanCupNoteRelation;
import org.travelslog.brewnote.cupnote.entity.command.CupNoteUpdateCommand;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "cup_note")
public class CupNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_name", nullable = false)
    private String tagName; // NOT NULL

    @OneToMany(
        mappedBy = "cupNote",
        cascade = jakarta.persistence.CascadeType.ALL,
        orphanRemoval = true
    )
    private java.util.List<BeanCupNoteRelation> beanCupNoteRelation = new java.util.ArrayList<>();

    public CupNote(String tagName) {
        if (tagName == null || tagName.isBlank()) {
            throw new IllegalArgumentException("tagName must not be blank");
        }
        this.tagName = tagName;
    }

    public void apply(CupNoteUpdateCommand command) {
        if (command.tagName() == null || command.tagName().isBlank()) {
            throw new IllegalArgumentException("tagName must not be blank");
        }
        this.tagName = command.tagName();
    }
}
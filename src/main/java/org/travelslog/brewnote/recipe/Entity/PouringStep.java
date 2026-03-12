package org.travelslog.brewnote.recipe.entity;

import org.travelslog.brewnote.recipe.entity.command.PouringStepUpdateCommand;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Table(name = "pouring_step")
public class PouringStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe; // NOT NULL

    @Column(name = "step_name", nullable = false)
    private String stepName; // NOT NULL
    @Column(name = "step_note", nullable = false)
    private String stepNote; // NOT NULL
    @Column(name = "step_time", nullable = false)
    private String stepTime; // NOT NULL
    @Column(name = "step_order_index", nullable = false)
    private int stepOrderIndex; // NOT NULL

    public PouringStep(Recipe recipe, String stepName, String stepNote, String stepTime, int stepOrderIndex) {
        if (recipe == null) {
            throw new IllegalArgumentException("recipe must not be null");
        }
        if (stepName == null || stepName.isBlank()) {
            throw new IllegalArgumentException("stepName must not be blank");
        }
        if (stepNote == null || stepNote.isBlank()) {
            throw new IllegalArgumentException("stepNote must not be blank");
        }
        if (stepTime == null || stepTime.isBlank()) {
            throw new IllegalArgumentException("stepTime must not be blank");
        }
        if (stepOrderIndex < 0) {
            throw new IllegalArgumentException("stepOrderIndex must be non-negative");
        }
        this.recipe = recipe;
        this.stepName = stepName;
        this.stepNote = stepNote;
        this.stepTime = stepTime;
        this.stepOrderIndex = stepOrderIndex;
    }

    public void apply(PouringStepUpdateCommand command) {
        if (command.stepName() != null && !command.stepName().isBlank()) {
            this.stepName = command.stepName();
        }
        if (command.stepNote() != null && !command.stepNote().isBlank()) {
            this.stepNote = command.stepNote();
        }
        if (command.stepTime() != null && !command.stepTime().isBlank()) {
            this.stepTime = command.stepTime();
        }
        if (command.stepOrderIndex() >= 0) {
            this.stepOrderIndex = command.stepOrderIndex();
        }
    }
}
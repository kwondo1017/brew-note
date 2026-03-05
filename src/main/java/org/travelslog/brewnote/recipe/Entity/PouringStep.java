package org.travelslog.brewnote.recipe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "pouring_step")
public class PouringStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "recipe_id", nullable = false)
    private Long recipeId; // NOT NULL
    @Column(name = "step_name", nullable = false)
    private String stepName; // NOT NULL
    @Column(name = "step_note", nullable = false)
    private String stepNote; // NOT NULL
    @Column(name = "step_time", nullable = false)
    private String stepTime; // NOT NULL

    @ManyToOne
    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
    private Recipe recipe; // NOT NULL
}


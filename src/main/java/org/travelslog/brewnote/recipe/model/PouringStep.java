package org.travelslog.brewnote.recipe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pouring_steps")
public class PouringStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long recipeId; // NOT NULL
    private String stepName; // NOT NULL
    private String stepNote; // NOT NULL
    private String stepTime; // NOT NULL
    private int pouringOrder; // 단계 순서 인덱스

    @ManyToOne
    private Recipe recipe; // NOT NULL
}


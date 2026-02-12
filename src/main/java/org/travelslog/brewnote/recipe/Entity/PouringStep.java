package org.travelslog.brewnote.recipe.Entity;

import jakarta.persistence.Column;
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
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long recipeId; // NOT NULL
    @Column(nullable = false)
    private String stepName; // NOT NULL
    @Column(nullable = false)
    private String stepNote; // NOT NULL
    @Column(nullable = false)
    private String stepTime; // NOT NULL

    @ManyToOne
    private Recipe recipe; // NOT NULL
}


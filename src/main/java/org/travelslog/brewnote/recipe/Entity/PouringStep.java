package org.travelslog.brewnote.recipe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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


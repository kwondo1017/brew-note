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
}


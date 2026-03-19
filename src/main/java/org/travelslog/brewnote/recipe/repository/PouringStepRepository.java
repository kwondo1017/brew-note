package org.travelslog.brewnote.recipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.recipe.entity.PouringStep;

public interface PouringStepRepository extends JpaRepository<PouringStep, Long> {
    List<PouringStep> findByRecipeIdOrderByStepOrderIndexAsc(Long recipeId);
}
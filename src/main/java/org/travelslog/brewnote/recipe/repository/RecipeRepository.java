package org.travelslog.brewnote.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
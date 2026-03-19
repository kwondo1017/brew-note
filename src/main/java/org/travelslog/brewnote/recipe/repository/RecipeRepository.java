package org.travelslog.brewnote.recipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travelslog.brewnote.recipe.entity.BeverageType;
import org.travelslog.brewnote.recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByBeverageType(BeverageType beverageType);
}
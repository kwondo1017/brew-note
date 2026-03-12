package org.travelslog.brewnote.recipe.entity.command;

import java.math.BigDecimal;

import org.travelslog.brewnote.recipe.entity.BeverageType;

public record RecipeUpdateCommand(
    String recipeName,
    BeverageType beverageType,
    String dripper,
    String filter,
    String grinder,
    Integer grindSetting,
    String recommendRoastingPoint,
    BigDecimal beanWeight,
    BigDecimal waterWeight,
    Integer waterTemperature,
    String recipeUrl
) {}
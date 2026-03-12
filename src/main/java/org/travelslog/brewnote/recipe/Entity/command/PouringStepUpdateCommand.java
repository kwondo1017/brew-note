package org.travelslog.brewnote.recipe.entity.command;

public record PouringStepUpdateCommand(
    String stepName,
    String stepNote,
    String stepTime,
    Integer stepOrderIndex
) {}
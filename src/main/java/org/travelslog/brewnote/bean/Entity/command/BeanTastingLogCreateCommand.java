package org.travelslog.brewnote.bean.entity.command;

import java.time.LocalDate;

public record BeanTastingLogCreateCommand(
    Long beanId,
    LocalDate tastingDate,
    String tastingNotes) {
}

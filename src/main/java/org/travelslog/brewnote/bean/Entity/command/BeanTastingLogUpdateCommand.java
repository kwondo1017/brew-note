package org.travelslog.brewnote.bean.entity.command;

import java.time.LocalDate;

public record BeanTastingLogUpdateCommand(
    LocalDate tastingDate,
    Integer beanScore,
    String tastingNote) {
}

package org.travelslog.brewnote.bean.entity.command;

public record BeanUpdateCommand(
    String beanName,
    String roastery,
    Integer price,
    String beanImageUrl,
    String purchaseUrl,
    String country,
    String region,
    String farm,
    String producer,
    String variety,
    Integer altitude,
    String process,
    Integer roastingPoint,
    java.time.LocalDate roastingDate) {
} 
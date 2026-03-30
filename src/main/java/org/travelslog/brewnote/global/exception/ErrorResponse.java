package org.travelslog.brewnote.global.exception;

public record ErrorResponse(
    String code,
    String message
) {
}

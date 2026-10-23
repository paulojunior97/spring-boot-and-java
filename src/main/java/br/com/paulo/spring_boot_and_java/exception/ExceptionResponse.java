package br.com.paulo.spring_boot_and_java.exception;

import java.time.LocalDate;

public record ExceptionResponse(LocalDate data, String mensagem, String detalhes) {
}

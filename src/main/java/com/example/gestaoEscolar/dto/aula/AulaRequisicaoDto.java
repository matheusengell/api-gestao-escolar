package com.example.gestaoEscolar.dto.aula;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(name = "AulaRequisicao", description = "Dados necessários para cadastrar ou atualizar uma aula")
public record AulaRequisicaoDto(


        @Schema(description = "ID da turma vinculada à aula", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "O id da turma deve ser preenchido")
        @Positive(message = "O id da turma deve ser positivo")
        Long turma_id,

        @Schema(description = "Data e hora do agendamento da aula (Formato ISO: YYYY-MM-DDTHH:mm:ss)", example = "2026-04-10T19:30:00", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "A data e hora da aula são obrigatórias")
        @FutureOrPresent(message = "A aula deve ser agendada para o presente ou futuro")
        LocalDateTime data_hora,

        @Schema(description = "Assunto principal ou tema da aula", example = "Introdução ao Polimorfismo em Java", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "O assunto é obrigatorio")
        String assunto
) {
}

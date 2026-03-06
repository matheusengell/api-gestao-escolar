package com.example.gestaoEscolar.dto.aula;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AulaRequisicaoDto(
        @NotNull(message = "O id da turma deve ser preenchido")
        @Positive(message = "O id da turma deve ser positivo")
       Long turma_id,


        @NotNull(message = "A data e hora da aula são obrigatórias")
        @FutureOrPresent(message = "A aula deve ser agendada para o presente ou futuro")
        LocalDateTime data_hora,

        @NotBlank(message = "O assunto é obrigatorio")
        String assunto
) {
}

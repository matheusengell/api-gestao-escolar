package com.example.gestaoEscolar.dto.nota;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(name = "NotaRequisicao", description = "Dados necessários para registrar a nota de um aluno")
public record NotaRequisicaoDto(

        @Schema(description = "ID do aluno que recebeu a nota", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
        @Positive(message = "O id deve ser positivo")
        @NotNull(message = "O id do aluno não deve ser nulo")
        Long alunoId,

        @Schema(description = "ID da aula referente à avaliação", example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
        @Positive(message = "O id deve ser positivo")
        @NotNull(message = "O id da aula não deve ser nulo")
        Long aulaId,

        @Schema(description = "Valor da nota obtida (0 a 10)", example = "8.5", requiredMode = Schema.RequiredMode.REQUIRED)
        @Positive(message = "O valor deve ser positivo")
        double valor
) {
}
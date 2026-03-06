package com.example.gestaoEscolar.dto.nota;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record NotaRequisicaoDto(

        @Positive(message = "O id deve ser positivo")
        @NotNull(message = "O id do aluno não deve ser nulo")
        Long alunoId,

        @Positive(message = "O id deve ser positivo")
        @NotNull(message = "O id da aula não deve ser nulo")
        Long aulaId,

        @Positive(message = "O valor deve ser positivo")
        double valor
) {
}

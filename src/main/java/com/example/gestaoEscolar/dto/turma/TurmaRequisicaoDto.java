package com.example.gestaoEscolar.dto.turma;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TurmaRequisicaoDto(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotNull(message = "O id do curso é obrigatório")
        Long curso_id,

        @NotNull(message = "O id do curso é obrigatório")
        Long professor_id
) {
}

package com.example.gestaoEscolar.dto.curso;

import jakarta.validation.constraints.NotBlank;

public record CursoRequisicaoDto(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O código é obrigatório")
        String codigo
) {
}

package com.example.gestaoEscolar.dto.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ProfessorRequisicaoDto(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email deve estar no formato correto")
        String email,

        @NotBlank(message = "A disciplina deve ser obrigatória")
        String disciplina
) {
}

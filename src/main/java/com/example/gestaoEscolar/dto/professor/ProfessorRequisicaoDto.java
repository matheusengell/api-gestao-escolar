package com.example.gestaoEscolar.dto.professor;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "ProfessorRequisicao", description = "Dados para cadastro de um professor")
public record ProfessorRequisicaoDto(
        @Schema(description = "Nome completo do professor", example = "Sérgio Ricardo")
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @Schema(description = "E-mail de contato", example = "sergio.prof@escola.com")
        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email deve estar no formato correto")
        String email,

        @Schema(description = "Disciplina que o professor leciona", example = "Matemática")
        @NotBlank(message = "A disciplina deve ser obrigatória")
        String disciplina
) {
}


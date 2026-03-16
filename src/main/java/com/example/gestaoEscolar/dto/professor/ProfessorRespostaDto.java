package com.example.gestaoEscolar.dto.professor;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ProfessorResposta", description = "Dados de retorno do professor")
public record ProfessorRespostaDto(
        @Schema(description = "ID do professor no banco", example = "1")
        long id,

        @Schema(description = "Nome do professor", example = "Sérgio Ricardo")
        String nome,

        @Schema(description = "E-mail do professor", example = "sergio.prof@escola.com")
        String email,

        @Schema(description = "Disciplina lecionada", example = "Matemática")
        String disciplina
) {
}

package com.example.gestaoEscolar.dto.turma;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "TurmaResposta", description = "Dados de retorno de uma turma cadastrada")
public record TurmaRespostaDto(

        @Schema(description = "ID único da turma", example = "1")
        long id,

        @Schema(description = "Nome identificador da turma", example = "Turma 101 - Noturno")
        String nome,

        @Schema(description = "ID do curso vinculado", example = "2")
        long curso_id,

        @Schema(description = "ID do professor responsável", example = "5")
        long professor_id
) {
}

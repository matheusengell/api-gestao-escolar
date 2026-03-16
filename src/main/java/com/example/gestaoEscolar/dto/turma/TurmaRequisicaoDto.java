package com.example.gestaoEscolar.dto.turma;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(name = "TurmaRequisicao", description = "Dados necessários para criar ou atualizar uma turma")
public record TurmaRequisicaoDto(

        @Schema(description = "Nome identificador da turma", example = "Turma A - 2026", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @Schema(description = "ID do curso ao qual a turma pertence", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "O id do curso é obrigatório")
        Long curso_id,

        @Schema(description = "ID do professor responsável pela turma", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "O id do professor é obrigatório")
        Long professor_id
) {
}

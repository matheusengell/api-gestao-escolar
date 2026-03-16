package com.example.gestaoEscolar.dto.curso;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "CursoRequisicao", description = "Dados necessários para criar ou atualizar um curso")
public record CursoRequisicaoDto(

        @Schema(description = "Nome do Curso", example = "Desenvimento de Sistemas")
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @Schema(description = "Código identificador do curso na instituição", example = "ADS-01", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "O código é obrigatório")
        String codigo
) {
}

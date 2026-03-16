package com.example.gestaoEscolar.dto.curso;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CursoResposta", description = "Objeto que representa os dados de retorno de um curso")
public record CursoRespostaDto(

        @Schema(description = "ID único do curso no banco de dados", example = "1")
        long id,

        @Schema(description = "Nome do curso cadastrado", example = "Desenvolvimento de Sistemas")
        String nome,

        @Schema(description = "Código de identificação do curso", example = "ADS-01")
        String codigo
) {
}
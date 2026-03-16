package com.example.gestaoEscolar.dto.nota;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "NotaResposta", description = "Representação dos dados de uma nota registrada")
public record NotaRespostaDto(

        @Schema(description = "ID único do registro da nota", example = "1")
        long id,

        @Schema(description = "ID do aluno", example = "10")
        long alunoId,

        @Schema(description = "ID da aula", example = "5")
        long aulaId,

        @Schema(description = "Valor da nota", example = "8.5")
        double valor
) {
}
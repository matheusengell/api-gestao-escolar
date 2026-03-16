package com.example.gestaoEscolar.dto.aula;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(name = "AulaResposta", description ="Objeto que representa dados de um retorno de uma aula")
public record AulaRespostaDto(

        @Schema(description = "ID único da aula gerado pelo sistema", example = "1")
        long id,

        @Schema(description = "ID da turma vinculada a esta aula", example = "5")
        long turma_id,

        @Schema(description = "Data e hora em que a aula será realizada", example = "2026-04-10T19:30:00")
        LocalDateTime data_hora,

        @Schema(description = "Assunto ou tema que foi/será abordado", example = "Introdução ao Polimorfismo")
        String assunto
) {
}

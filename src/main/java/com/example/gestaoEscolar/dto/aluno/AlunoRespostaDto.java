package com.example.gestaoEscolar.dto.aluno;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(name = "AlunoResposta", description = "Objeto que representa dados de um retorno de um aluno")
public record AlunoRespostaDto(

        @Schema(description = "Identificador único do aluno no banco de dados", example = "1")
        long id,

        @Schema(description = "Nome completo do aluno", example = "Matheus Engel")
        String nome,

        @Schema(description = "Endereço de e-mail cadastrado", example = "matheus_engel@estudante.sesisenai.org.br")
        String email,

        @Schema(description = "Código de matrícula do aluno", example = "2026-MAT-01")
        String matricula,

        @Schema(description = "Data de nascimento do aluno no formato ISO (YYYY-MM-DD)", example = "2007-07-06")
        LocalDate dataNascimento

) {
}

package com.example.gestaoEscolar.dto.turma;

public record TurmaRespostaDto(
        long id,
        String nome,
        long curso_id,
        long professor_id
) {
}

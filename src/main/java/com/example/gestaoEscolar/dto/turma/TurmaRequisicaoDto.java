package com.example.gestaoEscolar.dto.turma;

public record TurmaRequisicaoDto(
        String nome,
        long curso_id,
        long professor_id
) {
}

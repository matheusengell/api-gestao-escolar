package com.example.gestaoEscolar.dto.nota;

public record NotaRequisicaoDto(
        long alunoId,
        long aulaId,
        double valor
) {
}

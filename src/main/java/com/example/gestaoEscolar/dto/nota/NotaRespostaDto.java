package com.example.gestaoEscolar.dto.nota;

public record NotaRespostaDto(
        long id,
        long alunoId,
        long aulaId,
        double valor
) {
}

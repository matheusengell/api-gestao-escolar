package com.example.gestaoEscolar.dto.aluno;

import java.time.LocalDate;

public record AlunoRespostaDto(
        long id,
        String nome,
        String email,
        String matricula,
        LocalDate dataNascimento

) {
}

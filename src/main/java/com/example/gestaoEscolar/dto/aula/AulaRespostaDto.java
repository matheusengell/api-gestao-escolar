package com.example.gestaoEscolar.dto.aula;

import java.time.LocalDateTime;

public record AulaRespostaDto(
        long id,
        long turma_id,
        LocalDateTime data_hora,
        String assunto
) {
}

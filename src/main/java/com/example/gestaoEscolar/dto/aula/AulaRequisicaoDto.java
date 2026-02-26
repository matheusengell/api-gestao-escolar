package com.example.gestaoEscolar.dto.aula;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AulaRequisicaoDto(
       long turma_id,
       LocalDateTime data_hora,
       String assunto
) {
}

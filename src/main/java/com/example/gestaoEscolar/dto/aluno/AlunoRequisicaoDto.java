package com.example.gestaoEscolar.dto.aluno;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(name = "AlunoRequisicao", description = "Dados necessários para cadastrar ou atualizar um aluno")
public record AlunoRequisicaoDto(

        @Schema(description = "Nome completo do estudante", example = "Matheus Engel")
        @NotBlank(message = "O nome deve ser obrigatório")
        @Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres")
     String nome,


        @Schema(description = "E-mail para contato", example = "matheus_engel@estudante.sesisenai.org.br")
        @NotBlank(message = "O email deve ser obrigatório")
        @Size(min = 5, max = 100, message = "O nome deve ter entre 5 e 100 caracteres")
        @Email(message = "O email deve estar no formato correto")
     String email,


        @Schema(description = "Código de identificação da matrícula", example = "MAT-2026-001")
        @NotBlank(message = "A matrícula deve ser obrigatória")
     String matricula,


        @Schema(description = "Data de nascimento para cálculo de idade", example = "2007-07-06")
        @Past(message = "A data deve ser no passado")
        @NotNull(message = "A data de nascimento é obrigatória")
     LocalDate dataNascimento
){

}

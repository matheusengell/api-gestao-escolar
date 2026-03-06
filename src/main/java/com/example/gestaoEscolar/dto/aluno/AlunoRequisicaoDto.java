package com.example.gestaoEscolar.dto.aluno;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record AlunoRequisicaoDto(

        @NotBlank(message = "O nome deve ser obrigatório")
        @Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres")
     String nome,

        @NotBlank(message = "O email deve ser obrigatório")
        @Size(min = 5, max = 100, message = "O nome deve ter entre 5 e 100 caracteres")
        @Email(message = "O email deve estar no formato correto")
     String email,

        @NotBlank(message = "A matrícula deve ser obrigatória")
     String matricula,

    @Past(message = "A data deve ser no passado")
        @NotNull(message = "A data de nascimento é obrigatória")
     LocalDate dataNascimento
){

}

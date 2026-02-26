package com.example.gestaoEscolar.mapper;

import com.example.gestaoEscolar.dto.professor.ProfessorRequisicaoDto;
import com.example.gestaoEscolar.dto.professor.ProfessorRespostaDto;
import com.example.gestaoEscolar.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor paraEntidade(ProfessorRequisicaoDto professorRequisicaoDto){
        return new Professor(
                professorRequisicaoDto.nome(),
                professorRequisicaoDto.email(),
                professorRequisicaoDto.disciplina()
        );
    }

    public ProfessorRespostaDto paraDto(Professor professor){
        return new ProfessorRespostaDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina()
        );
    }
}


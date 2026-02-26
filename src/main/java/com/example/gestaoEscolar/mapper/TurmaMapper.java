package com.example.gestaoEscolar.mapper;

import com.example.gestaoEscolar.dto.turma.TurmaRequisicaoDto;
import com.example.gestaoEscolar.dto.turma.TurmaRespostaDto;
import com.example.gestaoEscolar.model.Turma;
import org.springframework.stereotype.Component;

@Component
public class TurmaMapper {

    public Turma paraEntidade (TurmaRequisicaoDto turmaRequisicaoDto){
        return new Turma(
                turmaRequisicaoDto.nome(),
                turmaRequisicaoDto.curso_id(),
                turmaRequisicaoDto.professor_id()
        );
    }

    public TurmaRespostaDto paraDto(Turma turma){
        return new TurmaRespostaDto(
                turma.getId(),
                turma.getNome(),
                turma.getCurso_id(),
                turma.getProfessor_id()
        );
    }
}

package com.example.gestaoEscolar.mapper;

import com.example.gestaoEscolar.dto.aula.AulaRequisicaoDto;
import com.example.gestaoEscolar.dto.aula.AulaRespostaDto;
import com.example.gestaoEscolar.model.Aluno;
import com.example.gestaoEscolar.model.Aula;
import org.springframework.stereotype.Component;

@Component
public class AulaMapper {

    public Aula paraEntidade(AulaRequisicaoDto aulaRequisicaoDto){
        return new Aula(
                aulaRequisicaoDto.turma_id(),
                aulaRequisicaoDto.data_hora(),
                aulaRequisicaoDto.assunto()
        );
    }

    public AulaRespostaDto paraDto(Aula aula){
        return new AulaRespostaDto(
                aula.getId(),
                aula.getTurma_id(),
                aula.getData_hora(),
                aula.getAssunto()
        );
    }
}

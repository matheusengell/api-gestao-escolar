package com.example.gestaoEscolar.mapper;

import com.example.gestaoEscolar.dto.nota.NotaRequisicaoDto;
import com.example.gestaoEscolar.dto.nota.NotaRespostaDto;
import com.example.gestaoEscolar.model.Nota;
import org.springframework.stereotype.Component;

@Component
public class NotaMapper {

    public Nota paraEntidade(NotaRequisicaoDto notaRequisicaoDto){
        return new Nota(
          notaRequisicaoDto.alunoId(),
          notaRequisicaoDto.aulaId(),
          notaRequisicaoDto.valor()
        );
    }

    public NotaRespostaDto paraDto (Nota nota){
        return new NotaRespostaDto(
                nota.getId(),
                nota.getAluno_id(),
                nota.getAula_id(),
                nota.getValor()
        );

    }
}

package com.example.gestaoEscolar.mapper;

import com.example.gestaoEscolar.dto.curso.CursoRequisicaoDto;
import com.example.gestaoEscolar.dto.curso.CursoRespostaDto;
import com.example.gestaoEscolar.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public Curso paraEntidade(CursoRequisicaoDto cursoRequisicaoDto){
        return new Curso(
        cursoRequisicaoDto.nome(),
        cursoRequisicaoDto.codigo()
   );
    }

    public CursoRespostaDto paraDto(Curso curso){
        return new CursoRespostaDto(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo()
        );
    }

}

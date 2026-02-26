package com.example.gestaoEscolar.mapper;

import com.example.gestaoEscolar.dto.aluno.AlunoRequisicaoDto;
import com.example.gestaoEscolar.dto.aluno.AlunoRespostaDto;
import com.example.gestaoEscolar.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public Aluno paraEntidade(AlunoRequisicaoDto alunoRequisicaoDto){
    return new Aluno(
            alunoRequisicaoDto.nome(),
            alunoRequisicaoDto.email(),
            alunoRequisicaoDto.matricula(),
            alunoRequisicaoDto.dataNascimento()
    );
    }

    public AlunoRespostaDto paraDto(Aluno aluno){
        return new AlunoRespostaDto(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getDataNascimento()
        );
    }

}

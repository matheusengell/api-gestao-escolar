package com.example.gestaoEscolar.service;

import com.example.gestaoEscolar.dto.aluno.AlunoRequisicaoDto;
import com.example.gestaoEscolar.dto.aluno.AlunoRespostaDto;
import com.example.gestaoEscolar.mapper.AlunoMapper;
import com.example.gestaoEscolar.model.Aluno;
import com.example.gestaoEscolar.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    private AlunoMapper alunoMapper;

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper)throws SQLException{
        this.alunoRepository=alunoRepository;
        this.alunoMapper=alunoMapper;
    }

    public AlunoRespostaDto salvar(AlunoRequisicaoDto alunoRequisicaoDto)throws SQLException{
        Aluno aluno = alunoMapper.paraEntidade(alunoRequisicaoDto);
        alunoRepository.salvar(aluno);
        return alunoMapper.paraDto(aluno);
    }

    public List<AlunoRespostaDto> buscarTodos()throws SQLException{
        List<Aluno> alunos = alunoRepository.buscarTodos();
        List<AlunoRespostaDto> alunoRespostaDtos = new ArrayList<>();
        for (Aluno a: alunos){
            alunoRespostaDtos.add(alunoMapper.paraDto(a));
        }
        return alunoRespostaDtos;
    }

    public AlunoRespostaDto buscarPorId(long id)throws SQLException{
        Aluno aluno = alunoRepository.buscarPorId(id);
        return alunoMapper.paraDto(aluno);
    }

    public AlunoRespostaDto atualizar(AlunoRequisicaoDto alunoRequisicaoDto , long id)throws SQLException{
        Aluno aluno = alunoMapper.paraEntidade(alunoRequisicaoDto);
        alunoRepository.atualizar(aluno, id);
        return alunoMapper.paraDto(aluno);
    }

    public void deletar(long id)throws SQLException{
        alunoRepository.deletar(id);
    }

}

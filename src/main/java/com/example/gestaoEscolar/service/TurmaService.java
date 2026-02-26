package com.example.gestaoEscolar.service;

import com.example.gestaoEscolar.dto.turma.TurmaRequisicaoDto;
import com.example.gestaoEscolar.dto.turma.TurmaRespostaDto;
import com.example.gestaoEscolar.mapper.TurmaMapper;
import com.example.gestaoEscolar.model.Turma;
import com.example.gestaoEscolar.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    private TurmaMapper turmaMapper;
    private TurmaRepository turmaRepository;
    public TurmaService(TurmaRepository turmaRepository, TurmaMapper turmaMapper)throws SQLException{
        this.turmaRepository=turmaRepository;
        this.turmaMapper = turmaMapper;
    }

    public TurmaRespostaDto salvar(TurmaRequisicaoDto turmaRequisicaoDto)throws SQLException{
        Turma turma = turmaMapper.paraEntidade(turmaRequisicaoDto);
        turmaRepository.salvar(turma);
        return turmaMapper.paraDto(turma);
    }

    public List<TurmaRespostaDto> listarTodos()throws SQLException{
        List<Turma> turmas = turmaRepository.listarTodas();
        List<TurmaRespostaDto> respostaDtos = new ArrayList<>();
        for (Turma t: turmas){
            respostaDtos.add(turmaMapper.paraDto(t));
        }
        return respostaDtos;
    }

    public TurmaRespostaDto listarPorId(long id)throws SQLException{
        Turma turma = turmaRepository.listarPorId(id);
        return turmaMapper.paraDto(turma);
    }

    public TurmaRespostaDto atualizar(TurmaRequisicaoDto turmaRequisicaoDto, long id)throws SQLException{
        Turma turma = turmaMapper.paraEntidade(turmaRequisicaoDto);
        turmaRepository.atualizar(turma, id);
        return turmaMapper.paraDto(turma);
    }

    public void deletar(long id)throws SQLException{
        turmaRepository.deletar(id);
    }
}


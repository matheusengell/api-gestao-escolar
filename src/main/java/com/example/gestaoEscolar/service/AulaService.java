package com.example.gestaoEscolar.service;

import com.example.gestaoEscolar.dto.aula.AulaRequisicaoDto;
import com.example.gestaoEscolar.dto.aula.AulaRespostaDto;
import com.example.gestaoEscolar.mapper.AulaMapper;
import com.example.gestaoEscolar.model.Aula;
import com.example.gestaoEscolar.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AulaService {


    private AulaMapper aulaMapper;

    private AulaRepository aulaRepository;

    public AulaService(AulaRepository aulaRepository, AulaMapper aulaMapper)throws SQLException{
        this.aulaRepository=aulaRepository;
        this.aulaMapper=aulaMapper;
    }

    public AulaRespostaDto salvar (AulaRequisicaoDto aulaRequisicaoDto)throws SQLException{
        Aula aula = aulaMapper.paraEntidade(aulaRequisicaoDto);
        aulaRepository.salvar(aula);
        return aulaMapper.paraDto(aula);
    }

    public List<AulaRespostaDto> listarTodas()throws SQLException{
        List<Aula> aulas = aulaRepository.listarTodas();
        List<AulaRespostaDto> aulaRespostaDtos = new ArrayList<>();
        for (Aula a: aulas){
            aulaRespostaDtos.add(aulaMapper.paraDto(a));
        }
        return aulaRespostaDtos;
    }

    public AulaRespostaDto listarPorId(long id)throws SQLException{
        Aula aula = aulaRepository.buscarPorId(id);
        return aulaMapper.paraDto(aula);
    }

    public AulaRespostaDto atualizar(AulaRequisicaoDto aulaRequisicaoDto, long id)throws SQLException{
        Aula aula = aulaMapper.paraEntidade(aulaRequisicaoDto);
        aulaRepository.atualizar(aula, id);
        return aulaMapper.paraDto(aula);
    }

    public void deletar(long id)throws SQLException{
        aulaRepository.deletar(id);
    }
}

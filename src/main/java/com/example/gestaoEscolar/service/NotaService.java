package com.example.gestaoEscolar.service;

import com.example.gestaoEscolar.dto.nota.NotaRequisicaoDto;
import com.example.gestaoEscolar.dto.nota.NotaRespostaDto;
import com.example.gestaoEscolar.mapper.NotaMapper;
import com.example.gestaoEscolar.model.Nota;
import com.example.gestaoEscolar.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotaService {

    private NotaMapper notaMapper;

    private NotaRepository notaRepository;

    public NotaService (NotaRepository notaRepository, NotaMapper notaMapper)throws SQLException{
        this.notaRepository=notaRepository;
        this.notaMapper=notaMapper;
    }

    public NotaRespostaDto salvar(NotaRequisicaoDto notaRequisicaoDto)throws SQLException{
        Nota nota = notaMapper.paraEntidade(notaRequisicaoDto);
        notaRepository.salvar(nota);
        return notaMapper.paraDto(nota);
    }

    public List<NotaRespostaDto> listarTodas()throws SQLException{
        List<Nota> notas = notaRepository.listarTodas();
        List<NotaRespostaDto> notaRespostaDtos = new ArrayList<>();
        for (Nota n: notas){
            notaRespostaDtos.add(notaMapper.paraDto(n));
        }
        return notaRespostaDtos;
    }

    public NotaRespostaDto listarPorId(long id)throws SQLException{
        Nota nota = notaRepository.buscarPorId(id);
        return notaMapper.paraDto(nota);
    }

    public NotaRespostaDto atualizar(NotaRequisicaoDto notaRequisicaoDto, long id)throws SQLException{
        Nota nota = notaMapper.paraEntidade(notaRequisicaoDto);
        notaRepository.atualizar(nota, id);
        return notaMapper.paraDto(nota);
    }

    public void deletar(long id)throws SQLException{
        notaRepository.deletar(id);
    }

}

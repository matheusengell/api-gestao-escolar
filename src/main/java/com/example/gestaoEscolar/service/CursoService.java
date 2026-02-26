package com.example.gestaoEscolar.service;

import com.example.gestaoEscolar.dto.curso.CursoRequisicaoDto;
import com.example.gestaoEscolar.dto.curso.CursoRespostaDto;
import com.example.gestaoEscolar.mapper.CursoMapper;
import com.example.gestaoEscolar.model.Curso;
import com.example.gestaoEscolar.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    private CursoMapper cursoMapper;

    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper)throws SQLException {
        this.cursoRepository=cursoRepository;
        this.cursoMapper=cursoMapper;
    }

    public CursoRespostaDto salvar(CursoRequisicaoDto cursoRequisicaoDto)throws SQLException{
        Curso curso = cursoMapper.paraEntidade(cursoRequisicaoDto);
        cursoRepository.salvar(curso);
        return cursoMapper.paraDto(curso);
    }

    public List<CursoRespostaDto> listarTodos()throws SQLException{
        List<Curso> cursos = cursoRepository.listarTodas();
        List<CursoRespostaDto> cursoRespostaDtos = new ArrayList<>();
        for (Curso c: cursos){
            cursoRespostaDtos.add(cursoMapper.paraDto(c));
        }
        return cursoRespostaDtos;
    }

    public CursoRespostaDto listarPorId(long id)throws SQLException{
        Curso curso = cursoRepository.buscarPorId(id);
        return cursoMapper.paraDto(curso);
    }

    public CursoRespostaDto atualizar(CursoRequisicaoDto cursoRequisicaoDto, long id)throws SQLException{
        Curso curso = cursoMapper.paraEntidade(cursoRequisicaoDto);
        cursoRepository.atualizar(curso, id);
        return cursoMapper.paraDto(curso);
    }

    public void deletar(long id)throws SQLException{
        cursoRepository.deletar(id);
    }

}

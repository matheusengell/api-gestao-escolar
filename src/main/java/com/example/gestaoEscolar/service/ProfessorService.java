package com.example.gestaoEscolar.service;

import com.example.gestaoEscolar.dto.professor.ProfessorRequisicaoDto;
import com.example.gestaoEscolar.dto.professor.ProfessorRespostaDto;
import com.example.gestaoEscolar.mapper.ProfessorMapper;
import com.example.gestaoEscolar.model.Professor;
import com.example.gestaoEscolar.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    private ProfessorMapper professorMapper;

    private ProfessorRepository professorRepository;

    public ProfessorService (ProfessorRepository professorRepository, ProfessorMapper professorMapper)throws SQLException{
        this.professorRepository=professorRepository;
        this.professorMapper=professorMapper;
    }

    public ProfessorRespostaDto salvar(ProfessorRequisicaoDto professorRequisicaoDto)throws SQLException{
        Professor professor = professorMapper.paraEntidade(professorRequisicaoDto);
        professorRepository.salvar(professor);
        return professorMapper.paraDto(professor);
    }

    public List<ProfessorRespostaDto> listarTodos()throws SQLException{
        List<Professor> professores = professorRepository.listarTodas();
        List<ProfessorRespostaDto> professorRespostaDtos = new ArrayList<>();
        for (Professor p: professores){
            professorRespostaDtos.add(professorMapper.paraDto(p));
        }
        return professorRespostaDtos;
    }

    public ProfessorRespostaDto listarPorId(long id)throws SQLException{
        Professor professor = professorRepository.buscarPorId(id);
        return professorMapper.paraDto(professor);
    }

    public ProfessorRespostaDto atualizar(ProfessorRequisicaoDto professorRequisicaoDto, long id)throws SQLException{
        Professor professor = professorMapper.paraEntidade(professorRequisicaoDto);
        professorRepository.atualizar(professor, id);
        return professorMapper.paraDto(professor);
    }

    public void deletar(long id)throws SQLException{
        professorRepository.deletar(id);
    }

}

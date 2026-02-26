package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.professor.ProfessorRequisicaoDto;
import com.example.gestaoEscolar.dto.professor.ProfessorRespostaDto;
import com.example.gestaoEscolar.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping ("/gestaoProfessor")
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController (ProfessorService professorService)throws SQLException{
        this.professorService=professorService;
    }

    @PostMapping
    public ProfessorRespostaDto salvar(
            @RequestBody ProfessorRequisicaoDto professorRequisicaoDto
            ){
        try {
            return professorService.salvar(professorRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<ProfessorRespostaDto> listarTodos(
    ){
        try {
            return professorService.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping ("/{id}")
    public ProfessorRespostaDto listarPorId(
            @PathVariable long id
    ){
        try {
            return professorService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping ("/{id}")
    public ProfessorRespostaDto atualizar(
            @RequestBody ProfessorRequisicaoDto professorRequisicaoDto,
            @PathVariable long id
    ){
        try {
            return professorService.atualizar(professorRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping ("/{id}")
    public void deletar(
            @PathVariable long id
    ){
        try {
            professorService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.curso.CursoRequisicaoDto;
import com.example.gestaoEscolar.dto.curso.CursoRespostaDto;
import com.example.gestaoEscolar.model.Curso;
import com.example.gestaoEscolar.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gestaoCurso")
public class CursoController {


    private CursoService cursoService;

    public CursoController( CursoService cursoService)throws SQLException{
        this.cursoService=cursoService;
    }

    @PostMapping
    public CursoRespostaDto salvar(
            @RequestBody CursoRequisicaoDto cursoRequisicaoDto
            ){
        try {
            return cursoService.salvar(cursoRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<CursoRespostaDto> listarTodos(){
        try {
            return cursoService.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping ("/{id}")
    public CursoRespostaDto listarPorId(
            @PathVariable long id
    ){
        try {
            return cursoService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping ("/{id}")
    public CursoRespostaDto atualizar(
            @RequestBody CursoRequisicaoDto cursoRequisicaoDto,
            @PathVariable long id
    ){
        try {
            return cursoService.atualizar(cursoRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/{id}")
    public void deletar(
            @PathVariable long id
    ){
        try {
            cursoService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

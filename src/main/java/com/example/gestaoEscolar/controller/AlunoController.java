package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.aluno.AlunoRequisicaoDto;
import com.example.gestaoEscolar.dto.aluno.AlunoRespostaDto;
import com.example.gestaoEscolar.model.Aluno;
import com.example.gestaoEscolar.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gestaoAluno")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController (AlunoService alunoService)throws SQLException{
        this.alunoService=alunoService;
    }

    @GetMapping
    public List<AlunoRespostaDto> listarTodos(){
        try {
            return alunoService.buscarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping ("/{id}")
    public AlunoRespostaDto listarPorId(
            @PathVariable long id
    ){
        try {
            return alunoService.buscarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @PostMapping
    public AlunoRespostaDto cadastrarAluno(
            @RequestBody AlunoRequisicaoDto alunoRequisicaoDto
    ){
        try {
            return alunoService.salvar(alunoRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping ("/{id}")
    public AlunoRespostaDto atualizar(
        @RequestBody AlunoRequisicaoDto alunoRequisicaoDto,
        @PathVariable long id
    ){
        try {
            return alunoService.atualizar(alunoRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/{id}")
    public void deletar(
            @PathVariable long id
    ){
        try {
             alunoService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

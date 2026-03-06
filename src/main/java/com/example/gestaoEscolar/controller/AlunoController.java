package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.aluno.AlunoRequisicaoDto;
import com.example.gestaoEscolar.dto.aluno.AlunoRespostaDto;
import com.example.gestaoEscolar.model.Aluno;
import com.example.gestaoEscolar.service.AlunoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gestaoAluno")
@Validated
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
            @PathVariable @Positive(message = "O id deve ser positivo") long id
    ){
        try {
            return alunoService.buscarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @PostMapping
    public AlunoRespostaDto cadastrarAluno(
            @RequestBody @Valid AlunoRequisicaoDto alunoRequisicaoDto
    ){
        try {
            return alunoService.salvar(alunoRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping ("/{id}")
    public AlunoRespostaDto atualizar(
        @RequestBody @Valid AlunoRequisicaoDto alunoRequisicaoDto,
        @PathVariable @Positive(message = "O id deve ser positivo") long id
    ){
        try {
            return alunoService.atualizar(alunoRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/{id}")
    public void deletar(
            @PathVariable @Positive(message = "O id deve ser positivo") long id
    ){
        try {
             alunoService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

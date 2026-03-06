package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.turma.TurmaRequisicaoDto;
import com.example.gestaoEscolar.dto.turma.TurmaRespostaDto;
import com.example.gestaoEscolar.service.TurmaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gestaoTurma")
@Validated
public class TurmaController {

    private TurmaService turmaService;
    public TurmaController(TurmaService turmaService)throws SQLException {
        this.turmaService=turmaService;
    }

    @PostMapping
    public TurmaRespostaDto salvar(
            @RequestBody @Valid TurmaRequisicaoDto turmaRequisicaoDto
            ){
        try {
            return turmaService.salvar(turmaRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<TurmaRespostaDto> listarTodos(
    ){
        try {
            return turmaService.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping ("/{id}")
    public TurmaRespostaDto listarPorId(
            @PathVariable @Positive(message = "O valor deve ser positivo") long id
    ){
        try {
            return turmaService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping ("/{id}")
    public TurmaRespostaDto atualizar(
            @RequestBody @Valid TurmaRequisicaoDto turmaRequisicaoDto,
            @PathVariable @Positive(message = "O valor deve ser positivo") long id
    ){
        try {
            return turmaService.atualizar(turmaRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/{id}")
    public void deletar(
            @PathVariable @Positive(message = "O valor deve ser positivo") long id
    ){
        try {
            turmaService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

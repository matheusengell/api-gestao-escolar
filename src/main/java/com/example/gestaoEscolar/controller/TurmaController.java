package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.turma.TurmaRequisicaoDto;
import com.example.gestaoEscolar.dto.turma.TurmaRespostaDto;
import com.example.gestaoEscolar.service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gestaoTurma")
public class TurmaController {

    private TurmaService turmaService;
    public TurmaController(TurmaService turmaService)throws SQLException {
        this.turmaService=turmaService;
    }

    @PostMapping
    public TurmaRespostaDto salvar(
            @RequestBody TurmaRequisicaoDto turmaRequisicaoDto
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
            @PathVariable long id
    ){
        try {
            return turmaService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping ("/{id}")
    public TurmaRespostaDto atualizar(
            @RequestBody TurmaRequisicaoDto turmaRequisicaoDto,
            @PathVariable long id
    ){
        try {
            return turmaService.atualizar(turmaRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/{id}")
    public void deletar(
            @PathVariable long id
    ){
        try {
            turmaService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

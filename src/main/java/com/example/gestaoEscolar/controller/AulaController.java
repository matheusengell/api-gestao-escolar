package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.aula.AulaRequisicaoDto;
import com.example.gestaoEscolar.dto.aula.AulaRespostaDto;
import com.example.gestaoEscolar.service.AulaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping ("/gestaoAula")
@Validated
public class AulaController {

    private AulaService aulaService;

    public AulaController(AulaService aulaService)throws SQLException{
        this.aulaService=aulaService;
    }

    @PostMapping
    public AulaRespostaDto salvar(
            @RequestBody @Valid AulaRequisicaoDto aulaRequisicaoDto
    ){
        try {
          return aulaService.salvar(aulaRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @GetMapping
    public List<AulaRespostaDto> listarTodas(){
        try {
            return aulaService.listarTodas();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping ("/{id}")
    public AulaRespostaDto listarPorId(
            @PathVariable @Positive(message = "O id deve ser positivo") long id
    ){
        try {
            return aulaService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping ("/{id}")
    public AulaRespostaDto atualizar(
            @RequestBody @Valid AulaRequisicaoDto aulaRequisicaoDto,
            @PathVariable @Positive(message = "O id deve ser positivo") long id
    ){
        try {
            return aulaService.atualizar(aulaRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/{id}")
    public void deletar(
            @PathVariable @Positive(message = "O id deve ser positivo") long id
    ){
        try {
            aulaService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

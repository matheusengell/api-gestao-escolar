package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.nota.NotaRequisicaoDto;
import com.example.gestaoEscolar.dto.nota.NotaRespostaDto;
import com.example.gestaoEscolar.service.NotaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gestaoNota")
@Validated
public class NotaController {

    private NotaService notaService;

    public NotaController (NotaService notaService)throws SQLException{
        this.notaService=notaService;
    }

    @PostMapping
    public NotaRespostaDto salvar(
            @RequestBody @Valid NotaRequisicaoDto notaRequisicaoDto
    ){
        try {
            return notaService.salvar(notaRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<NotaRespostaDto> listarTodas(
    ){
        try {
            return notaService.listarTodas();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping ("/{id}")
    public NotaRespostaDto listarPorId(
            @PathVariable  @Positive(message = "O valor deve ser positivo") long id
    ){
        try {
            return notaService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping ("/{id}")
    public NotaRespostaDto atualizar(
            @RequestBody @Valid NotaRequisicaoDto notaRequisicaoDto,
            @PathVariable  @Positive(message = "O valor deve ser positivo") long id
    ){
        try {
            return notaService.atualizar(notaRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/{id}")
    public void deletar(
            @PathVariable  @Positive(message = "O valor deve ser positivo") long id
    ){
        try {
            notaService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

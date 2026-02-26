package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.nota.NotaRequisicaoDto;
import com.example.gestaoEscolar.dto.nota.NotaRespostaDto;
import com.example.gestaoEscolar.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/gestaoNota")
public class NotaController {

    private NotaService notaService;

    public NotaController (NotaService notaService)throws SQLException{
        this.notaService=notaService;
    }

    @PostMapping
    public NotaRespostaDto salvar(
            @RequestBody NotaRequisicaoDto notaRequisicaoDto
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
            @PathVariable long id
    ){
        try {
            return notaService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping ("/{id}")
    public NotaRespostaDto atualizar(
            @RequestBody NotaRequisicaoDto notaRequisicaoDto,
            @PathVariable long id
    ){
        try {
            return notaService.atualizar(notaRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/{id}")
    public void deletar(
            @PathVariable long id
    ){
        try {
            notaService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

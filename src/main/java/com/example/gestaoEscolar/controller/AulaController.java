package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.aula.AulaRequisicaoDto;
import com.example.gestaoEscolar.dto.aula.AulaRespostaDto;
import com.example.gestaoEscolar.service.AulaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping ("/gestaoAula")
@Validated
@Tag(name = "Aula", description = "Operações de cadastro e consulta de aulas")
public class AulaController {

    private AulaService aulaService;

    public AulaController(AulaService aulaService)throws SQLException{
        this.aulaService=aulaService;
    }

    @Operation(summary = "Cadastrar uma nova aula", description = "Recebe os dados do aula e realiza a persistência no banco de dados.")
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


    @Operation(summary = "Listar todas as aulas", description = "Busca todas as aulas cadastradas no sistema de gestão escolar")
    @GetMapping
    public List<AulaRespostaDto> listarTodas(){
        try {
            return aulaService.listarTodas();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Busca aulas por Id", description = "Retorna os dados de uma aula específica através do seu identificador único(Id).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aula encontrada com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Id inválido, deve ser positivo"),
            @ApiResponse(responseCode = "404", description = "Aula não encontrada")
    })
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


    @Operation(summary = "Atualizar aula existente", description = "Atualiza todas as informações de uma aula com base no ID fornecido.")
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


    @Operation(summary = "Deletar uma aula", description = "Remove o registro da aula do sistema permanentemente.")
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

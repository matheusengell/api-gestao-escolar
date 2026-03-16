package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.nota.NotaRequisicaoDto;
import com.example.gestaoEscolar.dto.nota.NotaRespostaDto;
import com.example.gestaoEscolar.service.NotaService;
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
@RequestMapping("/gestaoNota")
@Validated
@Tag(name = "Notas", description = "Operações de lançamento e consulta de notas dos alunos")
public class NotaController {

    private NotaService notaService;

    public NotaController (NotaService notaService) throws SQLException {
        this.notaService = notaService;
    }

    @Operation(summary = "Lançar nova nota", description = "Registra a nota de um aluno para uma aula ou disciplina específica.")
    @PostMapping
    public NotaRespostaDto salvar(
            @RequestBody @Valid NotaRequisicaoDto notaRequisicaoDto
    ) {
        try {
            return notaService.salvar(notaRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Listar todas as notas", description = "Retorna o histórico completo de notas lançadas no sistema.")
    @GetMapping
    public List<NotaRespostaDto> listarTodas() {
        try {
            return notaService.listarTodas();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Buscar nota por ID", description = "Recupera os detalhes de um lançamento de nota específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nota encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "ID inválido fornecido"),
            @ApiResponse(responseCode = "404", description = "Nota não encontrada")
    })
    @GetMapping("/{id}")
    public NotaRespostaDto listarPorId(
            @PathVariable @Positive(message = "O valor deve ser positivo") long id
    ) {
        try {
            return notaService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Atualizar nota", description = "Permite corrigir o valor de uma nota ou alterar o aluno/aula vinculado.")
    @PutMapping("/{id}")
    public NotaRespostaDto atualizar(
            @RequestBody @Valid NotaRequisicaoDto notaRequisicaoDto,
            @PathVariable @Positive(message = "O valor deve ser positivo") long id
    ) {
        try {
            return notaService.atualizar(notaRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Excluir nota", description = "Remove o registro de uma nota permanentemente do banco de dados.")
    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable @Positive(message = "O valor deve ser positivo") long id
    ) {
        try {
            notaService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
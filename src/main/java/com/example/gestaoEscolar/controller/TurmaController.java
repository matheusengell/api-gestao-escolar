package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.turma.TurmaRequisicaoDto;
import com.example.gestaoEscolar.dto.turma.TurmaRespostaDto;
import com.example.gestaoEscolar.service.TurmaService;
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
@RequestMapping("/gestaoTurma")
@Validated
@Tag(name = "Turmas", description = "Gerenciamento de turmas e enturmação de professores e cursos")
public class TurmaController {

    private TurmaService turmaService;

    public TurmaController(TurmaService turmaService) throws SQLException {
        this.turmaService = turmaService;
    }

    @Operation(summary = "Criar nova turma", description = "Cadastra uma turma vinculando-a a um curso e a um professor responsável.")
    @PostMapping
    public TurmaRespostaDto salvar(@RequestBody @Valid TurmaRequisicaoDto turmaRequisicaoDto) {
        try {
            return turmaService.salvar(turmaRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Listar todas as turmas", description = "Retorna a lista de todas as turmas cadastradas no sistema.")
    @GetMapping
    public List<TurmaRespostaDto> listarTodos() {
        try {
            return turmaService.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Buscar turma por ID", description = "Retorna os detalhes de uma turma específica através do seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turma encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada")
    })
    @GetMapping("/{id}")
    public TurmaRespostaDto listarPorId(@PathVariable @Positive(message = "O valor deve ser positivo") long id) {
        try {
            return turmaService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Atualizar turma", description = "Permite alterar o nome, o curso ou o professor de uma turma existente.")
    @PutMapping("/{id}")
    public TurmaRespostaDto atualizar(
            @RequestBody @Valid TurmaRequisicaoDto turmaRequisicaoDto,
            @PathVariable @Positive(message = "O valor deve ser positivo") long id) {
        try {
            return turmaService.atualizar(turmaRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Deletar turma", description = "Remove permanentemente o registro da turma do sistema.")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable @Positive(message = "O valor deve ser positivo") long id) {
        try {
            turmaService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
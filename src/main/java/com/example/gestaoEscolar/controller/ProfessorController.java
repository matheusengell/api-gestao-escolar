package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.professor.ProfessorRequisicaoDto;
import com.example.gestaoEscolar.dto.professor.ProfessorRespostaDto;
import com.example.gestaoEscolar.service.ProfessorService;
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
@RequestMapping("/gestaoProfessor")
@Validated
@Tag(name = "Professores", description = "Operações de cadastro e gestão do corpo docente")
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController (ProfessorService professorService) throws SQLException {
        this.professorService = professorService;
    }

    @Operation(summary = "Cadastrar professor", description = "Registra um novo professor e sua respectiva disciplina.")
    @PostMapping
    public ProfessorRespostaDto salvar(@RequestBody @Valid ProfessorRequisicaoDto professorRequisicaoDto) {
        try {
            return professorService.salvar(professorRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Listar todos os professores", description = "Retorna a lista completa de professores cadastrados.")
    @GetMapping
    public List<ProfessorRespostaDto> listarTodos() {
        try {
            return professorService.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Buscar professor por ID", description = "Retorna os detalhes de um professor específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor encontrado"),
            @ApiResponse(responseCode = "404", description = "Professor não encontrado")
    })
    @GetMapping("/{id}")
    public ProfessorRespostaDto listarPorId(@PathVariable @Positive(message = "O valor deve ser positivo") long id) {
        try {
            return professorService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Atualizar professor", description = "Altera os dados de um professor já existente.")
    @PutMapping("/{id}")
    public ProfessorRespostaDto atualizar(
            @RequestBody @Valid ProfessorRequisicaoDto professorRequisicaoDto,
            @PathVariable @Positive(message = "O valor deve ser positivo") long id) {
        try {
            return professorService.atualizar(professorRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Deletar professor", description = "Remove um professor do sistema permanentemente.")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable @Positive(message = "O valor deve ser positivo") long id) {
        try {
            professorService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.aluno.AlunoRequisicaoDto;
import com.example.gestaoEscolar.dto.aluno.AlunoRespostaDto;
import com.example.gestaoEscolar.model.Aluno;
import com.example.gestaoEscolar.service.AlunoService;
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
@RequestMapping("/gestaoAluno")
@Validated
@Tag(name = "Alunos", description = "Operações de cadastro e consulta de estudantes")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController (AlunoService alunoService)throws SQLException{
        this.alunoService=alunoService;
    }

    @Operation(summary = "Listar todos os alunos", description = "Busca todos os alunos cadastrados no sistema de gestão escolar")
    @GetMapping
    public List<AlunoRespostaDto> listarTodos(){
        try {
            return alunoService.buscarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Busca alunos por Id", description = "Retorna os dados de um aluno específico através do seu identificador único(Id).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Id inválido, deve ser positivo"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
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

    @Operation(summary = "Cadastrar um novo aluno", description = "Recebe os dados do aluno e realiza a persistência no banco de dados.")
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

    @Operation(summary = "Atualizar aluno existente", description = "Atualiza todas as informações de um aluno com base no ID fornecido.")
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

    @Operation(summary = "Deletar um aluno", description = "Remove o registro do aluno do sistema permanentemente.")
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
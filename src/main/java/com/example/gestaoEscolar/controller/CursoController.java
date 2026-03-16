package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.curso.CursoRequisicaoDto;
import com.example.gestaoEscolar.dto.curso.CursoRespostaDto;
import com.example.gestaoEscolar.model.Curso;
import com.example.gestaoEscolar.service.CursoService;
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
@RequestMapping("/gestaoCurso")
@Validated
@Tag(name = "Curso", description = "Operações de cadastro e consulta de Curso")
public class CursoController {


    private CursoService cursoService;

    public CursoController( CursoService cursoService)throws SQLException{
        this.cursoService=cursoService;
    }

    @Operation(summary = "Cadastrar um novo curso", description = "Cria um novo curso no sistema, como 'Análise e Desenvolvimento de Sistemas'.") @PostMapping
    public CursoRespostaDto salvar(
            @RequestBody @Valid CursoRequisicaoDto cursoRequisicaoDto
            ){
        try {
            return cursoService.salvar(cursoRequisicaoDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Listar todos os cursos", description = "Retorna uma lista de todos os cursos ativos na instituição.")
    @GetMapping
    public List<CursoRespostaDto> listarTodos(){
        try {
            return cursoService.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Buscar curso por ID", description = "Busca os detalhes de um curso específico através do seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    @GetMapping ("/{id}")
    public CursoRespostaDto listarPorId(
            @PathVariable  @Positive(message = "O id deve ser positivo") long id
    ){
        try {
            return cursoService.listarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Atualizar um curso", description = "Altera os dados de um curso existente (ex: mudar o nome do curso).")
    @PutMapping ("/{id}")
    public CursoRespostaDto atualizar(
            @RequestBody @Valid CursoRequisicaoDto cursoRequisicaoDto,
            @PathVariable @Positive(message = "O id deve ser positivo") long id
    ){
        try {
            return cursoService.atualizar(cursoRequisicaoDto, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Remover um curso", description = "Exclui permanentemente um curso do sistema através do ID.")
    @DeleteMapping ("/{id}")
    public void deletar(
            @PathVariable @Positive(message = "O id deve ser positivo")  long id
    ){
        try {
            cursoService.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

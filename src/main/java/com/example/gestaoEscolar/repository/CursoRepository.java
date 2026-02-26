package com.example.gestaoEscolar.repository;

import com.example.gestaoEscolar.model.Curso;
import com.example.gestaoEscolar.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {

    public Curso salvar(Curso curso)throws SQLException {
        String query = """
                INSERT INTO curso
                (nome, codigo)
                VALUES 
                (?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()){
                curso.setId(rs.getLong(1));
            }

        }return curso;
    }

    public List<Curso> listarTodas()throws SQLException{
        List<Curso> cursos = new ArrayList<>();
        String query= """
                SELECT id, nome, codigo
                FROM curso
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                cursos.add(new Curso(id, nome, codigo));
            }
        }
        return cursos;
    }


    public Curso buscarPorId(long id)throws SQLException {
        String query = """
                SELECT id,nome, codigo
                FROM curso
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Curso(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("codigo")
                );}
        }
        return null;
    }

    public Curso atualizar(Curso curso, long id)throws SQLException{
        String query = """
                UPDATE curso
                SET nome =?, codigo =?
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.setLong(3, id);
            stmt.executeUpdate();
        }
        return curso;
    }

    public void deletar(long id)throws SQLException{
        String query = """
                DELETE FROM curso
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}

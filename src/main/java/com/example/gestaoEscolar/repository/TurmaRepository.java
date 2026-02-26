package com.example.gestaoEscolar.repository;

import com.example.gestaoEscolar.model.Turma;
import com.example.gestaoEscolar.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TurmaRepository {

    public Turma salvar(Turma turma)throws SQLException{
        String query = """
                INSERT INTO turma
                (nome, curso_id, professor_id)
                VALUES
                (?,?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, turma.getNome());
            stmt.setLong(2, turma.getCurso_id());
            stmt.setLong(3, turma.getProfessor_id());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()){
                turma.setId(rs.getLong(1));
            }
        }
        return turma;
    }

    public List<Turma> listarTodas()throws SQLException{
        List<Turma> turmas = new ArrayList<>();
        String query = """
                SELECT id, nome, curso_id, professor_id
                FROM turma
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                long curso_id = rs.getLong("curso_id");
                long professor_id = rs.getLong("professor_id");
                turmas.add(new Turma(id, nome,curso_id,professor_id));
            }
        }
        return turmas;
    }

    public Turma listarPorId(long id) throws SQLException{
        String query = """
                SELECT id, nome, curso_id, professor_id
                FROM turma
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                return new Turma(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getLong("curso_id"),
                        rs.getLong("professor_id")
                );
            }
        }
        return null;
    }

    public Turma atualizar(Turma turma, long id)throws SQLException{
        String query = """
                UPDATE turma
                SET nome =?, curso_id=?, professor_id =?
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, turma.getNome());
            stmt.setLong(2,turma.getCurso_id());
            stmt.setLong(3,turma.getProfessor_id());
            stmt.setLong(4, id);
            stmt.executeUpdate();
        }
        return turma;
    }


    public void deletar(long id)throws SQLException{
        String query = """
                DELETE FROM turma
                WHERE id =?
                """;
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}

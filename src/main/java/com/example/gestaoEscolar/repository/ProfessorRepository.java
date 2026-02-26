package com.example.gestaoEscolar.repository;

import com.example.gestaoEscolar.model.Professor;
import com.example.gestaoEscolar.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepository {

    public Professor salvar(Professor professor)throws SQLException {
        String query = """
                INSERT INTO professor
                (nome, email, disciplina)
                VALUES 
                (?,?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()){
                professor.setId(rs.getLong(1));
            }

        }return professor;
    }

    public List<Professor> listarTodas()throws SQLException{
        List<Professor> professors = new ArrayList<>();
        String query= """
                SELECT id, nome, email, disciplina
                FROM professor
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String disciplina = rs.getString("disciplina");
                professors.add(new Professor(id,nome, email, disciplina));
            }
        }
        return professors;
    }


    public Professor buscarPorId(long id)throws SQLException {
        String query = """
                SELECT id, nome, email, disciplina
                FROM professor
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Professor(
                        rs.getLong("id"),
                       rs.getString("nome"),
                       rs.getString("email"),
                       rs.getString("disciplina")
                );}
        }
        return null;
    }

    public Professor atualizar(Professor professor, long id)throws SQLException{
        String query = """
                UPDATE professor
                SET nome =? , email=?, disciplina=?
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.setLong(4, id);
            stmt.executeUpdate();
        }
        return professor;
    }

    public void deletar(long id)throws SQLException{
        String query = """
                DELETE FROM professor
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}

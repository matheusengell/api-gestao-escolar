package com.example.gestaoEscolar.repository;

import com.example.gestaoEscolar.model.Aluno;
import com.example.gestaoEscolar.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepository {


    public Aluno salvar(Aluno aluno) throws SQLException {
        String query = """
            INSERT INTO aluno
            (nome, email, matricula, data_nascimento)
            VALUES
            (?,?,?, ?)
            """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, Date.valueOf(aluno.getDataNascimento()));

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                aluno.setId(rs.getLong(1));
            }
        }
        return aluno;
    }

    public List<Aluno> buscarTodos()throws SQLException{
        List<Aluno> alunos = new ArrayList<>();

        String query = """
                SELECT id, nome, email, matricula, data_nascimento
                FROM aluno
                """;
        try (Connection conn = Conexao.conectar();){
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String matricula = rs.getString("matricula");
                LocalDate dataNascimento = rs.getDate("data_nascimento").toLocalDate();

                alunos.add(new Aluno(id, nome, email, matricula, dataNascimento));
            }
        }
        return alunos;
    }

    public Aluno buscarPorId(long id)throws SQLException {
        String query = """
                SELECT id, nome, email, matricula, data_nascimento
                FROM aluno
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Aluno(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("matricula"),
                        rs.getDate("data_nascimento").toLocalDate()

                 );}
        }
        return null;
    }

    public Aluno atualizar(Aluno aluno, long id)throws SQLException{
        String query = """
                UPDATE aluno
                SET nome = ?, email= ?, matricula= ?, data_nascimento= ?
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, Date.valueOf(aluno.getDataNascimento()));
            stmt.setLong(5, id);
            stmt.executeUpdate();

        }
        return aluno;
    }

    public void deletar(long id)throws SQLException{
        String query = """
                DELETE FROM aluno
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }



}

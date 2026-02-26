package com.example.gestaoEscolar.repository;

import com.example.gestaoEscolar.model.Aluno;
import com.example.gestaoEscolar.model.Aula;
import com.example.gestaoEscolar.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class AulaRepository {

    public Aula salvar(Aula aula)throws SQLException{
        String query = """
                INSERT INTO aula
                (turma_id, data_hora, assunto)
                VALUES 
                (?,?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setLong(1, aula.getTurma_id());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(aula.getData_hora()));
            stmt.setString(3, aula.getAssunto());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()){
                aula.setId(rs.getLong(1));
            }

        }return aula;
    }

    public List<Aula> listarTodas()throws SQLException{
        List<Aula> aulas = new ArrayList<>();
        String query= """
                SELECT id, turma_id, data_hora, assunto
                FROM aula
                """;
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                long id = rs.getLong("id");
                long idTurma = rs.getLong("turma_id");
                Timestamp dataHora = rs.getTimestamp("data_hora");
                String assunto = rs.getString("assunto");
                aulas.add(new Aula(id, idTurma, dataHora.toLocalDateTime(), assunto));
            }
        }
        return aulas;
    }


    public Aula buscarPorId(long id)throws SQLException {
        String query = """
                SELECT id, turma_id, data_hora, assunto
                FROM aula
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Aula(
                        rs.getLong("id"),
                        rs.getLong("turma_id"),
                        rs.getTimestamp("data_hora").toLocalDateTime(),
                        rs.getString("assunto")
                );}
        }
        return null;
    }

    public Aula atualizar(Aula aula, long id)throws SQLException{
        String query = """
                UPDATE aula
                SET turma_id =?, data_hora =?, assunto=?
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, aula.getTurma_id());
            stmt.setTimestamp(2, Timestamp.valueOf(aula.getData_hora()));
            stmt.setString(3, aula.getAssunto());
            stmt.setLong(4, id);
            stmt.executeUpdate();
        }
        return aula;
    }

    public void deletar(long id)throws SQLException{
        String query = """
                DELETE FROM aula
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
                stmt.setLong(1, id);
                stmt.executeUpdate();
        }
    }
}

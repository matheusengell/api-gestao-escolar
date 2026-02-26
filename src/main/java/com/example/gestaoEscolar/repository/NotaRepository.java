package com.example.gestaoEscolar.repository;

import com.example.gestaoEscolar.model.Nota;
import com.example.gestaoEscolar.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NotaRepository {

    public Nota salvar(Nota nota)throws SQLException {
        String query = """
                INSERT INTO nota
                (aluno_id, aula_id, valor)
                VALUES 
                (?,?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setLong(1, nota.getAluno_id());
            stmt.setLong(2, nota.getAula_id());
            stmt.setDouble(3, nota.getValor());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()){
                nota.setId(rs.getLong(1));
            }

        }return nota;
    }

    public List<Nota> listarTodas()throws SQLException{
        List<Nota> notas = new ArrayList<>();
        String query= """
                SELECT id, aluno_id, aula_id, valor
                FROM nota
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                long id = rs.getLong("id");
                long aluno_id = rs.getLong("aluno_id");
                long aula_id = rs.getLong("aula_id");
                double valor = rs.getDouble("valor");
                notas.add(new Nota(id, aluno_id, aula_id, valor));
            }
        }
        return notas;
    }


    public Nota buscarPorId(long id)throws SQLException {
        String query = """
                SELECT id, aluno_id, aula_id, valor
                FROM nota
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Nota(
                        rs.getLong("id"),
                        rs.getLong("aluno_id"),
                        rs.getLong("aula_id"),
                        rs.getDouble("valor")
                );}
        }
        return null;
    }

    public Nota atualizar(Nota nota, long id)throws SQLException{
        String query = """
                UPDATE nota
                SET aluno_id = ?, aula_id = ?, valor = ?
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, nota.getAluno_id());
            stmt.setLong(2, nota.getAula_id());
            stmt.setDouble(3, nota.getValor());
            stmt.setLong(4, id);
            stmt.executeUpdate();
        }
        return nota;
    }

    public void deletar(long id)throws SQLException{
        String query = """
                DELETE FROM nota
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

}

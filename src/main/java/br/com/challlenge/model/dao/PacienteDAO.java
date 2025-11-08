package br.com.challlenge.model.dao;

import br.com.challlenge.model.dto.PacienteTO;
import oracle.jdbc.proxy.annotation.Pre;

import java.security.PublicKey;
import java.sql.*;

public class PacienteDAO {
    public PacienteTO save(PacienteTO paciente) {
        String sql = "insert into t_vlt_ddd_paciente (nome, data_nascimento, documento, codigo_endereco, codigo_contato) VALUES (?,?,?,?,?)";
        Long idGerado;

        // new String[]{"codigo"}: Ajuda no retorno do código do paciente.
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql, new String[]{"codigo"})) {
            ps.setString(1, paciente.getNome());
            ps.setDate(2, Date.valueOf(paciente.getDataNascimento()));
            ps.setString(3, paciente.getDocumento());
            ps.setLong(4, paciente.getCodEndereco());
            ps.setLong(5, paciente.getCodContato());

            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // Recebe o código do paciente
                        paciente.setId(rs.getLong(1));
                    }
                }

                return paciente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("\nErro na criação: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return paciente;
    }

    public PacienteTO findByCodigo(Long codigo) {
        PacienteTO paciente = new PacienteTO();
        String sql = "select * from t_vlt_ddd_paciente where codigo=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                paciente.setId(rs.getLong("codigo"));
                paciente.setNome(rs.getString("nome"));
                paciente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                paciente.setDocumento(rs.getString("documento"));
                paciente.setCodEndereco(rs.getLong("codigo_endereco"));
                paciente.setCodContato(rs.getLong("codigo_contato"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("\nErro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return paciente;
    }

    public PacienteTO update(PacienteTO paciente) {
        String sql = "update t_vlt_ddd_paciente set nome=?, data_nascimento=?, documento=?, codigo_endereco=?, codigo_contato=? where codigo=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, paciente.getNome());
            ps.setDate(2, Date.valueOf(paciente.getDataNascimento()));
            ps.setString(3, paciente.getDocumento());
            ps.setLong(4, paciente.getCodEndereco());
            ps.setLong(5, paciente.getCodContato());
            ps.setLong(6, paciente.getId());

            if (ps.executeUpdate() > 0) {
                return paciente;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return null;
    }

    public boolean delete(Long codigo) {
        String sql = "delete from t_vlt_ddd_paciente where codigo=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return false;
    }
}

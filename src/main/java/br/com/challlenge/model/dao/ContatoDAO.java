package br.com.challlenge.model.dao;

import br.com.challlenge.model.dto.ContatoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContatoDAO {
    public ArrayList<ContatoTO> findAll() {
        ArrayList<ContatoTO> contatos = new ArrayList<>();

        String sql = "select * from t_vlt_ddd_contato order by codigo";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ContatoTO contato = new ContatoTO();
                    contato.setId(rs.getLong("codigo"));
                    contato.setEmail(rs.getString("email"));
                    contato.setTelefone(rs.getString("telefone"));
                    contatos.add(contato);
                }

                return contatos;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return contatos;
    }
    
    public ContatoTO save(ContatoTO contato) {
        String sql = "insert into t_vlt_ddd_contato (email, telefone) VALUES (?,?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql, new String[]{"codigo"})) {
            ps.setString(1, contato.getEmail());
            ps.setString(2, contato.getTelefone());

            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        contato.setId(rs.getLong(1));
                    }
                }

                return contato;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("\nErro na criação: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return null;
    }

    public ContatoTO findByCode(Long codigo) {
        ContatoTO contato = new ContatoTO();
        String sql = "select * from t_vlt_ddd_contato where codigo=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                contato.setId(rs.getLong("codigo"));
                contato.setEmail(rs.getString("email"));
                contato.setTelefone(rs.getString("telefone"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("\nErro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return contato;
    }

    public ContatoTO update(ContatoTO contato) {
        String sql = "update t_vlt_ddd_contato set email=?, telefone=? where codigo=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, contato.getEmail());
            ps.setString(2, contato.getTelefone());
            ps.setLong(3, contato.getId());

            if (ps.executeUpdate() > 0) {
                return contato;
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
}

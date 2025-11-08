package br.com.challlenge.model.bo;

import br.com.challlenge.model.dao.PacienteDAO;
import br.com.challlenge.model.dto.PacienteTO;
import oracle.sql.LobPlsqlUtil;

public class PacienteBO {
    private PacienteDAO pacienteDAO;

    public PacienteTO save(PacienteTO paciente) {
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.save(paciente);
    }

    public PacienteTO findByCode(Long codigo) {
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.findByCodigo(codigo);
    }

    public PacienteTO update(PacienteTO paciente) {
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.update(paciente);
    }

    public boolean delete(Long codigo) {
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.delete(codigo);
    }
}

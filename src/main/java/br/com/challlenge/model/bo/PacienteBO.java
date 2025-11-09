package br.com.challlenge.model.bo;

import br.com.challlenge.model.dao.PacienteDAO;
import br.com.challlenge.model.dto.PacienteTO;

import java.util.ArrayList;

public class PacienteBO {
    private PacienteDAO pacienteDAO;

    public ArrayList<PacienteTO> findAll() {
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.findAll();
    }

    public PacienteTO save(PacienteTO paciente) {
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.save(paciente);
    }

    public PacienteTO findByCode(Long codigo) {
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.findByCode(codigo);
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

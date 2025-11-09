package br.com.challlenge.model.bo;

import br.com.challlenge.model.dao.EnderecoDAO;
import br.com.challlenge.model.dto.EnderecoTO;

import java.util.ArrayList;

public class EnderecoBO {
    private EnderecoDAO enderecoDAO;

    public ArrayList<EnderecoTO> findAll() {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.findAll();
    }

    public EnderecoTO save(EnderecoTO endereco) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.save(endereco);
    }

    public EnderecoTO findByCode(Long codigo) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.findByCode(codigo);
    }

    public EnderecoTO update(EnderecoTO endereco) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.update(endereco);
    }
}

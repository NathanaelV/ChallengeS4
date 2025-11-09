package br.com.challlenge.model.bo;

import br.com.challlenge.model.dao.EnderecoDAO;
import br.com.challlenge.model.dto.EnderecoTO;

public class EnderecoBO {
    private EnderecoDAO enderecoDAO;

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

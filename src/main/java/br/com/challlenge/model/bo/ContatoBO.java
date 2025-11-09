package br.com.challlenge.model.bo;

import br.com.challlenge.model.dao.ContatoDAO;
import br.com.challlenge.model.dto.ContatoTO;

public class ContatoBO {
    private ContatoDAO contatoDAO;

    public ContatoTO save(ContatoTO contato) {
        contatoDAO = new ContatoDAO();
        return contatoDAO.save(contato);
    }

    public ContatoTO findByCode(Long codigo) {
        contatoDAO = new ContatoDAO();
        return contatoDAO.findByCode(codigo);
    }

    public ContatoTO update(ContatoTO contato) {
        contatoDAO = new ContatoDAO();
        return contatoDAO.update(contato);
    }
    
}

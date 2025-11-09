package br.com.challlenge.model.bo;

import br.com.challlenge.model.dao.ContatoDAO;
import br.com.challlenge.model.dto.ContatoTO;

import java.util.ArrayList;

public class ContatoBO {
    private ContatoDAO contatoDAO;

    public ArrayList<ContatoTO> findAll() {
        contatoDAO = new ContatoDAO();
        return contatoDAO.findAll();
    }

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

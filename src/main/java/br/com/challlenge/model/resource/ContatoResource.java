package br.com.challlenge.model.resource;

import br.com.challlenge.model.bo.ContatoBO;
import br.com.challlenge.model.dto.ContatoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/contato")
public class ContatoResource {
    private ContatoBO contatoBO = new ContatoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ContatoTO> resultado = contatoBO.findAll();
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }

        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ContatoTO contato) {
        ContatoTO resultado = contatoBO.save(contato);
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.created(null);  // 201 (CREATED)
        } else {
            response = Response.status(400);            // 400 (BAD REQUEST)
        }

        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("codigo") Long codigo) {
        ContatoTO resultado = contatoBO.findByCode(codigo);
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.ok();           // 200 (OK)
        } else {
            response = Response.status(404);    // 404 (NOT FOUND)
        }

        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ContatoTO contato, @PathParam("codigo") Long codigo) {
        contato.setId(codigo);
        ContatoTO resultado = contatoBO.update(contato);
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.created(null);  // 201 (CREATED)
        } else {
            response = Response.status(400);            // 400 (BAD REQUEST)
        }

        response.entity(resultado);
        return response.build();
    }
}

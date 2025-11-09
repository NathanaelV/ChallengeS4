package br.com.challlenge.model.resource;

import br.com.challlenge.model.bo.EnderecoBO;
import br.com.challlenge.model.dto.EnderecoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/endereco")
public class EnderecoResource {
    private EnderecoBO enderecoBO = new EnderecoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<EnderecoTO> resultado = enderecoBO.findAll();
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
    public Response save(@Valid EnderecoTO endereco) {
        EnderecoTO resultado = enderecoBO.save(endereco);
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
        EnderecoTO resultado = enderecoBO.findByCode(codigo);
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
    public Response update(@Valid EnderecoTO endereco, @PathParam("codigo") Long codigo){
        endereco.setId(codigo);
        EnderecoTO resultado = enderecoBO.update(endereco);
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

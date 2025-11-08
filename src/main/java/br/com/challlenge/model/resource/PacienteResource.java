package br.com.challlenge.model.resource;

import br.com.challlenge.model.bo.PacienteBO;
import br.com.challlenge.model.dto.PacienteTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/paciente")
public class PacienteResource {
    private PacienteBO pacienteBO = new PacienteBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid PacienteTO paciente) {
        PacienteTO resultado = pacienteBO.save(paciente);
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
        PacienteTO resultado = pacienteBO.findByCode(codigo);
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
    public Response update(@Valid PacienteTO paciente, @PathParam("codigo") Long codigo) {
        paciente.setId(codigo);
        PacienteTO resultado = pacienteBO.update(paciente);
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.created(null);  // 201 (CREATED)
        } else {
            response = Response.status(400);
        }

        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{codigo}")
    public Response delete(@PathParam("codigo") Long codigo) {
        Response.ResponseBuilder response;

        if (pacienteBO.delete(codigo)) {
            response = Response.status(204);    // 204 (NOT CONTENT)
        } else {
            response = Response.status(404);    // 404 (NOT FOUND)
        }

        return response.build();
    }

}

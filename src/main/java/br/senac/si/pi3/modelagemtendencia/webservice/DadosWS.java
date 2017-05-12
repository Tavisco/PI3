package br.senac.si.pi3.modelagemtendencia.webservice;

import br.senac.si.pi3.modelagemtendencia.dto.ResultTableDTO;
import br.senac.si.pi3.modelagemtendencia.service.InterpolarService;
import br.senac.si.pi3.modelagemtendencia.service.impl.InterpolarServiceImpl;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("tendencia")
public class DadosWS {

    @Context
    private UriInfo context;

    private final InterpolarService interpolarService;

    public DadosWS() {
        this.interpolarService = new InterpolarServiceImpl();
    }

    @Path("json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResultTableDTO> getJson() {
        Date a = null, b = null;

        return interpolarService.verificarEstadoNoPeriodo(a, b);
    }

}

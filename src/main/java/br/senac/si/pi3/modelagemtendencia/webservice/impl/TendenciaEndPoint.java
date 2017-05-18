package br.senac.si.pi3.modelagemtendencia.webservice.impl;

import br.senac.si.pi3.modelagemtendencia.dto.AcoesDTO;
import br.senac.si.pi3.modelagemtendencia.factory.EMFactory;
import br.senac.si.pi3.modelagemtendencia.service.InterpolarService;
import br.senac.si.pi3.modelagemtendencia.service.impl.InterpolarServiceImpl;
import br.senac.si.pi3.modelagemtendencia.webservice.TendenciaWebService;
import java.text.ParseException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("tendencia")
public class TendenciaEndPoint implements TendenciaWebService{


    @Context
    private UriInfo context;

    private final EntityManager em;
    private final InterpolarService interpolarService;

    public TendenciaEndPoint() {
        this.em = new EMFactory().getEntityManager();
        this.interpolarService = new InterpolarServiceImpl();
    }

    @GET
    @Path("{dataI}/{dataF}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcoesDTO> getJson(@PathParam("dataI") String dataI, @PathParam("dataF") String dataF) throws ParseException {
        try {
            return interpolarService.verificarEstadoNoPeriodo(dataI, dataF);
        } catch (ParseException e) {
            System.out.println("PARSE EX");
            throw new WebApplicationException(500);
        }
    }
}

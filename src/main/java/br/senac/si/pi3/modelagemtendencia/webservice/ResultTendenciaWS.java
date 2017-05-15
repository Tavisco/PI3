package br.senac.si.pi3.modelagemtendencia.webservice;

import br.senac.si.pi3.modelagemtendencia.dto.AcoesDTO;
import br.senac.si.pi3.modelagemtendencia.factory.EMFactory;
import br.senac.si.pi3.modelagemtendencia.service.InterpolarService;
import br.senac.si.pi3.modelagemtendencia.service.impl.InterpolarServiceImpl;
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
public class ResultTendenciaWS {

    EntityManager em = new EMFactory().getEntityManager();

    @Context
    private UriInfo context;

    private final InterpolarService interpolarService;

    public ResultTendenciaWS() {

        this.interpolarService = new InterpolarServiceImpl();
    }

    @GET
    @Path("{dataI}/{dataF}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcoesDTO> getJson(@PathParam("dataI") String dataI, @PathParam("dataI") String dataF) throws ParseException {
        try {
            return interpolarService.verificarEstadoNoPeriodo(dataI, dataF);
        }catch(ParseException e){
            throw new WebApplicationException(500);

        }
    }

}

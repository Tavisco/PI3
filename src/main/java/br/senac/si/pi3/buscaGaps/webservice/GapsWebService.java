package br.senac.si.pi3.buscaGaps.webservice;

import br.senac.si.pi3.buscaGaps.dto.GapsAcoesDTO;
import br.senac.si.pi3.buscaGaps.service.AnalisarGapsService;
import br.senac.si.pi3.buscaGaps.service.impl.AnalisarGapsServiceImpl;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Gustavo
 */
@Path("gaps")
@RequestScoped
public class GapsWebService {
    
    private final AnalisarGapsService servico;
    
    public GapsWebService() {
        this.servico = new AnalisarGapsServiceImpl();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{dataI}/{dataF}/json")
    public List<GapsAcoesDTO> getJson(@PathParam("dataI") String dataI, @PathParam("dataF") String dataF){
        try {
            return this.servico.analisaGaps(dataI, dataF);
        } catch (ParseException e) {
            System.out.println("PARSE EX");
            throw new WebApplicationException(500);
        }
    }
    
    
}

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

@Path("gaps")
@RequestScoped
public class GapsWebService {
    
    private final AnalisarGapsService servico;
    
    public GapsWebService() {
        this.servico = new AnalisarGapsServiceImpl();
    }
    
    @GET
    @Path("{dataInicial}/{dataFinal}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GapsAcoesDTO> getJson(@PathParam("dataInicial") String dataInicial, @PathParam("dataFinal") String dataFinal){
        try {
            return this.servico.analisaGaps(dataInicial, dataFinal);
        } catch (ParseException e) {
            System.out.println("PARSE EX");
            throw new WebApplicationException(500);
        }
    }
    
    
}

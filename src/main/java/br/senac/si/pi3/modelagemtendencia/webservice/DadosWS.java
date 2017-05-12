package br.senac.si.pi3.modelagemtendencia.webservice;

import br.senac.si.pi3.modelagemtendencia.Enum.TendenciaEnum;
import br.senac.si.pi3.modelagemtendencia.dto.ResultTableDTO;
import br.senac.si.pi3.modelagemtendencia.factory.EMFactory;
import br.senac.si.pi3.modelagemtendencia.service.InterpolarService;
import br.senac.si.pi3.modelagemtendencia.service.impl.InterpolarServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("tendencia")
public class DadosWS {
    EntityManager em = new EMFactory().getEntityManager();
    
    @Context
    private UriInfo context;

    private final InterpolarService interpolarService;
    private final SimpleDateFormat sdf;
    
    public DadosWS() {
        this.sdf= new SimpleDateFormat("yyyy/dd/MM");
        this.interpolarService = new InterpolarServiceImpl();
    }

    @Path("json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResultTableDTO> getJson() throws ParseException {
        Date a = sdf.parse("2017/04/01"), b = sdf.parse("2017/04/30");

        return interpolarService.verificarEstadoNoPeriodo(a, b);
    }
    
}

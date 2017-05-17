package br.senac.si.pi3.modelagemtendencia.webservice;

import br.senac.si.pi3.modelagemtendencia.dto.AcoesDTO;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.PathParam;

public interface TendenciaWebService {
  
    List<AcoesDTO> getJson(@PathParam("dataI") String dataI, @PathParam("dataI") String dataF) throws ParseException;
}

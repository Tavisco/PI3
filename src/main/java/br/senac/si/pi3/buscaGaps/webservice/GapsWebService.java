/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.si.pi3.buscaGaps.webservice;

import br.senac.si.pi3.buscaGaps.dto.GapsAcoesDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Gustavo
 */
@Path("gaps")//esse é o caminho pra colocar na url pra chegar no seu webservice
@RequestScoped//esse é o escopo, precisa entender isso agora nao
public class GapsWebService {

    @Context
    private UriInfo context; // nem isso, isso nem eu sei direito kkk

    
    public GapsWebService() {
    }

    //talves agnt não use esse Consumes, pra fica mais simples vamo passa tudo por URL
//    @Consumes(MediaType.APPLICATION_JSON)// isso quer dizer que vai RECEBER um Json
    @Path("json")
    @GET//aqui é os metodos web, depois olha na net mas vamos usar esse, que agnt passa os dados pela URL mesmo
    @Produces(MediaType.APPLICATION_JSON)//isso quer dizer que vamos ENVIAR um Json
    public GapsAcoesDTO getJson() throws ParseException {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
        GapsAcoesDTO d = new GapsAcoesDTO();
        d.setNomeAcao("petroba");
        d.setCodigoAcao("perbaneles");
        d.setData(sdf.parse("24/05/2017"));
        d.setGap(true);
        return d;
    }

    //agt nao ia usar aquele metodo 
}

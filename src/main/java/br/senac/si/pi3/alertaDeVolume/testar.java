/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.si.pi3.alertaDeVolume;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author stephany.salves
 */
@Path("AlertaDeVolume")
public class testar {
    
    
    @GET
    @Path("grafico")
    @Produces(MediaType.APPLICATION_JSON)
    public void teste() {
    }
}

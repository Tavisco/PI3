/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.si.pi3.alertaDeVolume.dto;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import yahoofinance.Stock;

/**
 *
 * @author stephany.salves
 */
@Path("alertaVolume")
public class alertaVol {

    @POST
    @Path("enviar")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String enviar(@FormParam("data") String _periodo) throws IOException, ParseException {
        String[] datas = _periodo.split("-");

        datas[0] = datas[0].replace(" ", "");
        datas[1] = datas[1].replace(" ", "");

        Calendar dataDe = Calendar.getInstance();
        Calendar dataAte = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        try {
            dataDe.setTime(df.parse(datas[0]));
            dataAte.setTime(df.parse(datas[1]));
        } catch (Exception e) {
            return "false";

        }
        
        System.out.println("Deu certo!");
        
        return "true";
    }

}

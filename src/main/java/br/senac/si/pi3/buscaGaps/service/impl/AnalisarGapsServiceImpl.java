/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.si.pi3.buscaGaps.service.impl;

import br.senac.si.pi3.buscaGaps.dto.GapsAcoesDTO;
import br.senac.si.pi3.buscaGaps.service.AnalisarGapsService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class AnalisarGapsServiceImpl implements AnalisarGapsService{
    
    //quem chama isso é o web service 
    public List<GapsAcoesDTO> AnalisaGaps(Date dataI, Date dataF) {
        //aqui vai logica de calculo dos gaps
        //aqui entra a população da Lista de DTO depois de calcular 
        //esse retorno vai pro web service
        return null;
    }
    
}

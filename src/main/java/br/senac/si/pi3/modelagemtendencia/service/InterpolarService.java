package br.senac.si.pi3.modelagemtendencia.service;

import br.senac.si.pi3.modelagemtendencia.dto.AcoesDTO;
import java.text.ParseException;
import java.util.List;

public interface InterpolarService{
    
    List<AcoesDTO> verificarEstadoNoPeriodo(String dataI, String dataF)throws ParseException ;
    
}

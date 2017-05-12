package br.senac.si.pi3.modelagemtendencia.service;

import br.senac.si.pi3.modelagemtendencia.dto.ResultTableDTO;
import java.util.Date;
import java.util.List;

public interface InterpolarService {
    
    List<ResultTableDTO> verificarEstadoNoPeriodo(Date dataI, Date dataF);
    
}

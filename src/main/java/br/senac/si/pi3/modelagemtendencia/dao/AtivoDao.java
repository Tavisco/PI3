package br.senac.si.pi3.modelagemtendencia.dao;

import br.senac.si.pi3.modelagemtendencia.modelo.Acoes;
import java.util.Date;
import java.util.List;

public interface AtivoDao {
    
    List<Acoes> select(Date dataI, Date dataF);
}

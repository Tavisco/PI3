package br.senac.si.pi3.modelagemtendencia.dao;

import br.senac.si.pi3.modelagemtendencia.entity.Acoes;
import java.util.Date;
import java.util.List;

public interface AcoesDao {
    
    List<Acoes> selectRange(Date dataI, Date dataF);
}

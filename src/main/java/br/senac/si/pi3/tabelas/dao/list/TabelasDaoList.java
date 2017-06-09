package br.senac.si.pi3.tabelas.dao.list;

import br.senac.si.pi3.tabelas.entity.Tabelas;
import java.util.Date;
import java.util.List;

public interface TabelasDaoList {
    List<Tabelas> selectRange(Date dataI, Date dataF);
    List<Tabelas> selectValueRange(Date dataI, Date dataF);
}

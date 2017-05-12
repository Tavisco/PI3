package br.senac.si.pi3.modelagemtendencia.dao.impl;

import br.senac.si.pi3.modelagemtendencia.entity.Acoes;
import br.senac.si.pi3.modelagemtendencia.factory.EMFactory;
import java.util.Date;
import java.util.List;
import br.senac.si.pi3.modelagemtendencia.dao.AcoesDao;

public class AcoesDaoImpl implements AcoesDao {

    private List<Acoes> dados;
    //@Inject
    private final EMFactory em;

    public AcoesDaoImpl() {
        this.em = new EMFactory();
    }

    @Override
    public List<Acoes> selectRange(Date dataI, Date dataF) {

        return em.getEntityManager().createNamedQuery("Acoes.findBetweenDates ", Acoes.class)
                .setParameter("dataI", dataI)
                .setParameter("dataF", dataF)
                .getResultList();
    }
}

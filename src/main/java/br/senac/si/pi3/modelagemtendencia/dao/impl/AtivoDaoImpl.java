package br.senac.si.pi3.modelagemtendencia.dao.impl;

import br.senac.si.pi3.modelagemtendencia.dao.AtivoDao;
import br.senac.si.pi3.modelagemtendencia.modelo.Acoes;
import br.senac.si.pi3.modelagemtendencia.persistencia.FabricaEM;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

public class AtivoDaoImpl implements AtivoDao {

    List<Acoes> dados;

    @EJB
    private FabricaEM em;
    Date a;

    @Override
    public List<Acoes> select(Date dataI, Date dataF) {
        //Exemplos do use de namedQuery
        em.getEntityManager().createNamedQuery("Acoes.findAll", Acoes.class).getResultList();
//merge(dataI, dataF)
        em.getEntityManager().createNamedQuery("Acoes.findByData", Acoes.class)
                .setParameter("data", a)
                //Limitador inicial
                //                .setFirstResult(0)
                //Limitador final
                //                .setMaxResults(10);
                
                //testar 
                //                .getFirstResult();
                
                //traz um resultado
                .getSingleResult();
        //sempre para ID
        Acoes a = em.getEntityManager().find(Acoes.class, 1F);
        return dados;
    }

}

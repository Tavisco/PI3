
package br.senac.si.pi3.modelagemtendencia.factory;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
public class EMFactory {
    private EntityManagerFactory emf;

    private EntityManager fabrica() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("apPU");
        }

        return emf.createEntityManager();
    }

    private void fecha(EntityManager em) {
        em.close();
    }
    public EntityManager getEntityManager(){
        return fabrica();
    }
}

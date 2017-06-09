package br.senac.si.pi3.tabelas.dao;

import br.senac.si.pi3.tabelas.entity.Tabelas;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TabelasDao {
    
    private List<Tabelas> dado;
    private EntityManager getEntityManager() {
    
    EntityManagerFactory dados = null;
    EntityManager entityManager = null;
    try {
      //Obtém o dados a partir da unidade de persistência.
      dados = Persistence.createEntityManagerFactory("derbypi3");
      //Cria um entity manager.
      entityManager = dados.createEntityManager();
      //Fecha o dados para liberar os recursos utilizado.
    } finally {
      dados.close();
    }
    return entityManager;
  }
   
    
    public Tabelas consultarPorId(Long id) {
    EntityManager entityManager = getEntityManager();
    Tabelas tab = null;
    try {
      //Consulta uma pessoa pelo seu ID.
      tab = entityManager.find(Tabelas.class, id);
    } finally {
      entityManager.close();
    }
    return tab;
  }
   
}

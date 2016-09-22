package DAO;

import Modelo.Tecnico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tecnico_DAO {
    
    public Tecnico consultarPorId(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExemploPjBDMySQLCRUDPU");
        EntityManager entityManager = factory.createEntityManager();
        Tecnico tipo = new Tecnico();
        try {
            tipo = entityManager.find(Tecnico.class, id);
        } finally {
            entityManager.close();
        }
        return tipo;
    }

    public Tecnico salvar(Tecnico tipo) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExemploPjBDMySQLCRUDPU");
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (tipo.getIdTecnico() == null) {
                entityManager.persist(tipo);
            } else {
                tipo = entityManager.merge(tipo);
            }
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
        return tipo;
    }

    public void excluir(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExemploPjBDMySQLCRUDPU");
        EntityManager entityManager = factory.createEntityManager();
        Tecnico tipo;
        try {
            entityManager.getTransaction().begin();
            tipo = entityManager.find(Tecnico.class, id);
            entityManager.remove(tipo);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

}

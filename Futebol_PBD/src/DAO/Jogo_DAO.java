package DAO;

import Modelo.Jogo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jogo_DAO {
    
    public Jogo consultarPorId(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExemploPjBDMySQLCRUDPU");
        EntityManager entityManager = factory.createEntityManager();
        Jogo tipo = new Jogo();
        try {
            tipo = entityManager.find(Jogo.class, id);
        } finally {
            entityManager.close();
        }
        return tipo;
    }

    public Jogo salvar(Jogo tipo) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExemploPjBDMySQLCRUDPU");
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (tipo.getIdJogo() == null) {
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
        Jogo tipo;
        try {
            entityManager.getTransaction().begin();
            tipo = entityManager.find(Jogo.class, id);
            entityManager.remove(tipo);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

}

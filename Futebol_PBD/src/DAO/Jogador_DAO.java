package DAO;

import Modelo.Jogador;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jogador_DAO {
    
    public Jogador consultarPorId(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExemploPjBDMySQLCRUDPU");
        EntityManager entityManager = factory.createEntityManager();
        Jogador tipo = new Jogador();
        try {
            tipo = entityManager.find(Jogador.class, id);
        } finally {
            entityManager.close();
        }
        return tipo;
    }

    public Jogador salvar(Jogador tipo) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExemploPjBDMySQLCRUDPU");
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (tipo.getIdJogador() == null) {
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
        Jogador tipo;
        try {
            entityManager.getTransaction().begin();
            tipo = entityManager.find(Jogador.class, id);
            entityManager.remove(tipo);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

}

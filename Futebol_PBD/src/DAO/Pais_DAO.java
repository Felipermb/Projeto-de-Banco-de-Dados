package DAO;

import Modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Pais_DAO {
    
    public Pais consultarPorId(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Futebol");
        EntityManager entityManager = factory.createEntityManager();
        Pais tipo = new Pais();
        try {
            tipo = entityManager.find(Pais.class, id);
        } finally {
            entityManager.close();
        }
        return tipo;
    }

    public Pais consultarPorNome(String nome) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Futebol");
        EntityManager entityManager = factory.createEntityManager();
        Pais tipo = new Pais();
        try {
            tipo = entityManager.find(Pais.class, nome);
        } finally {
            entityManager.close();
        }
        return tipo;
    }
    
    public Pais salvar(Pais tipo) throws Exception {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Futebol");
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (tipo.getIdPais() == null) {
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
        Pais tipo;
        try {
            entityManager.getTransaction().begin();
            tipo = entityManager.find(Pais.class, id);
            entityManager.remove(tipo);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

}

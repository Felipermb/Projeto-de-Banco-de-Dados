package DAO;

import Modelo.Time;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Time_DAO {
    
    public Time consultarPorId(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Futebol");
        EntityManager entityManager = factory.createEntityManager();
        Time tipo = new Time();
        try {
            tipo = entityManager.find(Time.class, id);
        } finally {
            entityManager.close();
        }
        return tipo;
    }

    public Time salvar(Time tipo) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Futebol");
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (tipo.getIdTime() == null) {
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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Futebol");
        EntityManager entityManager = factory.createEntityManager();
        Time tipo;
        try {
            entityManager.getTransaction().begin();
            tipo = entityManager.find(Time.class, id);
            entityManager.remove(tipo);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

}

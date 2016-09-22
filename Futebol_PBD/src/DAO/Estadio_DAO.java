package DAO;

import Modelo.Estadio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Estadio_DAO {
    
    public Estadio consultarPorId(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Futebol");
        EntityManager entityManager = factory.createEntityManager();
        Estadio tipo = new Estadio();
        try {
            tipo = entityManager.find(Estadio.class, id);
        } finally {
            entityManager.close();
        }
        return tipo;
    }
    

    public Estadio salvar(Estadio tipo) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Futebol");
        EntityManager entityManager = factory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (tipo.getIdEstadio() == null) {
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
        Estadio tipo;
        try {
            entityManager.getTransaction().begin();
            tipo = entityManager.find(Estadio.class, id);
            entityManager.remove(tipo);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

}

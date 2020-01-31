/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Personne;

/**
 *
 * @author jams9
 */
public class CrudDAO {
    
     private EntityManager entityManager;
     private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudPersonne");
        if (entityManager == null) {
             entityManager = factory.createEntityManager();
        }
        return entityManager;
    }


    public void add(Personne p){
         try {
                entityManager.getTransaction().begin();
                entityManager.persist(p);
                entityManager.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
                entityManager.getTransaction().rollback();
        }

    }
}

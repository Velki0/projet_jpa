package fr.diginamic;

import fr.diginamic.entites.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestBibliotheque {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Livre livre = new Livre();
        livre = em.find(Livre.class, 1);
        System.out.println(livre);



    }

}

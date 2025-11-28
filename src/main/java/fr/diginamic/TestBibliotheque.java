package fr.diginamic;

import fr.diginamic.entites.Client;
import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestBibliotheque {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque");
        EntityManager em = entityManagerFactory.createEntityManager();

        // Réaliser une requête qui permet d’extraire un emprunt en fonction de son id. Affichez tous les livres associés
        Emprunt emprunt = em.find(Emprunt.class, 1);
        for(Livre livre : emprunt.getLivres()){
            System.out.println(livre);
        }

        System.out.println("------------------------------------------------------------------------------------------------");

        // Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
        TypedQuery<Client> premiereRequete = em.createQuery("FROM Client c WHERE c.nom = :nom", Client.class);
        Client clientChoisi = premiereRequete.setParameter("nom", "Brigand").getSingleResult();
        TypedQuery<Emprunt> secondeRequete = em.createQuery("SELECT emp from Emprunt emp WHERE emp.client = :client", Emprunt.class);
        List<Emprunt> empruntsClientChoisi = secondeRequete.setParameter("client", clientChoisi).getResultList();
        for (Emprunt emp : empruntsClientChoisi) {
            for (Livre livre : emp.getLivres()){
                System.out.println(livre);
            }
        }

        entityManagerFactory.close();
        em.close();

    }

}

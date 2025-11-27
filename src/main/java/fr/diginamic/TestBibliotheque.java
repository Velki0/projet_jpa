package fr.diginamic;

import fr.diginamic.entites.Client;
import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        String nomDuClientChoisi = "Brigand";
        Client clientChoisi = em.createQuery("FROM Client c WHERE c.nom ='" + nomDuClientChoisi + "'", Client.class).getSingleResult();
        List<Emprunt> empruntsClientChoisi = em.createQuery("SELECT emp from Emprunt emp WHERE emp.client =" + clientChoisi.getId(), Emprunt.class).getResultList();
        for (Emprunt emp : empruntsClientChoisi) {
            for (Livre livre : emp.getLivres()){
                System.out.println(livre);
            }
        }

    }

}

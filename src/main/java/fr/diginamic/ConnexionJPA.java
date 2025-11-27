package fr.diginamic;

import fr.diginamic.entites.Region;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ConnexionJPA {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo_jpa");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Region auvergneRhoneAlpesAuvergne = new Region("Auvergne-Rhône-Alpes");
        Region normandie = new Region("Normandie");

        transaction.begin();
        em.persist(auvergneRhoneAlpesAuvergne);
        em.persist(normandie);
        transaction.commit();

        Region regionLambda = em.find(Region.class, 1);
        System.out.println("La région d'id 1 est : " + regionLambda);

        List<Region> listeRegion = em.createQuery("SELECT r FROM Region r", Region.class).getResultList();
        for (Region region : listeRegion) {
            System.out.println(region + " ");
        }

    }

}

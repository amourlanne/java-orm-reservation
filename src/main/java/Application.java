import DAO.EvenementDao;
import DAO.ReservationDao;
import Entity.Evenement;
import Entity.Personne;
import Entity.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class Application
 * Created by Alexis on 08/04/2019
 */
public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("reservation");
        try {
            EntityManager em = emf.createEntityManager();
            try {
                EvenementDao evenementDao = new EvenementDao(em);
                ReservationDao reservationDao = new ReservationDao(em);

                Evenement matchDeFoot = evenementDao.get("EVE0001");

                // Create Evenement if not exist
                if(matchDeFoot == null) {
                    Evenement evenement = new Evenement();
                    evenement.setNom("Match de foot");
                    evenement.setCode("EVE0001");
                    evenement.setDateEvenement(new Date());

                    em.getTransaction().begin();
                    evenementDao.creer(evenement);
                    em.getTransaction().commit();

                    matchDeFoot = evenementDao.get("EVE0001");
                }

                System.out.println(matchDeFoot);

                Personne pierre = new Personne("Pierre");
                Personne paul = new Personne("Paul");

                // Add Reservation
                em.getTransaction().begin();
                Reservation reservation1 = reservationDao.reserver("EVE0001", new ArrayList<Personne>(){{
                    add(pierre);
                    add(paul);
                }});

                if(reservation1 == null) {
                    em.getTransaction().rollback();
                } else {
                    em.getTransaction().commit();
                    System.out.println(reservation1);
                }

                Personne jacque = new Personne("Jacque");

                // Add Reservation
                em.getTransaction().begin();
                Reservation reservation2 = reservationDao.reserver("EVE0001", new ArrayList<Personne>(){{
                    add(jacque);
                }});

                if(reservation2 == null) {
                    em.getTransaction().rollback();
                } else {
                    em.getTransaction().commit();
                    System.out.println(reservation2);
                }

                // Print number of personnes
                System.out.println("Nombre de personnes: " + evenementDao.getNbPersonnes("EVE0001"));

                // remove Reservation
                System.out.println("Suppression de " + reservation1);
                em.getTransaction().begin();
                reservationDao.supprimer(reservation1);
                em.getTransaction().commit();

                // Print number of personnes
                System.out.println("Nombre de personnes: " + evenementDao.getNbPersonnes("EVE0001"));

                // remove Reservation
                System.out.println("Suppression de " + reservation2);
                em.getTransaction().begin();
                reservationDao.supprimer(reservation2);
                em.getTransaction().commit();

                // Print number of personnes
                System.out.println("Nombre de personnes: " + evenementDao.getNbPersonnes("EVE0001"));

            } finally {
                em.close();
            }
        } finally {
            emf.close();
        }
    }
}

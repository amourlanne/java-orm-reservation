package DAO;

import Entity.Evenement;
import Entity.Personne;
import Entity.Reservation;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

/**
 * Class ReservationDao
 * Created by Alexis on 08/04/2019
 */
public class ReservationDao extends AbstractDAO {

    public ReservationDao(EntityManager entityManager) {
        super(entityManager);
    }

    public Reservation reserver(String codeEvenement, List<Personne> personnes) {

        EvenementDao evenementDao = new EvenementDao(entityManager);

        Evenement evenement = evenementDao.get(codeEvenement);
        if(evenement != null) {

            Reservation reservation = new Reservation();
            reservation.setEvenement(evenement);
            reservation.setDateReservation(new Date());
            reservation.setPersonnes(personnes);

            for ( Personne personne: personnes) {
                personne.setReservation(reservation);
            }

            entityManager.persist(reservation);

            return reservation;
        }
        return null;
    }

    public void supprimer(Reservation reservation) {
        entityManager.remove(reservation);
    }
}

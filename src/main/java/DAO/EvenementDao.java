package DAO;

import Entity.Evenement;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * Class EvenementDao
 * Created by Alexis on 08/04/2019
 */
public class EvenementDao extends AbstractDAO {

    public EvenementDao(EntityManager entityManager) {
        super(entityManager);
    }

    public void creer(Evenement evenement) {
        entityManager.persist(evenement);
    }

    public Evenement get(String code) {
        try {
            return entityManager.createQuery("select e from Evenement e where e.code = :code", Evenement.class)
                    .setParameter("code", code)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public long getNbPersonnes(String code) {
        return entityManager.createQuery("select count(p) from Personne p join p.reservation r where r.evenement.code = :code", Long.class)
                .setParameter("code", code)
                .getSingleResult();
    }
}

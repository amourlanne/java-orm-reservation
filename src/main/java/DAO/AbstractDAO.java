package DAO;

import javax.persistence.EntityManager;

/**
 * Class AbstractDAO
 * Created by Alexis on 08/04/2019
 */
public class AbstractDAO {

    protected EntityManager entityManager;

    public AbstractDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

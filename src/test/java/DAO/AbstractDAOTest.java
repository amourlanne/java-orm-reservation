package DAO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class AbstractDAOTest
 * Created by Alexis on 08/04/2019
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbstractDAOTest {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    protected AbstractDAO dao;

    public AbstractDAOTest() {
        emf = Persistence.createEntityManagerFactory("reservation");
        em = emf.createEntityManager();
    }

    @AfterAll
    void clear() {
        em.clear();
        em.close();
        emf.close();
    }
}

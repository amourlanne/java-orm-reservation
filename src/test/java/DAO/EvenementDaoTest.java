package DAO;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EvenementDaoTest extends AbstractDAOTest {

    @BeforeAll
    void initDAO() {
        dao = new EvenementDao(em);
    }

    @Test
    void creer() {
        // TODO: implement method
    }

    @Test
    void get() {
        // TODO: implement method
    }

    @Test
    void getNbPersonnes() {
        // TODO: implement method
    }
}
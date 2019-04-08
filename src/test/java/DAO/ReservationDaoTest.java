package DAO;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ReservationDaoTest extends AbstractDAOTest {

    @BeforeAll
    void initDAO() {
        dao = new ReservationDao(em);
    }

    @Test
    void reserver() {
        // TODO: implement method
    }

    @Test
    void supprimer() {
        // TODO: implement method
    }
}
package Entity;

import javax.persistence.*;

/**
 * Class Personne
 * Created by Alexis on 08/04/2019
 */
@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @ManyToOne()
    @JoinColumn(name="reservation_id")
    private Reservation reservation;

    public Personne(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

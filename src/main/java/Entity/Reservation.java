package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class Reservation
 * Created by Alexis on 08/04/2019
 */
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date dateReservation;

    @ManyToOne
    @JoinColumn(name="evenement_id", nullable=false)
    private Evenement evenement;

    @OneToMany(mappedBy="reservation", cascade={/*CascadeType.REMOVE, CascadeType.PERSIST, */CascadeType.ALL })
    private List<Personne> personnes = new ArrayList<Personne>();

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    @Override
    public String toString() {
        String result = "Reservation n°" + id + " pour \"" + evenement.getNom() + "\" : ";
        boolean first = true;
        for (Personne p: personnes) {
            if(!first) result += ", ";
            result += p.getNom();
            first = false;
        }
        return result;
    }
}

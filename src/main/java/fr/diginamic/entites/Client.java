package fr.diginamic.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    private int id;

    @Column (name = "NOM")
    private String nom;

    @Column (name = "PRENOM")
    private String prenom;

    @OneToMany (mappedBy = "client")
    private List<Emprunt> emprunts;

    public Client() {}
    public Client(String nom, String prenom) {

        this.nom = nom;
        this.prenom = prenom;

    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

}

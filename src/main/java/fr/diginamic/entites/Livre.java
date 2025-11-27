package fr.diginamic.entites;

import javax.persistence.*;

@Entity
@Table (name = "livre")
public class Livre {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "TITRE")
    private String titre;

    @Column (name = "AUTEUR")
    private String auteur;

    public Livre() {}
    public Livre(String titre, String auteur) {

        this.titre = titre;
        this.auteur = auteur;

    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }

}

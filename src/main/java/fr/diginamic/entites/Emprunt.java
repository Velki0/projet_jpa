package fr.diginamic.entites;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE_DEBUT")
    private Date dateDebut;

    @Column(name = "DELAI")
    private int delai;

    @Column(name = "DATE_FIN")
    private Date dateFin;

    @ManyToOne
    @JoinColumn (name = "ID_CLIENT")
    private Client client;

    @ManyToMany (mappedBy = "emprunts")
    private List<Livre> livres;

    public Emprunt() {}
    public Emprunt(int id, Date dateDebut, int delai, Date dateFin, Client client,  List<Livre> livres) {

        this.id = id;
        this.dateDebut = dateDebut;
        this.delai = delai;
        this.dateFin = dateFin;
        this.client = client;
        this.livres = livres;

    }

    public List<Livre> getLivres() { return livres; }

}

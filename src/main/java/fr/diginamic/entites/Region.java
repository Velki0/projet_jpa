package fr.diginamic.entites;

import javax.persistence.*;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOM", length = 25, nullable = false, unique = true)
    private String name;

    public Region() {}

    public Region(String name) {

        this.name = name;

    }

    @Override
    public String toString() {
        return name;
    }

}

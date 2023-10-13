package tn.enis.lab.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@DiscriminatorValue("etd")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Membre{

    @Builder
    public Etudiant( String cin, String nom, String prenom, Date dateNaissance,byte[] photo,
                     String cv, String email, String password, Date dateInscription,
                     String sujet, String diplome, EnseignantChercheur encadrant) {
        super( cin, nom, prenom, dateNaissance, cv, email, password);
        this.dateInscription = dateInscription;
        this.sujet = sujet;
        this.diplome = diplome;
        this.encadrant = encadrant;
    }

    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    private String diplome;
    @ManyToOne
    private EnseignantChercheur encadrant;
    private String sujet;
}

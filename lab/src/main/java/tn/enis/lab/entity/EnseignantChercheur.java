package tn.enis.lab.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@DiscriminatorValue("ens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantChercheur extends Membre{

    @Builder
    public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, byte[] photo,
                    String cv, String email, String password,String grade, String etablissement) {
        super( cin, nom, prenom, dateNaissance, cv, email, password);
        this.grade = grade;
        this.etablissement = etablissement;
    }

    private String grade;
    private String etablissement;
}
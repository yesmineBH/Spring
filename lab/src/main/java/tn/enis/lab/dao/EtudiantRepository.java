package tn.enis.lab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.lab.entity.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByDiplome(String diplome);
    List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome);
}

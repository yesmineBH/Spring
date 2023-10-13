package tn.enis.lab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.lab.entity.Membre;

import java.util.List;

public interface MembreRepository extends JpaRepository<Membre,Long> {
    Membre findByCin(String cin);
    List<Membre> findByNomStartingWith(String caractere);
    Membre findByEmail(String email);
}

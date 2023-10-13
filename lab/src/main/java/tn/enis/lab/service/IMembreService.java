package tn.enis.lab.service;
import java.util.List;

import tn.enis.lab.dao.EnseignantChercheurRepository;
import tn.enis.lab.dao.EtudiantRepository;
import tn.enis.lab.dao.MembreRepository;
import tn.enis.lab.entity.Etudiant;
import tn.enis.lab.entity.EnseignantChercheur;
import tn.enis.lab.entity.Membre;

public interface IMembreService {
    //Affecter un étudiant à un enseignant
    public void affecterEtudiantToEnseignant(Long idEtd, Long idEns);
    public Membre addMember(Membre m);
    public void deleteMember(Long id) ;
    public Membre updateMember(Membre p) ;
    public Membre findMember(Long id) ;
    public List<Membre> findAll();
    //Filtrage par propriété
    public Membre findByCin(String cin);
    public Membre findByEmail(String email);
    public List<Membre> findByNom(String nom);
    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);
    //recherche spécifique des enseignants
    public List<EnseignantChercheur> findByGrade(String grade);
    public List<EnseignantChercheur> findByEtablissement(String etablissement);
}



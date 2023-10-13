package tn.enis.lab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.enis.lab.dao.EnseignantChercheurRepository;
import tn.enis.lab.dao.EtudiantRepository;
import tn.enis.lab.dao.MembreRepository;
import tn.enis.lab.entity.Etudiant;
import tn.enis.lab.entity.EnseignantChercheur;
import tn.enis.lab.entity.Membre;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MembreImpl implements IMembreService {
    MembreRepository membrerepository;
    EtudiantRepository etudiantrepository;
    EnseignantChercheurRepository enseignantrepository;
    @Override
    public Membre addMember(Membre m) {
        membrerepository.save(m);
        return m;
    }

    @Override
    public void deleteMember(Long id) {
        membrerepository.deleteById(id);

    }

    @Override
    public Membre updateMember(Membre m) {

        return membrerepository.saveAndFlush(m);
    }

    @Override
    public Membre findMember(Long id) {
        Membre m= (Membre)membrerepository.findById(id).get();
        return m;
    }

    @Override
    public List<Membre> findAll() {
        // TODO Auto-generated method stub
        return membrerepository.findAll();
    }

    @Override
    public Membre findByCin(String cin) {
        Membre m=(Membre)membrerepository.findByCin(cin);
        return m;
    }

    @Override
    public Membre findByEmail(String email) {
        Membre m=(Membre)membrerepository.findByEmail(email);
        return m;
    }

    @Override
    public List<Membre> findByNom(String nom) {
        // TODO Auto-generated method stub
        return membrerepository.findByNomStartingWith(nom);
    }

    @Override
    public List<Etudiant> findByDiplome(String diplome) {
        // TODO Auto-generated method stub
        return etudiantrepository.findByDiplome(diplome);
    }

    @Override
    public List<EnseignantChercheur> findByGrade(String grade) {
        // TODO Auto-generated method stub
        return enseignantrepository.findByGrade(grade);
    }

    @Override
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        // TODO Auto-generated method stub
        return enseignantrepository.findByEtablissement(etablissement);
    }
    @Override
    public void affecterEtudiantToEnseignant(Long idEtd, Long idEns) {
        {
            Etudiant etd = etudiantrepository.findById(idEtd).get();
            EnseignantChercheur ens = enseignantrepository.findById(idEns).get();
            etd.setEncadrant(ens);
            etudiantrepository.save(etd);


        }
    }

}


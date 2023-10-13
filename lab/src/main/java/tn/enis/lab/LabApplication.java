package tn.enis.lab;


import java.util.List;




import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tn.enis.lab.dao.MembreRepository;
import tn.enis.lab.entity.Etudiant;
import tn.enis.lab.entity.EnseignantChercheur;
import tn.enis.lab.entity.Membre;
import tn.enis.lab.service.MembreImpl;
import tn.enis.lab.service.IMembreService;





import java.util.Date;

@AllArgsConstructor
@SpringBootApplication
@EnableDiscoveryClient
public class LabApplication implements CommandLineRunner {

	MembreRepository membreRepository;
	IMembreService membreService;
	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class, args);
	}

	public void run(String... args) throws Exception {

		Etudiant etd1=Etudiant.builder()
				.cin("11138377")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("ING")
				.email("zied@gmail.com")
				.password("zied")
				.encadrant(null)
				.cv("cv1")
				.nom("Dammak")
				.prenom("Zied)")
				.sujet("blockhain")
				.build();
		membreService.addMember(etd1);

		Etudiant etd2= Etudiant.builder()
				.cin("123456")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("mastère")
				.email("etd2@gmail.com")
				.password("pass1")
				.encadrant(null)
				.nom("abida")
				.prenom("youssefa")
				.sujet("blockhain")
				.cv("cv1")
				.build();
		membreService.addMember(etd2);

		EnseignantChercheur ens1= EnseignantChercheur.builder()
				.cin("123456")
				.dateNaissance(new Date())
				.email("ens1@gmail.com")
				.password("pass1")
				.nom("senpai")
				.prenom("sama")
				.grade("terminal")
				.etablissement("ENIS")
				.cv("cv1")

				.build();
		membreService.addMember(ens1);

		EnseignantChercheur ens2= EnseignantChercheur.builder()
				.cin("123456")
				.dateNaissance(new Date())
				.email("ens2@gmail.com")
				.password("pass1")
				.nom("dazai")
				.prenom("chuuya")
				.grade("second")
				.cv("cv1")

				.etablissement("ENIS")
				.build();
		membreService.addMember(ens2);

		List<Membre> mbrs=membreService.findAll();
		for(Membre membre:mbrs) {
			System.out.println(membre.getNom()+" "+ membre.getPrenom());
		}
		/*
		Membre e1=membrerepository.findById(1L).get();
		System.out.println(e1.getNom());
		*/
		etd1.setEmail("BH@gmail.com");
		membreService.addMember(etd1);

		//List<Membre> mbrs = Membre.findAll();
		//for (Membre member: mbrs){
		//System.out.println(member.getNom()+"         ");
		//}

		membreService.affecterEtudiantToEnseignant(1L,3L);
	}
}
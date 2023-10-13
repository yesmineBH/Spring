package tn.enis.lab.Controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;








import tn.enis.lab.entity.Etudiant;
import tn.enis.lab.entity.EnseignantChercheur;
import tn.enis.lab.entity.Membre;
import tn.enis.lab.service.IMembreService;
@AllArgsConstructor
@RestController
public class MemberController {

    IMembreService memberService;
    @RequestMapping(value="/membres", method=RequestMethod.GET)
    public List<Membre> findMembres (){
        return memberService.findAll();
    }
    @GetMapping(value="/membres/{id}")
    public Membre findOneMemberById(@PathVariable Long id){
        return memberService.findMember(id);
    }

    @GetMapping(value="/membres/search/cin")
    public Membre findOneMemberByCin(@RequestParam String cin)
    {
        return memberService.findByCin(cin);
    }
    @GetMapping(value="/membres/search/email")
    public Membre findOneMemberByEmail(@RequestParam String email)
    {
        return memberService.findByEmail(email);
    }
    @PostMapping(value="/membres/enseignant")
    public Membre addMembre(@RequestBody EnseignantChercheur m)
    {
        return  memberService.addMember(m);
    }
    @PostMapping(value="/membres/etudiant")
    public Membre addMembre(@RequestBody Etudiant e)
    {
        return  memberService.addMember(e);
    }
    @DeleteMapping(value="/membres/{id}")
    public void deleteMembre(@PathVariable Long id)
    {
        memberService.deleteMember(id);
    }
    @PutMapping(value="/membres/etudiant/{id}")
    public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p)
    {
        p.setId(id);
        return memberService.updateMember(p);
    }

    @PutMapping(value="/membres/enseignant/{id}")
    public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p)
    {
        p.setId(id);
        return memberService.updateMember(p);
    }


}


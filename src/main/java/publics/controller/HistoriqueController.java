package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import publics.model.Blocage;
import publics.model.Compte;
import publics.model.Historique;
import publics.repository.BlocageRepository;
import publics.repository.CompteRepository;
import publics.repository.HistoriqueRepository;
import publics.service.BlocageService;
import publics.service.Data;
import publics.service.HistoriqueService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/historiques")
public class HistoriqueController {
    @Autowired
    private HistoriqueRepository historique;
    @Autowired
    private BlocageService bls;

    @Autowired
    private BlocageRepository blr;

    @Autowired
    private CompteRepository cptr;
 @Autowired
    private HistoriqueService hs;


    @GetMapping
    public Object getAll(){
        try{
            return new Data( historique.findAll());
        }catch(Exception e){
            return new Error(e);
        }
    }
    @GetMapping("{idProprietaire}")
    public List<Historique> getHistoriqueByPorp(@PathVariable int idProprietaire){
            return hs.historiqueEncherebyProp(idProprietaire);
    }
    @GetMapping("/user/{iduser}")
    public List<Historique> getHistoriqueByUser(@PathVariable int iduser){
        return hs.historiqueByUser(iduser);
    }
    @PostMapping
    public Object saveHistorique(@RequestBody Historique h) {
        try {
            Boolean prix = Historique.checkPrix(h, historique.findAll());
            Historique his=null;
            Compte cp=cptr.findByIdUser(h.getUser().getIduser());
            if (prix == false)
                return new Error("valeur inférieur à la normale");
            else if(h.getPrix()>cp.getSomme())
                return new Error("Solde insuffisant pour la valeur indiquer");
            else{
                his=historique.save(h);
                bls.deleteFromEnchere(his.getEnchere().getIdenchere());
                Blocage bl=new Blocage(null,his.getEnchere(),his.getPrix(),his.getUser());
                blr.save(bl);
            }
            return new Data(his);
        } catch (Exception e) {
            e.printStackTrace();
            return new Error(e);
        }
    }
}

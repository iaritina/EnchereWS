package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.Enchere;
import publics.model.Historique;
import publics.model.Recherche;
import publics.repository.EnchereRepository;
import publics.repository.ImageRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnchereService {
    @Autowired
    private EnchereRepository repo;

    @Autowired
    private ImageService repoImg;



    //public ArrayList<Enchere> rechercher(Recherche r){
    //    String condition=" " ;
    //    if (r.getMot()!=null){
    //        condition=condition+" and "+"descprition="+r.getMot() +"or produit="+r.getMot();
    //    }
    //    if(r.getCategorie()!=null&&r.getCategorie().length!=0){
    //        for(int x=0;x<r.getCategorie().length;x++){
    //            condition=condition + " and "+ "idcategorie="+r.getCategorie()[x];
    //        }
    //    }
    //}

    public List<Enchere> nonVendue(){

        List<Enchere> ls= repo.nonVendue();
        for(Enchere e: ls){
            e.setImage(repoImg.findByIdenchere(e.getIdenchere()).getPhoto());
        }
        return ls;
    }

    public Enchere byId(int idUser){
        Enchere e=repo.byId(idUser);
        e.setImage(repoImg.findByIdenchere(e.getIdenchere()).getPhoto());
        return e;
    }

    public List<Enchere> byIdUser(int iduser){
        List<Enchere> ls= repo.byIdUser(iduser);
        for(Enchere e: ls){
            e.setImage(repoImg.findByIdenchere(e.getIdenchere()).getPhoto());
        }
        return ls;
    }

    public Enchere byIdEnCours(int idenchere){
        Enchere e=repo.byIdEnCours(idenchere);
        e.setImage(repoImg.findByIdenchere(e.getIdenchere()).getPhoto());
        return e;
    }
    public List<Enchere> parDate(){
        List<Enchere> ls= repo.parDate();
        for(Enchere e: ls){
            e.setImage(repoImg.findByIdenchere(e.getIdenchere()).getPhoto());
        }
        return ls;
    }
    public List<Enchere> encours(){
        List<Enchere> ls= repo.encours();
        for(Enchere e: ls){
            e.setImage(repoImg.findByIdenchere(e.getIdenchere()).getPhoto());
        }
        return ls;
    }
    public Enchere save(Enchere e){
        return repo.save(e);
    }

    public void finish(){

    }
}

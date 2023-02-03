package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.Historique;
import publics.repository.HistoriqueRepository;
import publics.repository.ImageRepo;

import java.util.List;

@Service
public class HistoriqueService {
    @Autowired
    private HistoriqueRepository hR;
    @Autowired
    private ImageService servimg;
    public List<Historique> historiqueEncherebyProp(int idProprietaire){
        List<Historique> hr= hR.historiqueEncherebyProp(idProprietaire);
        for(Historique h: hr)
            h.getEnchere().setImage(servimg.findByIdenchere(h.getEnchere().getIdenchere()).getPhoto());
        return hr;
    }

    public List<Historique> historiqueByUser(int iduser){
        List<Historique> hr= hR.historiqueByUser(iduser);
        for(Historique h: hr){
            System.out.println(h.getEnchere().getIdenchere());
            h.getEnchere().setImage(servimg.findByIdenchere(h.getEnchere().getIdenchere()).getPhoto());
        }
        return hr;
    }
}

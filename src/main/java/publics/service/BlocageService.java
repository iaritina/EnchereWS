package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.repository.BlocageRepository;

@Service
public class BlocageService {
    @Autowired
    private BlocageRepository blr;
    public void deleteFromEnchere(int idEnchere){
        blr.deleteBlocageByEnchere(idEnchere);
    }
}

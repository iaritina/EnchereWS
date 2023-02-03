package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import publics.model.Blocage;
import publics.model.Compte;
import publics.model.Enchere;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte,String> {
    @Query(value = "select * from v_compte where iduser=:idUser",nativeQuery = true)
    Compte findByIdUser(int idUser);
}

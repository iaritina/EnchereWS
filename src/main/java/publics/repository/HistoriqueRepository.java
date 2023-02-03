package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import publics.model.Historique;

import java.util.List;

public interface HistoriqueRepository extends JpaRepository<Historique,Integer> {
    @Query(value = "select * from v_historique where idproprietaire=:id",nativeQuery = true)
    List<Historique> historiqueEncherebyProp(int id);

    @Query(value = "select * from v_historique where idproprietaire=:id",nativeQuery = true)
    List<Historique> historiqueByUser(int id);

}

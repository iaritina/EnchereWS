package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import publics.model.Blocage;
import publics.model.Enchere;

public interface BlocageRepository extends JpaRepository<Blocage,String> {
    @Modifying
    @Transactional
    @Query(value = "delete from blocage where idenchere=:id", nativeQuery = true)
    void deleteBlocageByEnchere(int id);

}

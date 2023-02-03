package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import publics.model.Token;
import publics.model.TokenUser;

public interface TokenUserRepository  extends JpaRepository<TokenUser, String> {
    @Modifying
    @Transactional
    @Query(value = "delete from tokenU where valeur=:value", nativeQuery = true)
    void deconnex(String value);
    @Modifying
    @Transactional
    @Query(value = "delete from tokenU where iduser=:iduser", nativeQuery = true)
    void deleteById(int iduser);

    @Query(value = "select * from tokenU where valeur=:value order by dateexpiration desc limit 1", nativeQuery = true)
    TokenUser getById(String value);
}

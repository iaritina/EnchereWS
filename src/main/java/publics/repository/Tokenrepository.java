package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publics.model.Token;
import publics.model.TokenUser;

public interface Tokenrepository extends JpaRepository<TokenUser, String> {
}

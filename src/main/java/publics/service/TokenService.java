package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.Token;
import publics.model.TokenUser;
import publics.repository.TokenUserRepository;
import publics.repository.Tokenrepository;

import java.util.List;
import java.util.Optional;

@Service
public class TokenService {
    @Autowired
    public TokenUserRepository tokenRepository;

    public TokenUser save(TokenUser tk) {
        tokenRepository.save(tk);
        return tk;
    }

    public Boolean verification(String valeur) throws Exception {
        TokenUser ts=tokenRepository.getById(valeur);
            if (ts.getValeur().compareToIgnoreCase(valeur) == 0)
                return Token.verification(ts.getDateexpiration());
        throw new Exception("Veuillez vous connecter");
    }
}

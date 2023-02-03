package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.Token;
import publics.model.TokenUser;
import publics.repository.TokenUserRepository;
import publics.repository.Tokenrepository;

@Service
public class TokenUserService {
    @Autowired
    public TokenUserRepository tokenuserRepository;

    public TokenUser save(TokenUser tk) {
        tokenuserRepository.save(tk);
        return tk;
    }
}

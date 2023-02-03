package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import publics.model.Token;
import publics.repository.TokenUserRepository;
import publics.repository.Tokenrepository;
import publics.service.Data;
import publics.service.TokenService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/tokens")

public class TokenController {

    @Autowired
    private TokenUserRepository tokenRepository;
    @Autowired
    private TokenService tokenserv;


    @PostMapping
    public Object verifyToken(@RequestBody Token token) {
        try{
            return new Data(tokenserv.verification(token.getValeur()));
        }catch(Exception e){
            return new Error(e);
        }
    }



}

package publics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import publics.model.*;
import publics.service.*;
import publics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.Error;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/encheres")

public class EnchereController {
   
    @Autowired
    private EnchereService service;
    @GetMapping
    public List<Enchere> getAll(){
        return service.parDate();
    }
    @GetMapping("{idenchere}")
    public Enchere getHistoriqueById(@PathVariable int idenchere){
        return service.byId(idenchere);
    }

    @GetMapping("enchereUser/{idUser}")
    public List<Enchere> getByIdUser(@PathVariable int idUser){
        return service.byIdUser(idUser);
    }
    @GetMapping(value= "/encours")
    public List<Enchere> getenCours(){
        return service.encours();
    }


    @PostMapping(value = "/ajout")
    public Object create(@RequestBody Enchere enchere) {
        try {
            return new Data(service.save(enchere));
        } catch (Exception e) {
            return new Error(e);
        }
    }
}

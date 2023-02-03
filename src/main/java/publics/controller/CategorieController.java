package publics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import publics.model.Categorie;
import publics.repository.CategorieRepository;
import publics.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import publics.service.Data;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private CategorieService catServ;
    @Autowired
    private CategorieRepository catRepo;

    @GetMapping
    public ArrayList<Object> getAll(){
        try{
            return new ArrayList(catRepo.findAll());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}


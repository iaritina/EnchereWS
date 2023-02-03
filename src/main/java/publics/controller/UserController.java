package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import publics.exception.ErrorException;
import publics.exception.ResourceNotFoundException;
import publics.model.Token;
import publics.model.TokenUser;
import publics.model.User;
import publics.repository.TokenUserRepository;
import publics.repository.UserRepository;
import publics.service.Data;
import publics.service.TokenAgeService;
import publics.service.TokenUserService;
import publics.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/utilisateurs")
public class UserController {
    @Autowired
    private UserRepository userrepository;
    @Autowired
    private UserService serv;
    @Autowired
    private TokenUserService tokenService;
    @Autowired
    private TokenAgeService ageService;

    @Autowired
    private TokenUserRepository tRp;

    @GetMapping
    public Data getAllUsers() {
        System.out.println("User ok");
        return new Data(serv.findAllAd());
    }

    @PostMapping
    public Object login(@RequestBody User user) {
        try {
            int id = User.auth(user, userrepository.findAll());
            if (id == 0)
                return new Error(new ErrorException("Authentification incorrect"));
            user.setIduser(id);
            tRp.deleteById(id);
            String tokenUser = TokenUser.generateToken(user.getEmail() + user.getMot());
            TokenUser tk = new TokenUser(tokenUser, user.getIduser(), ageService.expiration());
            tk=tokenService.save(tk);
            System.out.println(tk);
            return new Data(tk);
        } catch (Exception e) {
            e.printStackTrace();
            return new Error(e);
        }
    }

    @PostMapping(value = "/inscription")
    public Object Inscription(@RequestBody User user) {
        try {
            return new Data(userrepository.save(user));
        } catch (Exception e) {
            return new Error(e);
        }
    }

    @GetMapping("{id}")
    public Object getUserById(@PathVariable int id) {
        try {
            User user = userrepository.findById(id).get();
            return new Data(ResponseEntity.ok(user));
        } catch (Exception e) {
            return new Error((new ResourceNotFoundException("not exist with id: " + id)));
        }
    }

    @PutMapping("{id}")
    public Object updateUser(@PathVariable int id, @RequestBody User UserDetails) {
        try {
            User updateUser = userrepository.findById(id).get();
            if (updateUser == null)
                return new Error(new ResourceNotFoundException("not exist with id: " + id));
            updateUser.setIduser(UserDetails.getIduser());
            updateUser.setEmail(UserDetails.getEmail());
            updateUser.setMot(UserDetails.getMot());
            userrepository.save(updateUser);
            return new Data(ResponseEntity.ok(updateUser));
        } catch (Exception e) {
            return new Error(e);
        }
    }

    @DeleteMapping("{id}")
    public Object deleteUser(@PathVariable int id) {
        try {
            User user = userrepository.findById(id).get();
            if (user == null)
                return new Error(new ResourceNotFoundException("not exist with id: " + id));

            userrepository.delete(user);
            return new Data(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new Error(e);
        }

    }


}

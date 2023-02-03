package publics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import publics.model.EnchereV;
import publics.model.Image;
import publics.repository.EnchereVRepository;
import publics.repository.ImageRepo;
import publics.service.Data;
import publics.service.EnchereVservice;
import publics.service.ImageService;

@CrossOrigin("*")
@RestController
@RequestMapping("/enchereV")
public class EnchereVcontroller {

    @Autowired
    private EnchereVRepository enchV;
    private ImageService im;

    @PostMapping
    public Object AddEnchere(@RequestBody EnchereV ench) {
        try {
            EnchereV v=enchV.save(ench);
            Image img=new Image(v.getIdenchere(),ench.getPhoto());
            //System.out.println(im.postimage(img));
            return new Data(v);
        } catch (Exception e) {
            e.printStackTrace();
            return new Error(e);
        }
    }
}

package publics.controller;


import lombok.AllArgsConstructor;
import org.hibernate.criterion.Example;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import publics.model.Image;
import publics.repository.ImageRepo;
import publics.service.Data;
import publics.service.ImageService;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;
    private final ImageRepo imageRepo;

    @GetMapping
    public List<Image> getAllImage(){
        return imageRepo.findAll();
    }
    @PostMapping
    public Object createImage(@RequestBody Image image){
        try{
            System.out.println(image.getPhoto());
            Image img=imageService.postimage(image);
            System.out.println(img);
            return new Data(img);
        }catch (Exception e) {
            e.printStackTrace();
            return new Error(e);
        }
    }
}

package publics.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import publics.model.Image;

import java.util.List;

@Repository
public interface ImageRepo extends MongoRepository<Image,String> {
    Image findByIdenchere(int idEnchere);
}

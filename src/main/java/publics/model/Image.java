package publics.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "image")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image {
    @Id
    private String id;
    private int idenchere;

    private String [] photo;

    public Image() {
    }

    public Image(int idenchere, String []profil) {
        this.idenchere = idenchere;
        this.photo = profil;
    }

    @Override
    public String toString() {
        return "Image{" +
                "idenchere=" + idenchere +
                ", photo='" + photo + '\'' +
                '}';
    }
}

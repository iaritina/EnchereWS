package publics.model;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import publics.repository.ImageRepo;
import publics.service.ImageService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "v_encherefin")
public class Enchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idenchere;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idproprietaire")
    private User user;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idcategorie")
    private Categorie categorie;
    @Column(name = "produit")
    private String produit;
    @Column(name = "datemise")
    private Timestamp dateMise;
    @Column(name = "description")
    private String description;
    @Column(name = "mise")
    private int mise;
    @Column(name = "minimal")
    private int minimal;
    @Column(name = "duree")
    private double duree;
    @Column(name="fin")
    private Timestamp fin;
    @Transient
    private int statut;
    @Transient
    private String[] image;

    public int getStatut(){
        Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant());
        if(fin.after(ts))
            return 0;
        return 1;
    }
    public String[] getImage(){
        return this.image;
    }
    public void setImage(String[] img){this.image=img;}

}

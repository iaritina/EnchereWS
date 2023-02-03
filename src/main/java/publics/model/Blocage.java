package publics.model;

import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Blocage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idbl;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idenchere")
    private Enchere enchere;

    @Column
    private int prix;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "iduser")
    private User user;


}

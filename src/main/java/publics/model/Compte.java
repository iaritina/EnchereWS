package publics.model;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "v_compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcompte;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "iduser")
    private User user;

    @Column
    private int somme;
}

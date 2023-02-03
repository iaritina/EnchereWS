package publics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Formatter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tokenu")
public class TokenUser {
    @Id
    private String valeur;
    @Column(name = "iduser")
    private int iduser;
    @Column(name = "dateexpiration")
    private Timestamp dateexpiration;

    public TokenUser(String valeur, int iduser, Timestamp dateexpiration) {
        this.valeur = valeur;
        this.iduser = iduser;
        this.dateexpiration = dateexpiration;
    }

    public static String generateToken(String user) throws Exception {
        Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant());
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        String change = user + ts.toString();
        byte[] bt = md.digest(change.getBytes());
        Formatter formatter = new Formatter();
        for (byte b : bt) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public static Boolean verification(Timestamp delai) throws Exception {
        Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant());
        if (delai.after(ts))
            return true;
        throw new Exception("session expiré");
    }
}

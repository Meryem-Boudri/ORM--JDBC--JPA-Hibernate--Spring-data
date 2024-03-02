package ma.enset.jpatp2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

 @Entity@NoArgsConstructor @AllArgsConstructor
 @Data
 public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String specialite;
    private String email;
    @OneToMany(mappedBy = "medecin")
    @JsonProperty(access =JsonProperty.Access.WRITE_ONLY )
    private Collection<RDV>rendezVous;


}

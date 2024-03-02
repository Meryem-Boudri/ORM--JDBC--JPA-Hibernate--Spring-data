package ma.enset.jpatp2.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.jpatp2.entities.Consultation;
import ma.enset.jpatp2.entities.Medecin;
import ma.enset.jpatp2.entities.Patient;
import ma.enset.jpatp2.entities.SatatusRDV;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING)//pour stocker status sous forme de String
    private SatatusRDV status;

    @ManyToOne
    @JsonProperty(access =JsonProperty.Access.WRITE_ONLY )
    private Patient patient;

    @ManyToOne
    private Medecin medecin;

    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}

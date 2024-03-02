package ma.enset.jpatp2.Service;

import ma.enset.jpatp2.entities.Consultation;
import ma.enset.jpatp2.entities.Medecin;
import ma.enset.jpatp2.entities.Patient;
import ma.enset.jpatp2.entities.RDV;

public interface HospitaleService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin (Medecin medecin);
    RDV saveRDV (RDV rdv);
    Consultation saveConsultation(Consultation consultation);
}

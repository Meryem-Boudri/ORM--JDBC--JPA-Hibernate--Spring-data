package ma.enset.jpatp2.Service;

import jakarta.transaction.Transactional;
import ma.enset.jpatp2.entities.Consultation;
import ma.enset.jpatp2.entities.Medecin;
import ma.enset.jpatp2.entities.Patient;
import ma.enset.jpatp2.entities.RDV;
import ma.enset.jpatp2.repository.ConsultationRepository;
import ma.enset.jpatp2.repository.MedecinRepository;
import ma.enset.jpatp2.repository.PatientRepository;
import ma.enset.jpatp2.repository.RDVRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitaleServiceImpl implements HospitaleService {
   private PatientRepository patientRepository;
   private MedecinRepository medecinRepository;
   private ConsultationRepository consultationRepository;
   private RDVRepository rdvRepository;

    public HospitaleServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RDVRepository rdvRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rdvRepository = rdvRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RDV saveRDV(RDV rdv) {
        return rdvRepository.save(rdv);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}

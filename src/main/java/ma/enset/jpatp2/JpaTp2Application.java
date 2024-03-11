package ma.enset.jpatp2;

import ma.enset.jpatp2.Service.HospitaleServiceImpl;
import ma.enset.jpatp2.entities.*;
import ma.enset.jpatp2.repository.ConsultationRepository;
import ma.enset.jpatp2.repository.MedecinRepository;
import ma.enset.jpatp2.repository.PatientRepository;
import ma.enset.jpatp2.repository.RDVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaTp2Application {
 /*   @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private RDVRepository rdvRepository;
    @Autowired
    private ConsultationRepository consultationRepository;
*/
    public static void main(String[] args) {
        SpringApplication.run(JpaTp2Application.class, args);
    }

//    @Bean
//    CommandLineRunner start(HospitaleServiceImpl service,MedecinRepository medecinRepository,RDVRepository rdvRepository,ConsultationRepository consultationRepository, PatientRepository patientRepository) {
//        return args -> {
//
//            Stream.of("Meryem", "yassmine", "Mohammed").forEach(p -> {
//
//                Patient patient = new Patient();
//                patient.setDate(new Date());
//                patient.setNom(p);
//                patient.setMalade(false);
//                service.savePatient(patient);
//            });

//            Stream.of("Meryem", "yassmine", "Mohammed").forEach(p -> {
//
//                Medecin medecin = new Medecin();
//                medecin.setNom(p);
//                medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
//                service.saveMedecin(medecin);
//            });

//            Patient patient = patientRepository.findByNom("Meryem");
//            Medecin medecin = medecinRepository.findByNom("yassmine");
//            RDV rdv = new RDV();
//            rdv.setDate(new Date());
//            rdv.setStatus(SatatusRDV.PENDING);
//            rdv.setPatient(patient);
//            rdv.setMedecin(medecin);

//            service.saveRDV(rdv);
//
//            RDV rdv1 = rdvRepository.findById(1L).get();
//            Consultation consultation = new Consultation();
//            consultation.setRendezVous(rdv1);
//            consultation.setDateConsultation(new Date());
//            consultation.setRapportConsultation("Rapport de consultation ....");
//            service.saveConsultation(consultation);
//
//
//        };
//    }
}

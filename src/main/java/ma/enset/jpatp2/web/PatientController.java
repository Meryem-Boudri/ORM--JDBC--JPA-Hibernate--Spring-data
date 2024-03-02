package ma.enset.jpatp2.web;

import ma.enset.jpatp2.entities.Patient;
import ma.enset.jpatp2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
@GetMapping("/patients")
    public List<Patient> patientList(){
    return patientRepository.findAll();
}
}

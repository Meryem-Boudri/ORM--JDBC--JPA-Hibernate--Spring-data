package ma.enset.jpatp2.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.jpatp2.entities.Patient;
import ma.enset.jpatp2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@AllArgsConstructor
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "4") int size,

                        @RequestParam(name = "keyword", defaultValue = "")
                        String keyword) {


        Page<Patient> patientPage = patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listPatients", patientPage.getContent());
        model.addAttribute("pages", new int[(int) patientPage.getTotalElements()]);//tableau avec dimension du nombre de page
        model.addAttribute("currentPage", page);//page actuel
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id, String kw, int page) {
        patientRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword" + kw; //redirection
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index"; //redirection
    }

    @GetMapping("/formPatients")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }

    @PostMapping(path = "/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "keyword", defaultValue = "") String kw
                       ) { //Stocker les errors dans bindingResult

        if (bindingResult.hasErrors()) return "formPatients";
        patientRepository.save(patient);
        return "redirect:/index?page="+page+"&keyword="+kw; //mieux de construire nouvelle page pour dire au utilisateur c'est bien saisi
//etapes de validation: ajouter la dependace - ajouter les annotations de validation "beans" - @valid et bindingResult "controller" - th errors "html"
    }

    @GetMapping("/editPatient")
    public String editPatient(Model model, Long id , String keyword, int page ) {
        Patient patient=patientRepository.findById(id).orElse(null);
        if(patient==null){
            throw  new RuntimeException("Patient introuvale");
        }
        model.addAttribute("patient", patient);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);

        return "editPatient";
    }

}

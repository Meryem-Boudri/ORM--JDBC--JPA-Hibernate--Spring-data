package ma.enset.jpatp2.repository;

import jakarta.transaction.Transactional;
import ma.enset.jpatp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
Patient findByNom(String nom);
   public List<Patient> findByMalade(boolean m);
//chercher des patient
   @Query("select p from Patient p  where p.date between :x and :y or p.nom like :z")
   List<Patient>chercherPatient(@Param("x") Date d1, @Param("y") Date d2, @Param("z") String nom);

}

package ma.enset.jpatp2.repository;

import ma.enset.jpatp2.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}

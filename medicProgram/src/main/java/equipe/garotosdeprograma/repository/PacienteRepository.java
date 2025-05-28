package equipe.garotosdeprograma.repository;

import equipe.garotosdeprograma.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
package equipe.garotosdeprograma.repository;

import equipe.garotosdeprograma.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findAllByOrderByDataHoraAsc();
}
package equipe.garotosdeprograma.service;

import equipe.garotosdeprograma.model.Agenda;
import equipe.garotosdeprograma.repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Agenda> listarTodos() {
        return agendaRepository.findAllByOrderByDataHoraAsc();
    }

    public Agenda salvar(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public Agenda buscarPorId(Long id) {
        return agendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Agenda não encontrada"));
    }

    public void excluir(Long id) {
        agendaRepository.deleteById(id);
    }
}
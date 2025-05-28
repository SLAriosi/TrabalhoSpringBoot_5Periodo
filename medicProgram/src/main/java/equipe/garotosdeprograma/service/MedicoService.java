package equipe.garotosdeprograma.service;

import equipe.garotosdeprograma.model.Medico;
import equipe.garotosdeprograma.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Medico salvar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico buscarPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        medicoRepository.deleteById(id);
    }
}
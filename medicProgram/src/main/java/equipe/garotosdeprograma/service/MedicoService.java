package equipe.garotosdeprograma.service;

import equipe.garotosdeprograma.model.Medico;
import equipe.garotosdeprograma.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public void salvar(Medico medico) {
        medicoRepository.save(medico);
    }

    public void excluir(Long id) {
        medicoRepository.deleteById(id);
    }
}

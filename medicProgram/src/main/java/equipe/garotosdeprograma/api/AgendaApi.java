package equipe.garotosdeprograma.api;

import equipe.garotosdeprograma.model.Agenda;
import equipe.garotosdeprograma.service.AgendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendaApi {
    private final AgendaService agendaService;

    public AgendaApi(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public List<Agenda> listarTodos() {
        return agendaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Agenda buscarPorId(@PathVariable Long id) {
        return agendaService.buscarPorId(id);
    }

    @PostMapping
    public Agenda salvar(@RequestBody Agenda agenda) {
        return agendaService.salvar(agenda);
    }

    @PutMapping("/{id}")
    public Agenda atualizar(@PathVariable Long id, @RequestBody Agenda agenda) {
        agenda.setId(id);
        return agendaService.salvar(agenda);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        agendaService.excluir(id);
    }
}
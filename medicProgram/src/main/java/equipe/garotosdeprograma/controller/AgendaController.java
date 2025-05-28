package equipe.garotosdeprograma.controller;

import equipe.garotosdeprograma.model.Agenda;
import equipe.garotosdeprograma.model.Medico;
import equipe.garotosdeprograma.model.Paciente;
import equipe.garotosdeprograma.service.AgendaService;
import equipe.garotosdeprograma.service.MedicoService;
import equipe.garotosdeprograma.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
    private final AgendaService agendaService;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public AgendaController(AgendaService agendaService, MedicoService medicoService, PacienteService pacienteService) {
        this.agendaService = agendaService;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public String listarAgendamentos(Model model) {
        model.addAttribute("agendamentos", agendaService.listarTodos());
        return "agenda/listar";
    }

    @GetMapping("/novo")
    public String novoAgendamentoForm(Model model) {
        List<Medico> medicos = medicoService.listarTodos();
        List<Paciente> pacientes = pacienteService.listarTodos();

        model.addAttribute("agenda", new Agenda());
        model.addAttribute("medicos", medicos);
        model.addAttribute("pacientes", pacientes);
        return "agenda/form";
    }

    @PostMapping
    public String salvarAgendamento(@ModelAttribute Agenda agenda) {
        agendaService.salvar(agenda);
        return "redirect:/agenda";
    }

    @GetMapping("/editar/{id}")
    public String editarAgendamentoForm(@PathVariable Long id, Model model) {
        Agenda agenda = agendaService.buscarPorId(id);
        List<Medico> medicos = medicoService.listarTodos();
        List<Paciente> pacientes = pacienteService.listarTodos();

        model.addAttribute("agenda", agenda);
        model.addAttribute("medicos", medicos);
        model.addAttribute("pacientes", pacientes);
        return "agenda/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirAgendamento(@PathVariable Long id) {
        agendaService.excluir(id);
        return "redirect:/agenda";
    }
}
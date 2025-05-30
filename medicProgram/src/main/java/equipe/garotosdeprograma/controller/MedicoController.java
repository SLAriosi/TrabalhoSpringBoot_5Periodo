package equipe.garotosdeprograma.controller;

import equipe.garotosdeprograma.model.Medico;
import equipe.garotosdeprograma.service.MedicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public String listarMedicos(Model model) {
        model.addAttribute("medicos", medicoService.listarTodos());
        return "medicos/listar";
    }

    @GetMapping("/novo")
    public String novoMedicoForm(Model model) {
        model.addAttribute("medico", new Medico());
        return "medicos/form";
    }

    @PostMapping
    public String salvarMedico(@ModelAttribute Medico medico) {
        medicoService.salvar(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/editar/{id}")
    public String editarMedicoForm(@PathVariable Long id, Model model) {
        model.addAttribute("medico", medicoService.buscarPorId(id));
        return "medicos/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirMedico(@PathVariable Long id) {
        medicoService.excluir(id);
        return "redirect:/medicos";
    }
}
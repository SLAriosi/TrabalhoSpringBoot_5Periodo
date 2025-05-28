package equipe.garotosdeprograma.controller;

import equipe.garotosdeprograma.model.Medico;
import equipe.garotosdeprograma.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public String listarMedicos(Model model) {
        model.addAttribute("medicos", medicoService.listarTodos());
        return "medico/lista";
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovoMedico(Model model) {
        model.addAttribute("medico", new Medico());
        return "medico/formulario";
    }

    @PostMapping
    public String salvarMedico(@ModelAttribute Medico medico) {
        medicoService.salvar(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarMedico(@PathVariable Long id, Model model) {
        Medico medico = medicoService.buscarPorId(id);
        if (medico != null) {
            model.addAttribute("medico", medico);
            return "medico/formulario";
        } else {
            return "redirect:/medicos";
        }
    }

    @PostMapping("/editar/{id}")
    public String atualizarMedico(@PathVariable Long id, @ModelAttribute Medico medico) {
        medico.setId(id);
        medicoService.salvar(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/excluir/{id}")
    public String excluirMedico(@PathVariable Long id) {
        medicoService.excluir(id);
        return "redirect:/medicos";
    }
}

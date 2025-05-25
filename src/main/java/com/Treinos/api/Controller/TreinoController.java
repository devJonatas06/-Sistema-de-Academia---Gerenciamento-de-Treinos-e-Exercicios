package com.Treinos.api.Controller;

import com.Treinos.api.entity.Exercicio;
import com.Treinos.api.entity.Treino;
import com.Treinos.api.service.ExercicioService;
import com.Treinos.api.service.TreinoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/treinos")
public class TreinoController {

    private TreinoService treinoService;
private ExercicioService exercicioService;

    public TreinoController(ExercicioService exercicioService, TreinoService treinoService) {
        this.exercicioService = exercicioService;
        this.treinoService = treinoService;
    }

    @GetMapping("/exercicios")
    public String verExerciciosDoTreino(@RequestParam("treinoId") int treinoId, Model model) {
        Treino treino = treinoService.findById(treinoId);
        List<Exercicio> exercicios = exercicioService.findByTreinoId(treinoId);

        model.addAttribute("treino", treino);
        model.addAttribute("exercicios", exercicios);

        return "treinos/exercicios-do-treino"; // view que lista os exercícios daquele treino
    }

    @GetMapping("/list")
    public String listTreinos(Model model) {
        List<Treino> treinos = treinoService.findAll();
        model.addAttribute("treinos", treinos);  // nome plural para lista
        return "treinos/list-treino";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Treino treino = new Treino();
        model.addAttribute("treino", treino);  // nome singular para objeto
        return "treinos/treino-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("treinoId") int id, Model model) {
        Treino treino = treinoService.findById(id);
        model.addAttribute("treino", treino);
        return "treinos/treino-form";
    }

    @PostMapping("/save")
    public String saveTreino(@ModelAttribute("treino") Treino treino) {
        treinoService.save(treino);
        return "redirect:/treinos/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("treinoId") int id) {
        treinoService.deleteById(id);
        return "redirect:/treinos/list";
    }
}


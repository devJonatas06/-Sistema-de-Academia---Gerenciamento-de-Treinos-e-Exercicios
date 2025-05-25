package com.Treinos.api.Controller;

import com.Treinos.api.entity.Exercicio;
import com.Treinos.api.entity.Treino;
import com.Treinos.api.service.ExercicioService;
import com.Treinos.api.service.TreinoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exercicios")
public class ExercicioController {
        private ExercicioService exercicioService;
        private TreinoService treinoService;

        // Injete ambos via construtor
        public ExercicioController(ExercicioService exercicioService, TreinoService treinoService) {
            this.exercicioService = exercicioService;
            this.treinoService = treinoService;
        }


    @GetMapping("/list")
    public String listExercicios(Model model) {
        List<Exercicio> exercicios = exercicioService.findAll();
        model.addAttribute("exercicios", exercicios);  // plural para lista
        return "exercicios/list-exercicio"; // nome da view para lista de exercícios
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Exercicio exercicio = new Exercicio();
        model.addAttribute("exercicio", exercicio);

        List<Treino> treinos = treinoService.findAll();  // Você precisa ter o treinoService injetado aqui
        model.addAttribute("treinos", treinos);

        return "exercicios/exercicio-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("exercicioId") int id, Model model) {
        Exercicio exercicio = exercicioService.findById(id);
        model.addAttribute("exercicio", exercicio);

        List<Treino> treinos = treinoService.findAll();
        model.addAttribute("treinos", treinos);

        return "exercicios/exercicio-form";
    }


    @PostMapping("/save")
    public String saveExercicio(@ModelAttribute("exercicio") Exercicio exercicio, BindingResult result) {
        if (result.hasErrors()) {
            return "exercicios/exercicio-form";
        }
        exercicioService.save(exercicio);
        return "redirect:/exercicios/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("exercicioId") int id) {
        exercicioService.deleteById(id);
        return "redirect:/exercicios/list";
    }
}

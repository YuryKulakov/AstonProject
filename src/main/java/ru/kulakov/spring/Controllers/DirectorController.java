package ru.kulakov.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kulakov.spring.Model.Director;
import ru.kulakov.spring.services.DirectorService;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/directors")
public class DirectorController {
    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("directors", directorService.findAll());
        return "directors/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("director", directorService.findById(id));
        return "directors/show";
    }

    @GetMapping("/new")
    public String newDirector(Model model) {
        model.addAttribute("director", new Director());
        return "directors/new";
    }

    @PostMapping
    public String create(@ModelAttribute("director") @Valid Director director, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "directors/new";
        }
        directorService.save(director);
        return "redirect:/directors";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("director", directorService.findById(id));
        return "directors/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("director") @Valid Director director,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "directors/edit";
        }
        directorService.update(id, director);
        return "redirect:/directors";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        directorService.delete(id);
        return "redirect:/directors";

    }
}

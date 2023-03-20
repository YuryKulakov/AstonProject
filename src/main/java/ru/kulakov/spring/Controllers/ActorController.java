package ru.kulakov.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kulakov.spring.Model.Actor;
import ru.kulakov.spring.services.ActorService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/actors")
public class ActorController {
    private final ActorService actorService;
    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("actors", actorService.findAll());
        return "actors/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("actor", actorService.findById(id));
        return "actors/show";
    }

    @GetMapping("/new")
    public String newActor(Model model) {
        model.addAttribute("actor", new Actor());
        return "actors/new";
    }

    @PostMapping
    public String create(@ModelAttribute("actor") @Valid Actor actor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "actors/new";
        }
        actorService.save(actor);
        return "redirect:/actors";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("actor", actorService.findById(id));
        return "actors/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("person") @Valid Actor actor,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "actors/edit";
        }
        actorService.update(id, actor);
        return "redirect:/actors";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        actorService.delete(id);
        return "redirect:/actors";

    }
}

package ru.kulakov.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kulakov.spring.Dao.ActorDAO;
import ru.kulakov.spring.Model.Actor;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/actors")
public class ActorController {
    private ActorDAO actorDAO;

    public ActorController(ActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("actors", actorDAO.index());
        return "actors/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("actor", actorDAO.show(id));
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
        actorDAO.save(actor);
        return "redirect:/actors";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("actor", actorDAO.show(id));
        return "actors/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("person") @Valid Actor actor,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "actors/edit";
        }
        actorDAO.update(id, actor);
        return "redirect:/actors";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        actorDAO.delete(id);
        return "redirect:/actors";

    }
}

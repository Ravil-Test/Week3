package ru.nurullin.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.nurullin.dao.IzdelieDAO;
import ru.nurullin.models.Izdelie;

import javax.validation.Valid;

@Controller
@RequestMapping("/konditerka")
public class IzdelieController {

    private final IzdelieDAO izdelieDAO;

    @Autowired
    public IzdelieController(IzdelieDAO izdelieDAO) {
        this.izdelieDAO = izdelieDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("konditerka", izdelieDAO.index());
        return "konditerka/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("izdelie", izdelieDAO.show(id));
        return "konditerka/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("izdelie") Izdelie izdelie) {
        return "konditerka/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("izdelie") @Valid Izdelie izdelie,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "konditerka/new";

        izdelieDAO.save(izdelie);
        return "redirect:/konditerka";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("izdelie", izdelieDAO.show(id));
        return "konditerka/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("izdelie") @Valid Izdelie izdelie, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "konditerka/edit";

        izdelieDAO.update(id, izdelie);
        return "redirect:/konditerka";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        izdelieDAO.delete(id);
        return "redirect:/konditerka";
    }
}
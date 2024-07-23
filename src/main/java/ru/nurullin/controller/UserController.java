package ru.nurullin.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.nurullin.entity.Owner;
import ru.nurullin.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Qualifier("getUserService")
    @Autowired
    public UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("owners", userService.findAll());
        return "usersList";
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("owner", userService.getById(id));
        return "showUser";
    }

    @GetMapping("/addUser")
    public String createUser() {
        return "createUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("owner", userService.getById(id));
        return "editUser";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute("owner") Owner owner,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "createUser";

        userService.save(owner);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@Valid @ModelAttribute("owner") Owner owner,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "editUser";

        userService.update(owner);
        return "redirect:/user/" + owner.getId();
    }
}

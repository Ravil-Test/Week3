package ru.nurullin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nurullin.entity.Supplier;
import ru.nurullin.service.SupplierService;

@Controller
@RequestMapping("/")
public class SupplierController {

    @Qualifier("getUserService")
    @Autowired
    public SupplierService supplierService;

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
        model.addAttribute("suppliers", supplierService.findAll());
        return "supplierList";
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("supplier", supplierService.getById(id));
        return "showSupplier";
    }

    @GetMapping("/addUser")
    public String createUser() {
        return "createSupplier";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        supplierService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("supplier", supplierService.getById(id));
        return "editSupplier";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("supplier") Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("supplier") Supplier supplier) {
        supplierService.update(supplier);
        return "redirect:/user/" + supplier.getId();
    }

}

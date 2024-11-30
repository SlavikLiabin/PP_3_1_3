package bootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import bootstrap.model.Role;
import bootstrap.model.User;
import bootstrap.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        List<Role> listOfRoles = userService.listAllRoles();
        model.addAttribute("listOfRoles", listOfRoles);
        return "/admin/admin";
    }

    @PostMapping("/create")
    public String create(User user) {
        userService.create(user);
        return "redirect:/admin";
    }

    @PatchMapping()
    public String update(@RequestParam("id") int id, User user) {
        userService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping()
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}

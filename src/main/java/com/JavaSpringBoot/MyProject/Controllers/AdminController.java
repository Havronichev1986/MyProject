package com.JavaSpringBoot.MyProject.Controllers;

import com.JavaSpringBoot.MyProject.Models.User;
import com.JavaSpringBoot.MyProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getUser(Model model) {
        Iterable<User> allUsers = new ArrayList<>();
        allUsers = userRepository.findAll();
        model.addAttribute("allUsers", allUsers);
        return  "admin";
    }

    @PostMapping("/{id}/remove")
    public String userDelete(@PathVariable(value = "id") long id, Model model){
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return "redirect:/admin";
    }
}

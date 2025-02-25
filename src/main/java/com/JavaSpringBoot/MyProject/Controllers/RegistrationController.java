package com.JavaSpringBoot.MyProject.Controllers;

import com.JavaSpringBoot.MyProject.Models.User;
import com.JavaSpringBoot.MyProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String showRegPage() {
        return "registration";
    }

    @PostMapping
    public String registerUser(@RequestParam(required = true, defaultValue = "!@") String username,
                               @RequestParam (required = true, defaultValue = "!@") String password) {
        if(!(username.equals("!@") & password.equals("!@"))) {
            System.out.println(username + " " + password);
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            if(userService.saveUser(user))
                System.out.println("GOOD");
            else
                System.out.println("BAD");
        }
        return "redirect:/home";
    }

}

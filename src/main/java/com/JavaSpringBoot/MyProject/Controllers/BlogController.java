package com.JavaSpringBoot.MyProject.Controllers;

import com.JavaSpringBoot.MyProject.Models.Purchases;
import com.JavaSpringBoot.MyProject.Models.User;
import com.JavaSpringBoot.MyProject.Repositories.PurchaseRepository;
import com.JavaSpringBoot.MyProject.Repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Data
@Controller
public class BlogController {
    @Autowired
    private PurchaseRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Purchases> purchases = postRepository.findAll();
        model.addAttribute("purchases", purchases);
        return "blog-main";
    }
    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }
    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title,@RequestParam String full_text, Model model){
        Purchases purchase = new Purchases(title,full_text);
        postRepository.save(purchase);
        return "redirect:/blog";
    }
//    @GetMapping("/blog/{id}")
//    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
//        if (!postRepository.existsById(id)){
//            return "blog";
//        }
//        Optional<Purchases> purchase = postRepository.findById(id);
//        ArrayList<Purchases> res = new ArrayList<>();
//        purchase.ifPresent(res::add);
//        model.addAttribute("purchase", res);
//        return "blog-details";
//    }
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)){
            return "blog";
        }
        Optional<Purchases> post = postRepository.findById(id);
        ArrayList<Purchases> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-edit";
    }
    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title,@RequestParam String full_text, Model model){
        Purchases post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model){
        Purchases post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }

    @GetMapping("/login")
    public String blogAuthorization(Model model) {
        return "login";
    }
}

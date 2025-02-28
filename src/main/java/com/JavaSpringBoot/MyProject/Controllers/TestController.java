package com.JavaSpringBoot.MyProject.Controllers;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("/testPage")
public class TestController {
    @GetMapping
    public String test(){
        return "testPage";
    }
}

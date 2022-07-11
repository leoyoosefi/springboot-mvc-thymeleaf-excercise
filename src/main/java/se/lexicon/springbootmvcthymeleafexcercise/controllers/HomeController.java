package se.lexicon.springbootmvcthymeleafexcercise.controllers;

import org.hibernate.mapping.Array;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController{

    List<String> contactList = new ArrayList<>();
    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @PostMapping("/contact")
    public String contact(@RequestParam("email") String email){
        System.out.println("email" + email);
        contactList.add(email);
        return "redirect:/contactList";
    }
@GetMapping("/contactList")
    public String contactList(Model model){
        model.addAttribute("contactList", contactList);
        return "contactList";
    }
}
package se.lexicon.springbootmvcthymeleafexcercise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home
{
    private List<String> contactList = new ArrayList<>();

    public Home() {
        contactList.add("Leo Yoosefi: 070-***8723");
    }

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam String contactInput){

        contactList.add(contactInput);
        return "contact";
    }

    @GetMapping("/list")
    public String contactList(Model model)
    {
        model.addAttribute("Contacts",contactList);

        return "contact";
    }

}
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
        System.out.println("default data");
        contactList.add("Leo Yoosefi: 070-***8723");
        contactList.add("Mehrdad Javan: 070-***9898");
        contactList.add("Anna Andersson: 070-***8433");
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String defaultURL() {
        System.out.println("##### default method executed ####");
        return "index";
    }


    @GetMapping("/home")
    public String home(){
        System.out.println("##### home method executed ####");
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        System.out.println("##### index method executed ####");
        return "index";
    }

    @GetMapping("/contact")
    public String displayContactForm(){
        System.out.println("##### contact method executed ####");
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam("contactInfo") String contact){
        System.out.println("Contact Info:" + contact);


        contactList.add(contact);
        return "contactInput";
    }

    @GetMapping("/contactList")
    public String contactList(Model model)
    {
        System.out.println("Number of Contacts: " + contactList.size());
        model.addAttribute("ContactList",contactList);

        return "contactList";
    }

}
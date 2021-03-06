package com.ederrafo.controller;


import com.ederrafo.model.UserCredential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(
            Model model,
            @RequestParam(name = "error",  required = false) String error,
            @RequestParam(name = "logout", required = false) String logout
            ) {
        model.addAttribute("userCredential", new UserCredential());
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);

        return "login/login";
    }

    //esta funcion recebira un model atribute ya que es un PostMapping
    @PostMapping("/loginCheck")
    public String loginCheck(@ModelAttribute(name = "userCredential")UserCredential userCredential) {

        if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
            return "contacts/contacts";
        }

        return "redirect:/login?error";
    }
}

package com.example.whatsappservice.Controller;

import com.example.whatsappservice.models.Utilisateur;
import com.example.whatsappservice.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        if (utilisateurRepository.existsByUsername(username)) {
            return "redirect:/register?error=username_exists";
        }

        Utilisateur user = new Utilisateur();
        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password)); // Encode password

        utilisateurRepository.save(user); // Save user to the repository

        return "redirect:/login";
    }
}

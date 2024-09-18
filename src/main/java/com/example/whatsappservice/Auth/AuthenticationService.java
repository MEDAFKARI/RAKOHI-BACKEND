package com.example.whatsappservice.Auth;
import com.example.whatsappservice.Repository.UtilisateurRepository;
import com.example.whatsappservice.config.JwtService;
import com.example.whatsappservice.enums.RoleUtilisateur;
import com.example.whatsappservice.models.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UtilisateurRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            return null;
        }
        var user = Utilisateur.builder()
                .username(request.getUsername())
                .motDePasse(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(RoleUtilisateur.USER))
                .build();
        var returnedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().Id(user.getId()).username(user.getUsername()).role(user.getRoles()).token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthRequest request) {
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found!!"));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var JwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().Id(user.getId()).username(user.getUsername()).role(user.getRoles()).token(JwtToken).build();
    }
}
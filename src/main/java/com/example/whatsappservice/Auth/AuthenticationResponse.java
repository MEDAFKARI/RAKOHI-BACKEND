package com.example.whatsappservice.Auth;
import com.example.whatsappservice.enums.RoleUtilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private Long Id;
    private String username;
    private Set<RoleUtilisateur> role;
    private String token;
}

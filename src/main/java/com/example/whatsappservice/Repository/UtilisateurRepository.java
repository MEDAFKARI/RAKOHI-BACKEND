package com.example.whatsappservice.Repository;

import com.example.whatsappservice.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    // Use the correct field name from Utilisateur class
    Optional<Utilisateur> findByUsername(String username);

    boolean existsByUsername(String username);
}

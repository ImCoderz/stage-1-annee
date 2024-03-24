package com.stock.app.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le nom est requis")
    private String nom;
    @NotBlank(message = "Le prénom est requis")
    private String prenom;
    private String adresse;
    @NotBlank(message = "L'email est requis")
    @Email(message = "L'email doit être valide")
    private String email;
    @NotBlank(message = "Le numéro de téléphone est requis")
    private String numeroTelephone;
    private String numeroRegistreCommerce;
    private String numeroMatriculeFiscale;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<CommandeClient> commandes;

}
